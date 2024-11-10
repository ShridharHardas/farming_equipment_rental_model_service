package org.dnynyog.enums;

public enum ResponceCode {
	INCOMPLETE_DATA("USER001","Fail","incomplete data sent"),
	REGISTER_SUCCESS("0000","Success","user registration successfully..!"),
	LOGIN_SUCCESS("0000","Success","login successfully..!"),
	LOGIN_FAILED("USER003","Failed","Invalid Credential..!"),
	OTP_SENT_SUCCESS("0000","Success","otp sent successfully..!"),
	OTP_SENT_FAILED("USER004","Failed","invalid credential"),
	CATCH_BLOCK_ERROR("USER002","Fail","catch block exception");
	
	private final String code;
	private final String status;
	private final String message;
	
	ResponceCode(String code,String status,String message) {
		this.code=code;
		this.status=status;
		this.message=message;
	}

	public String getCode() {
		return code;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}
	
	
	
}
