package com.ysdevelop.common.utils;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.imageio.stream.FileImageOutputStream;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ysdevelop.common.utils.Constant.FileType;


/**
 * 附件上传
 * 
 */
public class UploadUtil {

	public static String doUpload(String realPath, MultipartFile file) {
		return doUpload(Constant.FileType.IMAGE, realPath, "/upload/", file);
	}

	public static String doUpload(FileType fileType, String realPath, String modulePath, MultipartFile file) {

		String fileName = file.getOriginalFilename();
		if (!StringUtils.isEmpty(fileName)) {
			String ext = fileName.substring(fileName.indexOf("."));
			fileName = Calendar.getInstance().getTimeInMillis() + ext;

			File targetFile = new File(realPath + modulePath + fileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			// 保存
			try {
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			switch (fileType) {
			case VIDEO:
				// 如果是video则需要切片

//				String[] pathArray = modulePath.split("/");
//				String courseId = pathArray[1];
//				String lessonId = pathArray[2];
//				Map<String, String> headers = new HashMap<>();
//				headers.put("courseId", courseId);
//				headers.put("lessonId", lessonId);
//				headers.put("lessonFile", fileName);
//				byte[] body = new byte[1024];
//				String sliceUrl = PropertiesConfigUtil.getProperty("upload.properties", "slice.url").toString();
//				String sliceSercet = PropertiesConfigUtil.getProperty("upload.properties", "slice.sercet").toString();
//				String token = Md5Util.MD5(courseId + sliceSercet + lessonId);
//				headers.put("token", token);
//				String responseJson = null;
//				try {
//					responseJson = HttpRequestUtil.post(sliceUrl, headers, body);
//				} catch (Exception e) {
//					return null;
//				}
				return modulePath + fileName;
			case IMAGE:
				return modulePath + fileName;
			}

		}
		return null;
	}

	public static String byteToImg(String realPath, byte[] bytes) {
		if (bytes != null && bytes.length > 0) {
			String imagePath = "/res/upload/" + UUID.randomUUID().toString() + ".jpg";
			FileImageOutputStream imageOutput;
			try {
				File file = new File(realPath + imagePath);
				file.createNewFile();
				imageOutput = new FileImageOutputStream(file);
				imageOutput.write(bytes, 0, bytes.length);
				imageOutput.close();
				return imagePath;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	public static void main(String[] args) {
//		String modulePath = "/1/2/";
//		String[] pathArray = modulePath.split("/");
//
//		for (String string : pathArray) {
//			System.out.println(string + "212");
//		}
		Map<String, String> headers = new HashMap<>();
		headers.put("courseId", "1");
		headers.put("lessonId", "2");
		headers.put("lessonFile", "abc.mp4");
		//byte[] body = new byte[1024];
		String sliceUrl = PropertiesConfigUtil.getProperty("upload.properties", "slice.url").toString();
		String sliceSercet = PropertiesConfigUtil.getProperty("upload.properties", "slice.sercet").toString();
		String token = Md5Util.MD5("1" + sliceSercet + "2");
		System.out.println(token);
		headers.put("token", token);
		String responseJson = null;
		try {
			responseJson = HttpRequestUtil.get(sliceUrl+"?courseId=1&lessonId=2&lessonFile=abc.mp4&token=85db87ffbfcf51882511cdab6c2b53ed");
		} catch (Exception e) {
			e.printStackTrace();
			return ;
		}
		System.out.println(responseJson);
		
	
	}

}
