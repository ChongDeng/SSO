package com.example.demo.common;

public class RestResponse<T> {
	private int code;
	private String msg;
	private T result;

	//step 1: 两个构造函数
	public RestResponse(){
		this(RestCode.OK.code,RestCode.OK.msg);
	}

	public RestResponse(int code,String msg){
		this.code = code;
		this.msg = msg;
	}

	//step 2: 两个成功返回的函数
	public static <T> RestResponse<T> success(){
		return new RestResponse<T>();
	}
	
	public static <T> RestResponse<T> success(T result){
		RestResponse response = new RestResponse<T>();
		response.setData(result);
		return response;
	}

	//step 3: 两个错误返回的函数
	public static <T> RestResponse<T> error(RestCode code){
		return new RestResponse<T>(code.code,code.msg);
	}

	public static <T> RestResponse<T> error(int code, String msg){
		return new RestResponse<T>(code, msg);
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
