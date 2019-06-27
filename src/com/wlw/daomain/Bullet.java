package com.wlw.daomain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JLabel;

import com.wlw.view.GameJpanel;

public class Bullet {
	private int x = 430;
	private int y = 400;
	private int wigth = 16;
	private int height = 20;

	private double speed;// �ӵ��ƶ����ٶ�
	private boolean head = true;
	private double mouseX;// �ӵ��ƶ���X����
	private double mouseY;// �ӵ��ƶ���Y����
	private double theta;// �ӵ��ƶ��ĽǶ�
	private boolean shooted;// �ӵ��Ƿ���
	private Image bulletImage;
	String path = "./src/com/wlw/images/bullet.png";

	private GameJpanel jpanel;

	// public Bullet(GameJpanel jpanel) {
	// super();
	// this.jpanel = jpanel;
	// }

	public Bullet() {

	}

	public Bullet(GameJpanel jpanel) {
		super();
		try {
			if (bulletImage == null) {
				// Toolkit ����ͼƬ�Ĺ���
				bulletImage = Toolkit.getDefaultToolkit().createImage(path);
			}
		} catch (Exception e) {
			System.out.println("ͼƬ·������");
		}
		this.jpanel = jpanel;
	}

	/**
	 * �����ӵ�ͼƬ���󷽷�
	 */
	public void drawBullet(Graphics g) {
		if (!this.head) {
			return;
		}
		Graphics2D g2 = (Graphics2D) g;// ��gת���ɴ�2D����
		theta = Math.atan((x - mouseX) / (y - mouseY));
		// ��תͼƬ
		g2.rotate(-theta, x, y);
		//
		g2.drawImage(bulletImage, x, y, wigth, height, null);
		// ��ͼƬ��ת����
		g2.rotate(theta, x, y);
		this.move();
		
	}
	

	/**
	 * ����ķ���
	 */
	public void hitFish(ArrayList<Fish> fishs) {
		for (int i = 0; i < fishs.size(); i++) {
			Fish fish = fishs.get(i);
			if (fish.getRectangle().intersects(this.getRectangle())) {
				this.head = false;
				fish.head = false;

				jpanel.net = new Net();
				jpanel.net.x = this.x;
				jpanel.net.y = this.y;
				fishs.remove(fish);
				jpanel.score++;
				jpanel.lv_x+=10;
				jpanel.lv_score++;
				if(jpanel.lv_score%22==0&&jpanel.lv_score<176){
					Turret.grade++;
				}
			}
		}
	}

	/**
	 * �ӵ��ƶ��ķŷ�
	 */
	public void move() {
		speed = 30;
		// x = speed*Math.sin(this.theta);
		// y = speed*Math.cos(this.theta);
		x -= speed * Math.sin(this.theta);
		y -= speed * Math.cos(this.theta);

		// if(x==800){
		// System.out.println(234);
		// jpanel.bulletList.remove(this);
		// }

		if (y < 0 || x < 0 || x > 799) {
			this.head = false;
		}
	}

	/**
	 * �ӵ�����ȥ����ķ���
	 */
	public void boom() {
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

	public boolean isHead() {
		return head;
	}

	public void setHead(boolean head) {
		this.head = head;
	}

	public boolean isShooted() {
		return shooted;
	}

	public void setShooted(boolean shooted) {
		this.shooted = shooted;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWigth() {
		return wigth;
	}

	public void setWigth(int wigth) {
		this.wigth = wigth;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * ��װ ͼƬ�����Rectangle
	 */
	public Rectangle getRectangle() {
		return new Rectangle(x, y, wigth, height);

	}

}
