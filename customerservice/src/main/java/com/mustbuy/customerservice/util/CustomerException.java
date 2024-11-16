package com.mustbuy.customerservice.util;

public class CustomerException extends Exception{

	private static final long serialVersionUID = 1L;
	
    public CustomerException(Throwable e, String message) {
    	super(e);
    }
    

}
