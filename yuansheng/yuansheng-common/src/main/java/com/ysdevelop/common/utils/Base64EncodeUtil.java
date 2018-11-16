package com.ysdevelop.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Base64EncodeUtil {

	private static char[] base64EncodeChars = new char[] { 
	            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 
	            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 
	            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 
	            'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 
	            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 
	            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 
	            'w', 'x', 'y', 'z', '0', '1', '2', '3', 
	            '4', '5', '6', '7', '8', '9', '+', '/' }; 
	    	
	public final static String base64Encode(byte[] data) { 
		StringBuffer sb = new StringBuffer(); 
        int len = data.length; 
        int i = 0; 
        int b1, b2, b3; 
        while (i < len) { 
            b1 = data[i++] & 0xff; 
            if (i == len) 
            { 
                sb.append(base64EncodeChars[b1 >>> 2]); 
                sb.append(base64EncodeChars[(b1 & 0x3) << 4]); 
                sb.append("=="); 
                break; 
            } 
            b2 = data[i++] & 0xff; 
            if (i == len) 
            { 
                sb.append(base64EncodeChars[b1 >>> 2]); 
                sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]); 
                sb.append(base64EncodeChars[(b2 & 0x0f) << 2]); 
                sb.append("="); 
                break; 
            } 
            b3 = data[i++] & 0xff; 
            sb.append(base64EncodeChars[b1 >>> 2]); 
            sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]); 
            sb.append(base64EncodeChars[((b2 & 0x0f) << 2) | ((b3 & 0xc0) >>> 6)]); 
            sb.append(base64EncodeChars[b3 & 0x3f]); 
        } 
        return sb.toString(); 
    }
	 
	
	
	/**
     * base64编码
     * @param str 内容       
     * @param charset 编码方式
	 * @throws UnsupportedEncodingException 
     */
	public static String base64(String str, String charset) throws UnsupportedEncodingException{
		String encoded = Base64EncodeUtil.base64Encode(str.getBytes(charset));
		return encoded;    
	}	
	
	public static String urlEncoder(String str, String charset) throws UnsupportedEncodingException{
		String result = URLEncoder.encode(str, charset);
		return result;
	}
	    
}
