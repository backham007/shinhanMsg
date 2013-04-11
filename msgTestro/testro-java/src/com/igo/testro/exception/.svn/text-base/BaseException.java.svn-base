package com.igo.testro.exception;


/**
 * <p>
 * 프로그램명:BaseException.java<br>
 * 변경이력<br>
 * <ul>
 *	  <li>2012. 2. 14. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
public class BaseException extends RuntimeException {

	private String errorCode;
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Constructor initializes the error code.
	 * @param errorCode unique identifier for an error
	 */
	public BaseException(String errorCode) {
		super();
		this.errorCode = errorCode;
	}

	/**
	 * Constructor initializes the error code and message.
	 * @param errorCode unique identifier for an error
	 * @param message Message related to the error.
	 */
	public BaseException(String errorCode, String message) {
		super(message);
	}

	/**
	 * If the exception object caught is a BusinessException, then value of the trace
	 * information and severity level are retained by assigning the traceinfo 
	 * object of caught exception into to the new exception object.
	 * @param errorCode unique identifier for an error
	 * @param message Message related to the error.
	 * @param cause Throwable object which carries error.
	 */
	public BaseException(String errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

}
