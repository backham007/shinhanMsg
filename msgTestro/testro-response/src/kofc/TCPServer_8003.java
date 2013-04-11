package kofc;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * TCP SERVER
 * 
 * @author kangwoo
 * 
 */
public class TCPServer_8003 {
	private static int serverPort;
	private Selector sSelector = null;
	private ServerSocketChannel sChannel = null;
	private ServerSocket socket = null;
	
	// 한글 전송용
	Charset charset = Charset.forName("EUC-KR");
	CharsetEncoder encoder = charset.newEncoder();

	public void execute() {
		try {
			initServer();
			startSever();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * client 접속
	 * 
	 * @param key
	 * @throws Exception
	 */
	public void accept(SelectionKey key) throws Exception {
		if (!(key.channel() instanceof ServerSocketChannel)) {
			throw new Exception("Accept channel is not ServerSocketChannel!"
					+ key.channel());
		}

		SocketChannel client = ((ServerSocketChannel) key.channel()).accept();
		client.configureBlocking(false);
		// SelectionKey clientKey = tChannel.register(sSelector,
		// SelectionKey.OP_WRITE | SelectionKey.OP_READ);
		SelectionKey clientKey = client.register(sSelector,
				SelectionKey.OP_READ);
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		clientKey.attach(buffer);
	}

	/**
	 * clent input
	 * 
	 * @param key
	 * @throws Exception
	 */
	public void read(SelectionKey key) throws Exception {
		if (!(key.channel() instanceof SocketChannel)) {
			throw new Exception("Read channel is not SocketChannel!"
					+ key.channel());
		}

		SocketChannel client = (SocketChannel) key.channel();
		ByteBuffer buffer = (ByteBuffer) key.attachment();
		buffer.clear();
		int numRead;
		try {
			numRead = client.read(buffer);
		} catch (IOException e) {
			key.cancel();
			client.close();
			return;
		}

		if (numRead == -1) {
			key.channel().close();
			key.cancel();
			return;
		}
		buffer.flip();
		
		client.write(parseFlatMessage(buffer));
		key.cancel();
        client.close();
	}


	// TODO : 전문을 파싱하여 출력전문을 만들 보낸다.
	private ByteBuffer parseFlatMessage(ByteBuffer buffer) throws CharacterCodingException, UnsupportedEncodingException {
		
		// 입력전문 내용을 출력합니다.
		System.out.println("READ : [" + new String(buffer.array(),"euc-kr") + "]");
		
		//응답데이터
		StringBuffer stringBuffer = new StringBuffer();
		
		stringBuffer.append("0150         0020928100020000000120120213180445000000000000000000000N                                                                                     ");
					
		System.out.println("WRITE : [" + stringBuffer + "]");
		// output전문을 작성해서 보냅니다.
		return encoder.encode(CharBuffer.wrap(stringBuffer));
		
	}


	/**
	 * 서버실행
	 * 
	 * @throws Exception
	 */
	private void startSever() throws Exception {
		try {
			while (true) {
				try {
					sSelector.select();

					Iterator<SelectionKey> it = sSelector.selectedKeys()
							.iterator();

					SelectionKey key = null;
					while (it.hasNext()) {
						try {
							key = it.next();

							// consume read , accept event
							if (key.isValid()) {
								if (key.isConnectable()) {
									((SocketChannel) key.channel())
											.finishConnect();
								} else if (key.isReadable()) {
									read(key);
								} else if (key.isAcceptable()) {
									accept(key);
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
							if (key != null)
								key.cancel();
							if (key != null)
								try {
									key.channel().close();
								} catch (Exception ignore) {
								}
						} finally {
							it.remove();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (Exception ignore) {
				}
			}

			if (sChannel != null)
				sChannel.close();
		}
	}

	/**
	 * 서버초기화
	 * 
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	private void initServer() throws IOException, UnknownHostException {
		sSelector = Selector.open();

		sChannel = ServerSocketChannel.open();
		sChannel.configureBlocking(false);

		socket = sChannel.socket();

		SocketAddress address = new InetSocketAddress(serverPort);
		socket.bind(address);

		sChannel.register(sSelector, SelectionKey.OP_ACCEPT);

		System.err.println("Receiver socket :: "
				+ socket.getLocalSocketAddress() + " is initialized.");
	}

	/**
	 * 서버를 실행하는 메인메소드
	 * 
	 * @param args
	 *            포트설정
	 */
	public static void main(String[] args) {

		if (args.length > 0) {
			serverPort = Integer.parseInt(args[0]);
		} else {
			serverPort = 8003;
		}

		TCPServer_8003 s = new TCPServer_8003();
		s.execute();
	}
}
