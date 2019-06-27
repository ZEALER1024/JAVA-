package com.wlw.daomain;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Random;

import com.wlw.utils.ImageTools;

public class Fish {
	private Random r = new Random();
	private int x;
	private int y;
	private int wigth = 50;
	private int height = 20;
	public boolean head;// ����ֵ
	private int speed = 5;// �ٶ�

	private Image fishImage[] = new Image[10];
	private int index = 0;

	Dir left_dir = Dir.L;// ��
	//Dir right_dir = Dir.R;// ��
	//Dir buttom_dir = Dir.U;// ��

	// ����x y �Ĺ��췽��

	public Fish(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	// ���Ʒ���
	public void drawFish(Graphics g) {
		if (fishImage != null) {
			g.drawImage(fishImage[index], x, y, null);
			index++;
			if (index == fishImage.length) {
				index = 0;
			}
		}

		this.move();
	}

	// ���ζ��ķ���
	public void move() {
		// ���� �ƶ�
		if (left_dir == Dir.L) {
			x += speed;
			if (this.x > 830) {
				y = r.nextInt(400);
				x = -30;
			}
		}
		// �ϵ����ƶ�
		else if (left_dir == Dir.U) {
			y += speed;
			if (this.y > 430) {
				y = -30;
				x = r.nextInt(800);
			}
		}
		// �ҵ����ƶ�
		else if (left_dir == Dir.R) {
			x -= speed;
			if (this.x < -30) {
				y = r.nextInt(400);
				x = 830;
			}
		}

	}

	/**
	 * ���������������
	 */
	public void setPic(Dir dir) {
		left_dir=dir;
		if (Dir.U == dir) {
			setUpToDown();
		}
		if (Dir.L == dir) {
			setLeftToRight();
		}
		if (Dir.R == dir) {
			setRightToLeft();
		}

	}

	// ���ҵ���
	private void setRightToLeft() {
		// TODO Auto-generated method stub
		switch (r.nextInt(3)) {
		case 1:
			fishImage = ImageTools.Limagetool1;
			break;
		case 2:
			fishImage = ImageTools.Limagetool2;
			break;
		default:
			break;
		}

	}

	// ������
	private void setLeftToRight() {
		// TODO Auto-generated method stub
		switch (r.nextInt(3)) {
		case 1:
			fishImage = ImageTools.Rimagetool1;
			break;
		case 2:
			fishImage = ImageTools.Rimagetool2;
			break;
		default:
			break;
		}

	}

	// ���ϵ���
	private void setUpToDown() {
		// TODO Auto-generated method stub
		switch (r.nextInt(3)) {
		case 1:
			fishImage = ImageTools.Uimagetool1;
			break;
		case 2:
			fishImage = ImageTools.Uimagetool2;
			break;
		default:
			break;
		}
	}

	/**
	 * ��װ ͼƬ�����Rectangle
	 */
	public Rectangle getRectangle() {
		return new Rectangle(x, y, wigth, height);

	}

}
