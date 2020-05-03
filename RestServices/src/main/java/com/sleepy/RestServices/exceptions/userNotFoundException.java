package com.sleepy.RestServices.exceptions;

import javassist.SerialVersionUID;

public class userNotFoundException extends Exception {
	public static final long SerialVersionUID=1L;
	
	public  userNotFoundException(String s) {
		super(s);
	}

}
