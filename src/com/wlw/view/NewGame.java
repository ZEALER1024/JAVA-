package com.wlw.view;

import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;

import com.wlw.daomain.Bullet;
import com.wlw.daomain.Dir;
import com.wlw.daomain.Fish;

public class NewGame extends JFrame {
	/**
	 * 
	 * @param args
	 */
	// 声明窗口的大小
	final static int WIN_WIDHT = 800;
	final static int WIN_HEIGHT = 508;
	// 生成一个随机数

	private GameJpanel jpanel;
	// 随机对象：
	Random r = new Random();
	private int timer = 0;
	
	 private Dir dir =Dir.R;
	 
	// 构造方法
	public NewGame() {
		jpanel = new GameJpanel();
		mainview();// 初始化游戏主界面

	}

	// 内部类，继承于多线程
	class MyThread extends Thread {
		
		@Override
		// 调用run方法
		public void run() { 
			// TODO Auto-generated method stub
			super.run();
			while (true) {
				repaint();// 刷新paint
				try {
					Thread.sleep(100);// 线程睡眠100毫秒
					// 从线程里面添加
					timer++;

					if (timer % 5 == 0) {
						getFish();
						timer = 0;
					}

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * 产生鱼的方法 
	 */
	public void getFish() {
		switch (r.nextInt(4)) {
		case 1:
			Fish buttomFish = new Fish(r.nextInt(800),-30);
			buttomFish.setPic(Dir.U);
			jpanel.fishList.add(buttomFish);
			break;
		case 2:
			Fish leftFish = new Fish(-30,r.nextInt(400));
			leftFish.setPic(Dir.L);
			jpanel.fishList.add(leftFish);
			break;
		case 3:
			Fish rightFish = new Fish(800,r.nextInt(400));
			rightFish.setPic(Dir.R);
			jpanel.fishList.add(rightFish);
			break;
		default:
			break;
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NewGame();
		
	}
	
	/* 游戏主界面 */
	public void mainview() {

		// 设置窗体属性
		jpanel.setLayout(null);
		this.add(jpanel);

		this.setTitle("捕鱼达人1.0");// 窗体标题
		this.setSize(WIN_WIDHT, WIN_HEIGHT);// 窗体大小
		this.setVisible(true);// 窗体可见性
		this.setLocationRelativeTo(null);// 窗体位于屏幕中央
		this.setResizable(false);
		this.setDefaultCloseOperation(3);// 退出
		// 启动线程用于刷新
		new MyThread().start();
		// 添加鼠标点击事件
		this.addMouseListener(new MouseAdapter() {
			// 鼠标按钮在组件上释放时调用
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				// 判断鼠标点击按钮
				if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
					// 炮塔的方向指向鼠标点击时释放的点
				
					jpanel.mouseX = e.getX();
					jpanel.mouseY = e.getY();

					// 实例化子弹对象
					Bullet bullet = new Bullet(jpanel);
					// System.out.println(bullet);
					// 设置子弹坐标
					bullet.setMouseX(jpanel.mouseX);
					bullet.setMouseY(jpanel.mouseY);
					bullet.setHead(true);
					bullet.setShooted(true);
					// 将bullet存放到集合里
					jpanel.bulletList.add(bullet);

				}
			}

		});
	}
}
