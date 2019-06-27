package com.wlw.daomain;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class BackGroud {
	private int wigth = 0;
	private int height = 0;

	private Image bgImage = null;
	String path = "./src/com/wlw/images/bg.jpg";

	public BackGroud() {
		// TODO Auto-generated constructor stub
		if (bgImage == null) {
			// Toolkit 创建图片的工具
			bgImage = Toolkit.getDefaultToolkit().createImage(path);
		}
	}

	/**
	 * 
	 * @param g
	 *            系统提供的画笔
	 */
	public void drawBackGroud(Graphics g) {
		// 绘制背景图片
		g.drawImage(bgImage, wigth, height, null);

	}

}
