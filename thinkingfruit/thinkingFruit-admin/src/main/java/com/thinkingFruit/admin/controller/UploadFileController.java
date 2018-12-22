package com.thinkingFruit.admin.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.common.collect.Maps;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.Constant;
import com.ysdevelop.common.utils.JSONHelper;
import com.ysdevelop.common.utils.PropertiesConfigUtil;
import com.ysdevelop.common.utils.UploadUtil;
import com.ysdevelop.common.utils.Constant.FileType;

/**
 * @author zhangzesen
 *
 * @date 2018年11月15日
 *
 * @package com.thinkingFruit.admin.controller
 *
 * @description 上传图片
 */
@Controller
@RequestMapping(value = "/upload")
public class UploadFileController {
	Logger logger = Logger.getLogger(this.getClass());

	/**
	 * 上传图片
	 * @param requestFile
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/image", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String uploadImage(MultipartHttpServletRequest requestFile, HttpServletRequest request) {
		// 上传input name 为uploadImage
		MultipartFile file = null;
		if(requestFile.getFile("uploadImage")!=null){
			file = requestFile.getFile("uploadImage");
		}else if(requestFile.getFile("previewImage")!=null){
			file = requestFile.getFile("previewImage");
		}else if(requestFile.getFile("detailsImage")!=null){
			file = requestFile.getFile("detailsImage");
		}else if(requestFile.getFile("qrBackgroundImage")!=null){
			file = requestFile.getFile("qrBackgroundImage");
		}
		Integer fileType = Integer.parseInt(requestFile.getParameter("imageType"));
		String modulePath = Constant.IMAGE_PATH.get(fileType);
		if (modulePath == null) {
			//上传的图片类型有误
			return JSONHelper.bean2json(Result.error(CodeMsg.TYPE_WRONG));
		}
		if (file == null) {
			//上传的图片找不到
			return JSONHelper.bean2json(Result.error(CodeMsg.PICTURE_NOT_FIND));
		}

		// 读取配置文上传件的路径
		String realPath = null;
		if (PropertiesConfigUtil.getProperty("upload.properties", "upload.image.path") != null) {
			realPath = PropertiesConfigUtil.getProperty("upload.properties", "upload.image.path").toString();
		}
		String imagePath = null;
		if (file != null && file.getSize() > 0) {
			imagePath = UploadUtil.doUpload(FileType.IMAGE, realPath, modulePath, file);
		}
		
		if (imagePath == null) {
			//上传失败
			return JSONHelper.bean2json(Result.error(CodeMsg.UPLOAD_FAILURE));
		}
		//上传成功
		Map<String, Object> msgMap = new HashMap<>();
		msgMap.put("imagePath", imagePath);
		msgMap.put("imageFileName", file.getOriginalFilename());
		
		System.out.println("测试图片上传的json格式"+JSONHelper.bean2json(Result.successData(msgMap)));
		
		return JSONHelper.bean2json(Result.successData(msgMap));
	}
	
	//ueditor
		@RequestMapping(value = "/upload", method = RequestMethod.GET)
		@ResponseBody
		public void upload(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String action = request.getParameter("action");
			System.out.println(request);
			System.out.println(action);
			System.out.println(response);
			if ("config".equals(action)) {
				OutputStream os = response.getOutputStream();
				IOUtils.copy(UploadFileController.class.getClassLoader().getResourceAsStream("config.json"), os);
			}
		}
		
		@RequestMapping(value = "/upload", method = RequestMethod.POST)
		@ResponseBody
		public Map<String, String> upload(HttpServletRequest request, HttpServletResponse response, @RequestParam CommonsMultipartFile upfile) throws IOException {
			Map<String, String> result = Maps.newHashMap();
			String realPath = null;
			if (PropertiesConfigUtil.getProperty("upload.properties", "upload.image.path") != null) {
				realPath = PropertiesConfigUtil.getProperty("upload.properties", "upload.image.path").toString();
			} else {
				result.put("state", "FAILE");
				result.put("url", "");
				result.put("size", "");
				result.put("type", "");
				return result;
			}
			Integer fileType = Integer.parseInt(request.getParameter("imageType"));
			String modulePath = Constant.IMAGE_PATH.get(fileType);
			String imgPath = UploadUtil.doUpload(FileType.IMAGE, realPath, modulePath, upfile);
			if (imgPath == null) {
				result.put("state", "FAILE");
				result.put("url", "");
				result.put("size", "");
				result.put("type", "");
				return result;
			}
		//	String path = PropertiesConfigUtil.getProperty("smurfs-admin.properties", "clientPath").toString();
			String path =null;
			String basePath = null;
			System.out.println("path:"+path);
//			String ngrokPath = PropertiesConfigUtil.getProperty("upload.properties", "ngrokPath").toString();
//			if (path == null || path.trim().equals("")) {
//				if (ngrokPath != null && !ngrokPath.trim().equals("")) {
//					basePath = ngrokPath;
//				} else {
//					basePath = request.getScheme() + "://" + request.getServerName();
//				}
//			}
			/*else {
				if (ngrokPath != null &&!ngrokPath.trim().equals("")) {
					basePath = ngrokPath + "/" + path;
				} else {
					basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + path;
				}
			}*/
			basePath = "";
			String filePath = basePath + imgPath;
			File uploadFile = new File(filePath);
			System.out.println(upfile.getName());
			String state = "SUCCESS";
			// 返回类型
			result.put("url", filePath);
			result.put("size", String.valueOf(uploadFile.length()));
			result.put("type", upfile.getName().substring(upfile.getName().lastIndexOf(".") + 1));
			result.put("state", state);
			System.out.println("result:"+result);
			return result;
		}
}
