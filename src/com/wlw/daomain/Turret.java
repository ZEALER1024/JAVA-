package com.wlw.daomain;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import com.wlw.utils.ImageTools;
import com.wlw.view.GameJpanel;

/**
 * 
 * @author Administrator 旋转的是炮塔贴图的本身
 */
public class Turret {
	private int x;
	private int y;
	private int wigth = 80;
	private int height = 100;
	public  static int grade=1;// 炮塔等级
	private double mouseX;
	private double mouseY;
	public Image turret = ImageTools.turretImage;
	private double theta;// 旋转的角度，以弧度为单位
	GameJpanel jpanel;
	
	public Turret(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Turret() {
		super();
	}

	public void drawBattery(Graphics g) {
		
		// 强制
		Graphics2D g2 = (Graphics2D) g;
		// 计算角度
		theta = Math.atan((x - mouseX) / (y - mouseY));
		// 转换图片
		g2.rotate(-theta, x, y);
		// 绘制背景图片
		g2.drawImage(turret, x - wigth / 2, y - height / 2,  null);
		// 转换回来
		g2.rotate(theta, x, y);

	}

	public double getMouseX() {
		return mouseX;
	}

	public void setMouseX(double mouseX) {
		this.mouseX = mouseX;
	}

	public double getMouseY() {
		return mouseY;
	}

	public void setMouseY(double mouseY) {
		this.mouseY = mouseY;
	}


}
