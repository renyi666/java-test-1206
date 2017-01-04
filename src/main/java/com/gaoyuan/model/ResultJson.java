package com.gaoyuan.model;

import java.util.ArrayList;

/**
 * json返回数据
 * @author xiaoqiang1006
 *
 */
public class ResultJson {

	private boolean success;
	private String msg;
	private  Object list;

	public Object getList() {
		return list;
	}

	public void setList(Object list) {
		this.list = list;
	}

	public boolean getSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
