package com.ysdevelop.common.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;

/**
 * 
 * @author oldHuang
 * 
 * @Package com.ysdevelop.common.utils
 * 
 * @Description 阿里云短信服务
 * 
 * @Date 2018年6月12日
 * 
 * @Version
 * 
 */
@SuppressWarnings("static-access")
public class SmsAlidayu {

	public static String regionId = "cn-hangzhou";// 机房信息,可以不用更改
	/********** 需要准备的参数 **************/

	public static String accessKey = ResourceUtil.getInstance("yuansheng-common").getConfigByName("alidayumsg.accessKey");// 需要修改
	public static String accessSecret =  ResourceUtil.getInstance("yuansheng-common").getConfigByName("alidayumsg.accessSecret");// 需要修改
	public static String code = ResourceUtil.getInstance("yuansheng-common").getConfigByName("alidayumsg.code");// 需要修改
	public static String signName = ResourceUtil.getInstance("yuansheng-common").getConfigByName("alidayumsg.signName");// 需要修改
	public static String product = "Dysmsapi";
	public static String domain = "dysmsapi.aliyuncs.com";
	
	public static IClientProfile profile = DefaultProfile.getProfile(regionId, accessKey, accessSecret);


	public static void sendMsg(String mobile, String param) {
		try {
			DefaultProfile.addEndpoint(regionId, regionId, product, domain);
			IAcsClient client = new DefaultAcsClient(profile);
			SendSmsRequest request = new SendSmsRequest();
			// 管理控制台中配置的短信签名（状态必须是验证通过）
			request.setSignName(signName);
			// 管理控制台中配置的审核通过的短信模板的模板CODE（状态必须是验证通过）
			request.setTemplateCode(code);
			// 短信模板中的变量；数字需要转换为字符串；个人用户每个变量长度必须小于15个字符。
			// 例如:短信模板为：“接受短信验证码${no}”,此参数传递{“no”:”123456”}，用户将接收到[短信签名]接受短信验证码123456
			request.setTemplateParam(param);
			// 目标手机号，多个手机号可以逗号分隔
			request.setPhoneNumbers(mobile);
			SendSmsResponse sendSmsResponse = client.getAcsResponse(request);
			System.out.println("responseCode--->"+sendSmsResponse.getCode());
			if (sendSmsResponse.getCode() == null || !sendSmsResponse.getCode().equals("OK")) {
				throw new WebServiceException(CodeMsg.MESSAGE_SEND_ERROR);
			}
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(signName);
	}

}
