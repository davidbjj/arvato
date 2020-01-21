package com.api.process.client;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

import javax.swing.JFrame;
 

public class Main extends JFrame {

	private static final Logger logger = Logger.getLogger(Main.class.toString());
	private static String GET_URL = "http://localhost:9080/mandelbrot"; 
	private static BufferedImage imageResult;
 
	
	public static void main(String[] args) throws IOException {
				new Main().setVisible(true);
	}

	public Main() throws IOException {
		super("Mandelbrot Set");
		setBounds(100, 100, 800, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		sendGET();
	}
	
	private static void sendGET() throws IOException {
		URL obj = new URL(GET_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");	
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
	
 		if (responseCode == HttpURLConnection.HTTP_OK) { // success 			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));		
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}	
			in.close();
		} else {
			System.out.println("GET request not worked");
		}
         
	}
	
	 @Override
	    public void paint(Graphics g) {
	        g.drawImage(imageResult, 0, 0, this);
	    }
	 
	 
}
