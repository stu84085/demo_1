package com.example.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	@ExceptionHandler(value = Exception.class)
	public ModelAndView exception(Exception ex,WebRequest request){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message",ex.getMessage());
		modelAndView.setViewName("error");
		return modelAndView;
	}
	/*//讓所有的@RequestMapping擁有此鍵值
	@ModelAttribute
	public void addAttribute(Model md){
		md.addAttribute("message","錯誤訊息ing");
	}	*/
}
