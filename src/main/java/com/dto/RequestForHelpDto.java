package com.dto;


import javax.persistence.Enumerated;
import com.model.DonationType;

public class RequestForHelpDto {
	
	//fields
	private int requestId;
	private String needyPersonName;
	private String phone;
	private String item;
	private String status;
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getNeedyPersonName() {
		return needyPersonName;
	}
	public void setNeedyPersonName(String needyPersonName) {
		this.needyPersonName = needyPersonName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "RequestForHelpDto [requestId=" + requestId + ", needyPersonName=" + needyPersonName + ", phone=" + phone
				+ ", item=" + item + ", status=" + status + "]";
	}

	
	
}
