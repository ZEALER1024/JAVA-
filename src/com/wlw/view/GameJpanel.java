package com.wlw.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;
//����

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
	public int score = 0;// �÷�

	public int lv_x = 0;//�������ĳ���
	public int lv_score = 0;//����ֵ
	public int lv_y = 17;//�������ĸ߶�
	//
	public double mouseX;
	public double mouseY;
	int i=0;
	Turret battery = new Turret(width, height);
	// �����ӵ�����ļ���
	public ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	// ����һ����Ŷ�����ļ���
	//
	ArrayList<Fish> fishList = new ArrayList<Fish>();
	// �������Ķ���
	public Net net = null;

	// ���Ʒ���
	@Override
	public void paint(Graphics g) {

		// ���ñ����Ļ��Ʒ���
		bg.drawBackGroud(g);
		//������ʾ�������;�����
		String s = "����:";
		g.setFont(new Font("����", Font.CENTER_BASELINE, 30));
		g.setColor(Color.RED);
		g.drawString(s + score, 10, 30);
		g.fillRect(563, 461, lv_x, lv_y);
		if(lv_x==220){
			Turret.grade++;
			lv_x = 0;
		}

		// ������Ļ��Ʒ���
		// fish.drawFish(g);
		// ������̨�Ļ��Ʒ���

		// ������̨�ӵ��Ļ��Ʒ������Ѽ�������ӵ�����ȡ����
		for (int i = 0; i < bulletList.size(); i++) {
			Bullet bullet = bulletList.get(i);
			bullet.drawBullet(g);
			// ���ò���ķ���
			bullet.hitFish(fishList);

			if (bullet.isHead() == false) {
				bulletList.remove(bullet);
			}
		}

		// �����ʾ
		for (int i = 0; i < fishList.size(); i++) {

			Fish fish = fishList.get(i);
			fish.drawFish(g);
		}

		// if(bullet!=null)
		// bullet.drawBullet(g);

		battery.setMouseX(mouseX);
		battery.setMouseY(mouseY);
		battery.drawBattery(g);
		// �������Ļ��Ʒ������жϵ�ʱ���Ƿ�Ϊ��
		if (net != null) {
			net.drawNet(g);
		}
	}
}
