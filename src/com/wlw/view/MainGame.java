package com.wlw.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;


public class MainGame extends JFrame {
	// �������ڵĴ�С
	final static int WIN_WIDHT = 1040;
	final static int WIN_HEIGHT = 630;

	private StartGameJpanel jpanel;

	public MainGame() {

		jpanel = new StartGameJpanel();
		mainstart();
		repaint();// ˢ��paint
	}

	// �ڲ��࣬�̳��ڶ��߳�
	class MyThread extends Thread {
		@Override
		// ����run����
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while (true) {
				repaint();// ˢ��paint
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainGame();
	}

	public void mainstart() {

		// ���ô�������
		jpanel.setLayout(null);
		this.add(jpanel);

		this.setTitle("�������1.0");// �������
		this.setSize(WIN_WIDHT, WIN_HEIGHT);// �����С
		this.setVisible(true);// ����ɼ���
		this.setLocationRelativeTo(null);// ����λ����Ļ����
		// this.setResizable(false);
		this.setDefaultCloseOperation(3);// �˳�
		// �����߳�����ˢ��
		new MyThread().start();
		//���������¼�
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
