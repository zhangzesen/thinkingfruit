package com.ysdevelop.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map; 

/**
*
* 快递鸟即时查询
* 查询次数<3000
* @技术QQ: 4009633321
* @技术QQ群: 200121393
* @see: http://www.kdniao.com/api-subscribe
* @copyright: 深圳市快金数据技术服务有限公司
* 
* ID和Key请到官网申请：http://www.kdniao.com/ServiceApply.aspx
*/

public class ImmediateUtil {
	
	//电商ID
	private static String EBusinessID="1367511";
	//电商加密私钥，快递鸟提供，注意保管，不要泄漏
	private static String AppKey="2ec7f16d-606b-42b4-8dad-f105af9ad224";
	//正式请求url
	private static String ReqURL = "http://api.kdniao.cc/api/dist";
	
 
	/**
     * Json方式  物流即时查询   
     * 查询次数<3000
	 * @throws Exception 
     */
    public static String getOrderTracesByJson(String expressNo,String logisticsNo) throws Exception{
      
    	String requestData= "{'ShipperCode':'"+logisticsNo+"','LogisticCode':'"+expressNo+"'}";
        System.out.println(requestData);
        Map<String, String> params = new HashMap<String, String>();
        params.put("RequestData", Base64EncodeUtil.urlEncoder(requestData, "UTF-8"));
        params.put("EBusinessID", EBusinessID);
        params.put("RequestType", "1002");
        String dataSign=encrypt(requestData, AppKey, "UTF-8");
        params.put("DataSign", Base64EncodeUtil.urlEncoder(dataSign, "UTF-8"));
        params.put("DataType", "2");
         
        String result = HttpUtils.httpsRequest(ReqURL, params);        
        //根据公司业务处理返回的信息......        
        return result;
    }
    
    
	
	/**
     * 电商Sign签名生成
     * @param content 内容   
     * @param keyValue Appkey  
     * @param charset 编码方式
	 * @throws UnsupportedEncodingException ,Exception
	 * @return DataSign签名
     */
	private static String encrypt (String content, String keyValue, String charset) throws UnsupportedEncodingException, Exception
	{
		if (keyValue != null)
		{
			return Base64EncodeUtil.base64(Md5Util.MD5(content + keyValue, charset), charset);
		}
		return Base64EncodeUtil.base64(Md5Util.MD5(content, charset), charset);
	}


}
