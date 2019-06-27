package com.wlw.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import com.wlw.daomain.Start;


public class StartGameJpanel extends JPanel {

	private int x = 0;
	private int y = 0;
	Start button = new Start();
	//
	String path = "./src/com/wlw/images/startBG.jpg";
	private Image bgImage = Toolkit.getDefaultToolkit().createImage(path);
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(bgImage, x, y, null);
		button.drawStartButton(g);
	}
}
