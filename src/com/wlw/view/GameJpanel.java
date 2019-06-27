package com.wlw.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;
//画板

import com.wlw.daomain.BackGroud;
import com.wlw.daomain.Bullet;
import com.wlw.daomain.Fish;
import com.wlw.daomain.Net;
import com.wlw.daomain.Turret;

public class GameJpanel extends JPanel {

	int x = 100;
	int n = (int) (Math.random() * 400) + 1;
	int width = 440;
	int height = 440;

	BackGroud bg = new BackGroud();
	// Fish fish = new Fish(x, n);
	public int score = 0;// 得分

	public int lv_x = 0;//经验条的长度
	public int lv_score = 0;//经验值
	public int lv_y = 17;//经验条的高度
	//
	public double mouseX;
	public double mouseY;
	int i=0;
	Turret battery = new Turret(width, height);
	// 声明子弹对象的集合
	public ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	// 声明一个存放多条鱼的集合
	//
	ArrayList<Fish> fishList = new ArrayList<Fish>();
	// 声明网的对象
	public Net net = null;

	// 绘制方法
	@Override
	public void paint(Graphics g) {

		// 调用背景的绘制方法
		bg.drawBackGroud(g);
		//设置显示分数，和经验条
		String s = "分数:";
		g.setFont(new Font("宋体", Font.CENTER_BASELINE, 30));
		g.setColor(Color.RED);
		g.drawString(s + score, 10, 30);
		g.fillRect(563, 461, lv_x, lv_y);
		if(lv_x==220){
			Turret.grade++;
			lv_x = 0;
		}

		// 调用鱼的绘制方法
		// fish.drawFish(g);
		// 调用炮台的绘制方法

		// 调用炮台子弹的绘制方法，把集合里的子弹对象取出来
		for (int i = 0; i < bulletList.size(); i++) {
			Bullet bullet = bulletList.get(i);
			bullet.drawBullet(g);
			// 调用捕鱼的方法
			bullet.hitFish(fishList);

			if (bullet.isHead() == false) {
				bulletList.remove(bullet);
			}
		}

		// 鱼的显示
		for (int i = 0; i < fishList.size(); i++) {

			Fish fish = fishList.get(i);
			fish.drawFish(g);
		}

		// if(bullet!=null)
		// bullet.drawBullet(g);

		battery.setMouseX(mouseX);
		battery.setMouseY(mouseY);
		battery.drawBattery(g);
		// 调用网的绘制方法，判断当时网是否为空
		if (net != null) {
			net.drawNet(g);
		}
	}
}
