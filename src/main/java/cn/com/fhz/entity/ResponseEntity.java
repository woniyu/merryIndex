package cn.com.fhz.entity;

import com.alibaba.fastjson.JSONObject;

import java.util.Calendar;
import java.util.Date;

public class ResponseEntity {
	private Integer code=0;		//0是成功，非0是失败
	private String message="OK";//错误信息，成功时返回OK
	private Object data=null;
	private Date updatetime=new Date();
	
	public ResponseEntity() {
	}
	public ResponseEntity(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	public ResponseEntity(Integer code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	@Override
	public String toString() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(updatetime);
		String jsonDataStr = JSONObject.toJSONString(data);
		return "{\"code\":"+code+",\"data\":"+jsonDataStr+",\"message\":\""+message+"\", \"updatetime\":"+cal.getTimeInMillis()+" } ";
	}
	
}
