package com.empyra.userplugin.exception;

import java.io.Serializable;

public class EmpyraWSException extends Exception implements Serializable {

	private static final long serialVersionUID = 7925882961279768635L;

	protected Throwable rootCause;
	protected String code;
	protected String message;

	public EmpyraWSException() {
	}

	public EmpyraWSException(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public EmpyraWSException(Throwable rootCause) {
		this.rootCause = rootCause;
	}

	public EmpyraWSException(String code, String message, Throwable rootCause) {
		this.code = code;
		this.message = message;
		this.rootCause = rootCause;
	}

	/**
	 * Method 'getCause'
	 * 
	 * @return Throwable
	 */
	public Throwable getCause() {
		return rootCause;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
