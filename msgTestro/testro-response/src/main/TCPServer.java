package main;
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
public class TCPServer {
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
		
		// 입력전문 식별 (첫번째 필드 8자리는 길이필드, 두번째 필드 8자리는 거래코드로 가정   
		String strbuf = new String(buffer.array()).substring(8,16);
		
		StringBuffer stringBuffer = new StringBuffer();
		
		System.out.println( "거래코드 : "+strbuf );

		if( strbuf.equals("ABC00001") )
		{
			///////////////////
			// SLDE00002B_O
			///////////////////			
			// 시스템헤더부
			stringBuffer.append("0172ABC00001YN000001");
			
			// 거래부
			stringBuffer.append("아이지오            0000567890120000003210210004569712580003851-21-1111100000000001234567890855-28-2222200000000987654321065856-22-2222200000000000004567890");
			
			
		}
		else if( strbuf.equals("BBB00001") )
		{
			///////////////////
			// BBB00001
			///////////////////			
			
			// 전문데이터부 : 
			// error 전문 식별
			String errbuf = new String(buffer.array()).substring(14,15);
			
			if( errbuf.equals("E"))
			{
				// 시스템헤더부
				stringBuffer.append("0172BBB00001YNE00002");
				// 에러메시지
				stringBuffer.append("CODE02    메시지-정상 등록 되지 않았 습니다.                                                                              ");
			}
			else
			{
				// 시스템헤더부
				stringBuffer.append("0172BBB00001YN000001");
				// 정상출력
				stringBuffer.append("CODE01    메시지-정상 등록 되었 습니다.                                                                                   ");
			}		
		}
		else {
			
			// 입력전문 재식별
			strbuf = new String(buffer.array(),"euc-kr").substring(16,24);
			
			System.out.println( "거래코드 : "+strbuf );
			
			if( strbuf.equals("TES12345") )
			{
				///////////////////
				// TES12345
				///////////////////			
				
				//헤더부
				String headerHexString = "180000000005303646090E00434E353034513031203032303030303000000000";
				
				// 개별부
				String inviString = "";
				
				Random random = new Random();
				int randomInt = random.nextInt(10);
				if(randomInt == 0){
					inviString = "자료가 존재하지 않습니다...                                                     ";
				} else if(randomInt == 1){
					inviString = "정상처리 되었습니다.                                                            11989033700882012011620120130%%%%           120120130103105501989033700881104569202140005           0           1          10           0           0           0           0           0           0          1106353300차정자                                  01       7209012544113권유희망/안정형                         200902200241129523702만기관리                      14신용대출                      N20120125       7209012******위탁                                    mungmira@hanmail.net                    Y010-4049-7621       Y마선자                  08511800김덕훈                                  01       6309081055218권유희망/공격투자형                     201102030241132312002만기관리                      14신용대출                      N20120125       6309081******위탁                                    km6398@yahoo.co.kr                      Y010-6398-0053       Y마선자                  02062140김학순                                  01       5806281481511권유희망/공격투자형                     201109200241126390402만기관리                      14신용대출                      N20120130       5806281******위탁                                    hwan2523@mobis.co.kr                    N010-5896-2523       Y마선자                  06353300차정자                                  01       7209012544113권유희망/안정형                         200902200241126886102만기관리                      14신용대출                      N20120130       7209012******위탁                                    mungmira@hanmail.net                    Y010-4049-7621       Y마선자                  10310550금동춘                                  01       6001252810219권유불원/정보미제공                     201109160881104569202만기관리                      14신용대출                      N20120130       6001252******위탁                                    solarstill114@lycos.co.kr               Y010-4519-3205       Y마선자                                                                                                                                                                                                                                                                                                                                                                              ";
				} else if(randomInt == 2){
					inviString = "정상처리 되었습니다.                                                            11995204750032012011620120123%%%%           120120116042389701995204750031199023801080001           0           1           0           0           0           0           0           0           0           104238970진흥저축은행주식회사                    04          1048133253미등록                                          0031199023801미수/미납                     08미수                          N20120116          1048133***위탁                                    kmspjw@hanafos.com                      Y--                  N민경업                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ";
				} else if(randomInt == 3){
					inviString = "정상처리 되었습니다.                                                            12002006460882012011620120123%%%%           120120120098742102002006460889103367502180005           0           1           2           0           0           0           1           1           0           501545850이건규                                  01       5410101806413미등록                                          0241110330201미수/미납                     08미수                          N20120116       5410101******위탁                                                                            N010-2850-9256       Y가희정                  05785320주정일                                  01       7305051144316권유희망/적극투자형                     201012210882500522910자동이체/대체                 23미처리내역                    N20120116       7305051******한화2.2배레버리지인덱스[주식파생재간접]Ajuji@spg.co.kr                          Y011-9922-8665       Y가희정                  09931390권영준                                  01       8212051253715권유희망/적극투자형                     201007290241135416607알림정보                      31채권이자발생                  N20120116       8212051******위탁                                                                            Y010-9172-3381       Y가희정                  09931390권영준                                  01       8212051253715권유희망/적극투자형                     201007290249108806402만기관리                      18RP만기                        N20120116       8212051******RP                                                                              Y010-9172-3381       Y가희정                  09874210심우기                                  01       3804061154914권유희망/안정추구형                     201011020889103367502만기관리                      18RP만기                        N20120120       3804061******RP                                                                              N011-9259-8690       Y가희정                                                                                                                                                                                                                                                                                                                                                                              ";
				} else if(randomInt == 4){
					inviString = "정상처리 되었습니다.                                                            21994154750492012011620120123%%%%           120120116045494001999104540491110842302150006           1           2          16           0           0           0          12           0           0          3101234090신홍인                                  01       5112291143611권유희망/적극투자형                     201012140491108812007알림정보                      31채권이자발생                  N20120116       5112291******위탁                                                                            Y010-3420-6108       Y이은경                  02807260정창화                                  01       6305211899125권유희망/위험중립형                     201110270381152511607알림정보                      31채권이자발생                  N20120116       6305211******위탁                                    h8813210@naver.com                      Y010-4247-7345       Y이정은                  03443370이석                                    01       6902091010411권유희망/위험중립형                     201108290171120779301미수/미납                     08미수                          N20120116       6902091******위탁                                    sjslee@unitel.co.kr                     Y010-4112-3201       Y이은경                  04009490홍명심                                  01       4611182350826권유희망/안정추구형                     201001280491110608802만기관리                      15채권/장파                     N20120116       4611182******위탁                                                                            N011-9842-5711       N이정은                  04158760윤여현                                  01       5803071351312권유희망/적극투자형                     200909150491101388801미수/미납                     08미수                          N20120116       5803071******위탁                                    cheongnamdae@yahoo.co.kr                Y010-2212-6088       Y강진희                  04549400최현옥                                  01       5910092351117권유희망/위험중립형                     201002260491110842302만기관리                      15채권/장파                     N20120116       5910092******위탁                                                                            Y016-485-5766        N이은경                  ";
				} else if(randomInt == 5){
					inviString = "정상처리 되었습니다.                                                            11994011400132012011620120123%%%%           120120117005335801994011400132512826002B50002           0           0           1           0           0           0           1           0           0           201433060이순복                                  01       5310102774516권유희망/공격투자형                     200911170131134213107알림정보                      31채권이자발생                  N20120116       5310102******위탁                                                                            Y010-9690-1144       Y최진미                  00533580전일규                                  01       4203201815512권유희망/공격투자형                     200911060132512826002만기관리                      B5수익증권만기                  N20120117       4203201******한화꿈에그린차이나증권투자신탁1호[주식]C                                        Y011-9366-5329       Y최진미                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  ";
				} else if(randomInt == 6){
					inviString = "자료가 존재하지 않습니다...                                                     ";
				} else if(randomInt == 7){
					inviString = "정상처리 되었습니다.                                                            12009018730832012011620120123%%%%           120120120061071902009018730679106302402180003           0           1           2           0           0           0           0           0           0           308150580우진경                                  01       6202252779136권유희망/적극투자형                     201103100831101540102만기관리                      15채권/장파                     N20120116       6202252******위탁                                    dnrydhr@hanmail.net                     Y010-8942-5351       Y백승준                  09400650최경윤                                  01       7503071042610권유희망/적극투자형                     201010310831104540801미수/미납                     08미수                          N20120116       7503071******위탁                                    choiky01@kita.net                       Y010-2536-1746       Y백승준                  06107190정소영                                  01       7710192641537권유희망/정보미제공                     201109260679106302402만기관리                      18RP만기                        N20120120       7710192******RP                                      why1019@nate.com                        Y010-9105-4929       N백승준                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      ";
				} else if(randomInt == 8){
					inviString = "정상처리 되었습니다.                                                            11999104510132012011620120123%%%%           120120116095342101999104510131136433307310006           0           0           4           0           0           0           3           0           0           700284330박홍락                                  01       3604131812311권유희망/안정추구형                     201010250131137259107알림정보                      31채권이자발생                  N20120116       3604131******위탁                                                                            N011-521-3541        N박정희                  06105450김태자                                  01       5502242100912권유희망/적극투자형                     201012140131126556307알림정보                      31채권이자발생                  N20120116       5502242******위탁                                                                            N017-543-4616        Y박정희                  06463300임향란                                  01       7007212812342미등록                                          0139105862302만기관리                      18RP만기                        N20120116       7007212******RP                                                                              Y010-6291-8862       Y박정희                  06463300임향란                                  01       7007212812342미등록                                          0139105863102만기관리                      18RP만기                        N20120116       7007212******RP                                                                              Y010-6291-8862       Y박정희                  06635690최현준                                  01       0205143730119권유희망/안정형                         200904160139102418702만기관리                      18RP만기                        N20120116       0205143******RP                                                                              N010-6291-8862       N박정희                  09534210이상금                                  01       6706202730512권유희망/공격투자형                     201012140131136433307알림정보                      31채권이자발생                  N20120116       6706202******위탁                                                                            Y011-824-7855        N박정희                  ";
				} else if(randomInt == 9){
					inviString = "정상처리 되었습니다.                                                            12000102990542012011620120123%%%%           120120116072175102000102990549108822402180002           0           1           1           0           0           0           0           0           0           206054550황종원                                  01       6305281803214권유불원/적극투자형                     201101120541102130501미수/미납                     08미수                          N20120116       6305281******위탁                                    jwhwang@kccworld.co.kr                  N011-686-0417        Y원종찬                  07217510신인철                                  01       7507201781111권유희망/위험중립형                     201012130549108822402만기관리                      18RP만기                        N20120116       7507201******RP                                                                              Y010-7220-1244       Y원종찬                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  ";
				}
			
				
				int length = Utils.hexToByteArray(headerHexString).length + inviString.getBytes("euc-kr").length;
				String lengthString = Utils.lpad(Integer.toHexString(length), 8, '0');
				
				byte[] header = Utils.hexToByteArray( headerHexString );
				byte[] invi = inviString.getBytes("euc-kr");
								
				byte[] msg = new byte[Utils.hexToByteArray(lengthString).length + header.length + invi.length];
				System.arraycopy(Utils.hexToByteArray(lengthString), 0, msg, 0, Utils.hexToByteArray(lengthString).length);
				System.arraycopy(header, 0, msg, Utils.hexToByteArray(lengthString).length, header.length);
				System.arraycopy(invi, 0, msg, Utils.hexToByteArray(lengthString).length + header.length, invi.length);
				
				//stringBuffer.append("@@");
				System.out.println("WRITE : [" + new String(msg,"euc-kr") + "]");
				// output전문을 작성해서 보냅니다.
				return ByteBuffer.wrap(msg);
				
			} else {
				
				//레이아웃DB에서 거래코드 조회
				// 입력전문 식별 (첫번째 필드 8자리는 길이필드, 두번째 필드 8자리는 거래코드로 가정   
				strbuf = new String(buffer.array()).substring(89,98);
				
				System.out.println( "거래코드 : "+strbuf );
				
				byte[] msg = MakeResponse.getInstance().getResponse(strbuf);
				
				if(msg == null || msg.length == 0){
					// 입력전문 재식별 
					strbuf = new String(buffer.array(),"euc-kr").substring(16,24);
					
					System.out.println( "거래코드 : "+strbuf );
					
					msg = MakeResponse.getInstance().getResponse(strbuf);
				}
				
				//stringBuffer.append("@@");
				System.out.println("WRITE : [" + new String(msg,"euc-kr") + "]");
				// output전문을 작성해서 보냅니다.
				return ByteBuffer.wrap(msg);
			}
		}
			
		// 전문종료부
		//stringBuffer.append("@@");
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
			serverPort = 12345;
		}

		TCPServer s = new TCPServer();
		s.execute();
	}
}
