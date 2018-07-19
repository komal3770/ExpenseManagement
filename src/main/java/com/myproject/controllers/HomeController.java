package com.myproject.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import org.slf4j.Logger;


@Controller
public class HomeController {
	final static Logger logger = LoggerFactory.getLogger( HomeController.class );
	
	private static final String FILE_PATH = "/Sample_720x480_30mb.mp4";
    private final int chunk_size = 1024 * 1024 * 2; // 2 MB chunks
	
	@RequestMapping(value="/home")
	public ModelAndView home(){
		return new ModelAndView("home");
	}
	
}
