package com.wlw.daomain;

import java.awt.Button;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import com.wlw.view.NewGame;


public class Start extends Button{
	int x=385;
	int y=410;
	int width = 285;
	int height = 76;
	String pathButton = "./src/com/wlw/images/startButton.jpg";
	private Image bgButtonImage = null;

	public Start() {
		// TODO Auto-generated constructor stub
		bgButtonImage = Toolkit.getDefaultToolkit().
				createImage(pathButton);
		
	}
	
	public void drawStartButton(Graphics g){
		
		g.drawImage(bgButtonImage, x, y, null);
		
		
	}
	
	@Override
	public synchronized void addActionListener(ActionListener l) {
		// TODO Auto-generated method stub
		super.addActionListener(l);
		new NewGame();
	}
	
}
