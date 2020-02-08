package com.example.demo.common;

public enum RestCode {
	OK(200,"ok"),

	UNKNOWN_ERROR(1,"未知异常"),

	//for page
	WRONG_PAGE(10100,"页码不合法"),
	LACK_PARAMS(10101,"缺少参数"),

	//for user
	TOKEN_INVALID(2,"TOKEN失效"),
	USER_NOT_EXIST(3,"用户不存在"),


	//for storage service
	STORAGE_FAILURE(10100,"cloud file storage failure"),
	STORAGE_REMOVE_FAILURE(10101,"cloud file removing failure"),

	//for issue attachment
	ISSUE_ATTACHMENT_INSERT_FAILURE(20100,"issue attachment insert failure"),
	ISSUE_ATTACHMENT_REMOVE_FAILURE(20200,"issue attachment remove failure"),
	ISSUE_ATTACHMENT_QUERY_FAILURE(20300,"issue attachment remove failure");

	public final int code;
	public final String msg;
	
	private RestCode(int code,String msg){
		this.code = code;
		this.msg = msg;
	}

}
