package com.server.client.impl;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class MandelBrotProcess extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private final int MAX_ITER = 570;
	private final double ZOOM = 150;
	private BufferedImage imageResult;
	private double zx, zy, cX, cY, tmp;
	private int width = 800;
	private int height = 600;
	
	
	 public BufferedImage ImageProcess() {
		 imageResult = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	        for (int y = 0; y < height; y++) {
	            for (int x = 0; x < width; x++) {
	                zx = zy = 0;
	                cX = (x - 400) / ZOOM;
	                cY = (y - 300) / ZOOM;
	                int iter = MAX_ITER;
	                while (zx * zx + zy * zy < 4 && iter > 0) {
	                    tmp = zx * zx - zy * zy + cX;
	                    zy = 2.0 * zx * zy + cY;
	                    zx = tmp;
	                    iter--;
	                }
	                imageResult.setRGB(x, y, iter | (iter << 8));
	            }
	        }		 
		 return imageResult;
	 }
}
