package sockets;

import java.io.Serializable;

public class Request implements Serializable {

	private String Contents;
	
	public Request(String a){
		this.Contents = a;
	}

	public String getContents() {
		return Contents;
	}

	public void setContents(String contents) {
		Contents = contents;
	}
	
}