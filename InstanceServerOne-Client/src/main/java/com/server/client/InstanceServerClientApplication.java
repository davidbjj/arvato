package com.server.client;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;
import com.server.client.impl.MandelBrotProcess;

@SpringBootApplication
@RestController
@EnableFeignClients
public class InstanceServerClientApplication implements GrettingController {

	@Autowired
	@Lazy
	private EurekaClient eurekaClient;
	
	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(InstanceServerClientApplication.class);
	    builder.headless(false);
	    ConfigurableApplicationContext context = builder.run(args);
	}

 
	@Override
	public BufferedImage getResult() {
			MandelBrotProcess result = new MandelBrotProcess();			
			BufferedImage arg = result.ImageProcess();

			return arg;
	}
 
}
