package com.wlw.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;


public class MainGame extends JFrame {
	// 声明窗口的大小
	final static int WIN_WIDHT = 1040;
	final static int WIN_HEIGHT = 630;

	private StartGameJpanel jpanel;

	public MainGame() {

		jpanel = new StartGameJpanel();
		mainstart();
		repaint();// 刷新paint
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
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainGame();
	}

	public void mainstart() {

		// 设置窗体属性
		jpanel.setLayout(null);
		this.add(jpanel);

		this.setTitle("捕鱼达人1.0");// 窗体标题
		this.setSize(WIN_WIDHT, WIN_HEIGHT);// 窗体大小
		this.setVisible(true);// 窗体可见性
		this.setLocationRelativeTo(null);// 窗体位于屏幕中央
		// this.setResizable(false);
		this.setDefaultCloseOperation(3);// 退出
		// 启动线程用于刷新
		new MyThread().start();
		//添加鼠标点击事件
				this.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						super.mouseReleased(e);
						new NewGame();
						dispose();
				}
		});
	}
}
