package com.wlw.daomain;

import java.awt.Graphics;
import java.awt.Image;

import com.wlw.utils.ImageTools;

public class Net {
	private int range = 50;// �������İ뾶
	public int x;
	public int y;
	private int width = range * 2;
	private int height = range * 2;

	private Image netImage = ImageTools.netImage;

	public void drawNet(Graphics g) {
		g.drawImage(netImage, x, y, width, height, null);
	}

}
