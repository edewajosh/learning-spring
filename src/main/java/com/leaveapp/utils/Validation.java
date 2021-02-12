package com.leaveapp.utils;

public class Validation {
	
	public String isEmpty(String value) {
		String warning = null;
		if (value.isEmpty() || value == null) {
			warning = "Value cannot be empty";
		}
		return warning;
	}

}
