package com.member.controller;

import java.util.regex.Pattern;

public class Authorizations {
	
	public static boolean isValidName(String inputName) {
		String regex = "^[\\p{L}\\p{N}\\p{IsHan}]{1,20}$";
		return Pattern.matches(regex, inputName);
	}

	public static boolean isValidAddress(String inputAddress) {
		String regex = "^[\\p{N}\\p{IsHan}]{1,50}$";
		return Pattern.matches(regex, inputAddress);
	}

	public static boolean isValidPassword(String inputPassword) {
		String regex = "^[a-zA-Z0-9]{7,20}$";
		return Pattern.matches(regex, inputPassword);
	}

	public static boolean isValidAccount(String inputAccount) {
		String regex = "^[a-zA-Z0-9]{1,20}$";
		return Pattern.matches(regex, inputAccount);
	}

	public static boolean isValidPhoneNumber(String inputPhone) {
		String regex = "^09[0-9]{8}$";
		return Pattern.matches(regex, inputPhone);
	}
}
