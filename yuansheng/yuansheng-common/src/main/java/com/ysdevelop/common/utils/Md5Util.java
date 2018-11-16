package com.ysdevelop.common.utils;

import java.security.MessageDigest;

public class Md5Util {

	public final static String MD5(String s) {  
        //16进制下数字到字符的映射数组    
       char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',  
               'a', 'b', 'c', 'd', 'e', 'f' };  
       try {  
           byte[] strTemp = s.getBytes();  
           MessageDigest mdTemp = MessageDigest.getInstance("MD5");  
           mdTemp.update(strTemp);  
           byte[] md = mdTemp.digest();  
           int j = md.length;  
           char str[] = new char[j * 2];  
           int k = 0;  
           for (int i = 0; i < j; i++) {  
               byte byte0 = md[i];  
               str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
               str[k++] = hexDigits[byte0 & 0xf];  
           }  
           return new String(str);  
       } catch (Exception e) {          
           return null;  
       }  
   }  
	
		
	/**
	 * MD5加密
	 * @param str 内容       
	 * @param charset 编码方式
	 * @throws Exception 
	 */
	public final static String MD5(String str, String charset) throws Exception {
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(str.getBytes(charset));
	    byte[] result = md.digest();
	    StringBuffer sb = new StringBuffer(32);
	    for (int i = 0; i < result.length; i++) {
	        int val = result[i] & 0xff;
	        if (val <= 0xf) {
	            sb.append("0");
	        }
	        sb.append(Integer.toHexString(val));
	    }
	    return sb.toString().toLowerCase();
	}

}
