package com.leaveapp.webconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@ComponentScan({"com.leaveapp.controllers"})
public class DispatcherConfig extends WebMvcConfigurationSupport {
	
}
