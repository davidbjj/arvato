package com.server.client;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("spring-cloud-eureka-client")
public interface GrettingController {
 
	
	@RequestMapping("/mandelbrot")
	BufferedImage getResult();
 
}
