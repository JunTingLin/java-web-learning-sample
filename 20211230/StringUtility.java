package com.gjun.functions;

public class StringUtility {
	//�ǻ��r��P���j�Ÿ� �i��r����Φ��r��}�C
	public static String[] split(String source,String sp) {
		//�r�����
		return source.split(sp);
	}
	//�ഫ�j�g
	public static String caseUpper(String source) {
		return source.toUpperCase();
	}
	
	//�ഫ�p�g
	public static String caseLower(String source) {
		return source.toLowerCase();
	}

}
