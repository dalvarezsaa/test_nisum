package com.test.nisum.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorUtils {
	
	public static boolean correoValido(String correo) {
		
		Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		
		Matcher mather = pattern.matcher(correo);
		
		if (mather.find() == true) {
            return true;
        } else {
            return false;
        }
	}
	
	public static boolean passwordValida(String pass) {
		
		Pattern pattern = Pattern
                .compile("(?=.*\\d{2,})(?=.*[A-Z])(?=.*[a-z])");
		
		Matcher mather = pattern.matcher(pass);
		
		if (mather.find() == true) {
            return true;
        } else {
            return false;
        }
	}
}
