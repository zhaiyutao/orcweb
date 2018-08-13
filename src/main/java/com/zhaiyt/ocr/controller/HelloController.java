package com.zhaiyt.ocr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value="/home/page")
	@ResponseBody
	public ModelAndView goHome(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mode = new ModelAndView();
		mode.setViewName("html/index");
		return mode;
	}

}
