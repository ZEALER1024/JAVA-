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
	public boolean head;// 生命值
	private int speed = 5;// 速度

	private Image fishImage[] = new Image[10];
	private int index = 0;

	Dir left_dir = Dir.L;// 左
	//Dir right_dir = Dir.R;// 右
	//Dir buttom_dir = Dir.U;// 上

	// 包含x y 的构造方法

	public Fish(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	// 绘制方法
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

	// 鱼游动的方法
	public void move() {
		// 左到右 移动
		if (left_dir == Dir.L) {
			x += speed;
			if (this.x > 830) {
				y = r.nextInt(400);
				x = -30;
			}
		}
		// 上到下移动
		else if (left_dir == Dir.U) {
			y += speed;
			if (this.y > 430) {
				y = -30;
				x = r.nextInt(800);
			}
		}
		// 右到左移动
		else if (left_dir == Dir.R) {
			x -= speed;
			if (this.x < -30) {
				y = r.nextInt(400);
				x = 830;
			}
		}

	}

	/**
	 * 根据随机数产生鱼
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

	// 从右到左
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

	// 从左到右
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

	// 从上到下
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
	 * 封装 图片对象的Rectangle
	 */
	public Rectangle getRectangle() {
		return new Rectangle(x, y, wigth, height);

	}

}
