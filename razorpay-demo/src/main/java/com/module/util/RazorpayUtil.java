package com.module.util;

public class RazorpayUtil {
	private static final String RAZORPAY_KEY_ID = "enter_api_key_id_here";
	private static final String RAZORPAY_KEY_SECRET = "enter_api_key_secret_here";
	
	public static String getRazorpayKeyId() {
		return RAZORPAY_KEY_ID;
	}

	public static String getRazorpayKeySecret() {
		return RAZORPAY_KEY_SECRET;
	}
}
