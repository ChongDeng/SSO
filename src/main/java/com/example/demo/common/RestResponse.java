package com.example.demo.common;

public class RestResponse<T> {
	private int code;
	private String msg;
	private T result;

	public RestResponse(){
		this(RestCode.OK.code,RestCode.OK.msg);
	}

	public RestResponse(int code,String msg){
		this.code = code;
		this.msg = msg;
	}

	public static <T> RestResponse<T> success(){
		return new RestResponse<T>();
	}
	
	public static <T> RestResponse<T> success(T result){
		RestResponse response = new RestResponse<T>();
		response.setData(result);
		return response;
	}
	
	public static <T> RestResponse<T> error(RestCode code){
		return new RestResponse<T>(code.code,code.msg);
	}

	public int getErrCode() {
		return code;
	}
	public void setErrCode(int code) {
		this.code = code;
	}
	public String getErrMsg() {
		return msg;
	}
	public void setErrMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return result;
	}
	public void setData(T result) {
		this.result = result;
	}



}
