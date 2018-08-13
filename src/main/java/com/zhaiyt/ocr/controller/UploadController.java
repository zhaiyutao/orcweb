package com.zhaiyt.ocr.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.baidu.aip.ocr.AipOcr;

@Controller
public class UploadController {

	// APPID/AK/SK
	public static final String APP_ID = "11640585";
	public static final String API_KEY = "7hAbGLSEBzt1itBN1GYZO08n";
	public static final String SECRET_KEY = "vf0EgcpkSpAiK7vAxF09DBN0xtgqOtr0";

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView upload(@RequestParam("file") MultipartFile file, HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mode = new ModelAndView();
//		ModelAndView mode = new ModelAndView(("redirect:/home/page"));
		String parameter = request.getParameter("srcValue");
		request.setAttribute("srcValue", parameter);
		mode.setViewName("html/index");
		if (!file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			String path = "src/main/resources/static/images/";
			try {

				uploadFile(file.getBytes(), path, fileName);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String value = getString(path+fileName);
			request.setAttribute("returnValue", value);
			request.setAttribute("fileName", fileName);
		}
		return mode;
	}

	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
		File tarFile = new File(filePath);
		if (!tarFile.exists()) {
			tarFile.mkdirs();
		}
		FileOutputStream outputStream = new FileOutputStream(filePath + fileName);
		outputStream.write(file);
		outputStream.flush();
		outputStream.close();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String getString(String path) {
		// OCR对象
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
		// 设置超时时间
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);
		// 图片位置
		JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
		StringBuilder sBuilder = new StringBuilder();
		Map<String, Object> map = (Map<String, Object>) JSON.parse(res.toString());
		if (null != map) {
			List<Map> list = (List<Map>) map.get("words_result");
			for (Map<String, String> m : list) {
				sBuilder.append(m.get("words"));
				sBuilder.append("\n");
			}
		}
		System.out.println(sBuilder.toString());
		return sBuilder.toString();
	}
}
