package com.unifaj.tcc.curriculo.CurriculoWeb.utils;

public class FormatarCPFtoString {

    public static String format(String format) {
		format = format.replace(".", "");
		format = format.replace("-", "");
		return format;
	}
    
}
