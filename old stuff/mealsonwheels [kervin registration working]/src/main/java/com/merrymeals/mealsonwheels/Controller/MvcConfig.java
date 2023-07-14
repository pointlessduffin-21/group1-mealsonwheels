package com.merrymeals.mealsonwheels.Controller;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfig implements WebMvcConfigurer{
	
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 	Path mealUploadDir = Paths.get("./meals/images");
	        String mealUploadPath = mealUploadDir.toFile().getAbsolutePath();
	        registry.addResourceHandler("/**")
	                .addResourceLocations("file:/" + mealUploadPath + "/");
	    }

}
