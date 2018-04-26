package com.springmvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.model.Account;


@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
			
		return "home";
	}
	/*@RequestMapping(value="/form", method=RequestMethod.GET)
	public String createaccount() {
		return "form";
	}*/
	@RequestMapping(value="/form")
	public String createaccount(@Valid @ModelAttribute("NewAccount") Account account,BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Form Has Errors");
			return"form";
		}
		System.out.println("form validated");
		System.out.println("Name="+account.getName()+" Mobile="+account.getMobile()+" Email="+account.getEmail()+" Address="+account.getAddress());
		return "form";
	}
	
	
}
