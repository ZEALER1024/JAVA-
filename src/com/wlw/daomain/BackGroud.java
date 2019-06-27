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
			// Toolkit ����ͼƬ�Ĺ���
			bgImage = Toolkit.getDefaultToolkit().createImage(path);
		}
	}

	/**
	 * 
	 * @param g
	 *            ϵͳ�ṩ�Ļ���
	 */
	public void drawBackGroud(Graphics g) {
		// ���Ʊ���ͼƬ
		g.drawImage(bgImage, wigth, height, null);

	}

}
