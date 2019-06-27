package com.wlw.daomain;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import com.wlw.utils.ImageTools;
import com.wlw.view.GameJpanel;

/**
 * 
 * @author Administrator ��ת����������ͼ�ı���
 */
public class Turret {
	private int x;
	private int y;
	private int wigth = 80;
	private int height = 100;
	public  static int grade=1;// �����ȼ�
	private double mouseX;
	private double mouseY;
	public Image turret = ImageTools.turretImage;
	private double theta;// ��ת�ĽǶȣ��Ի���Ϊ��λ
	GameJpanel jpanel;
	
	public Turret(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Turret() {
		super();
	}

	public void drawBattery(Graphics g) {
		
		// ǿ��
		Graphics2D g2 = (Graphics2D) g;
		// ����Ƕ�
		theta = Math.atan((x - mouseX) / (y - mouseY));
		// ת��ͼƬ
		g2.rotate(-theta, x, y);
		// ���Ʊ���ͼƬ
		g2.drawImage(turret, x - wigth / 2, y - height / 2,  null);
		// ת������
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
