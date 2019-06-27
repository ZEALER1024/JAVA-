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
	// �������ڵĴ�С
	final static int WIN_WIDHT = 800;
	final static int WIN_HEIGHT = 508;
	// ����һ�������

	private GameJpanel jpanel;
	// �������
	Random r = new Random();
	private int timer = 0;
	
	 private Dir dir =Dir.R;
	 
	// ���췽��
	public NewGame() {
		jpanel = new GameJpanel();
		mainview();// ��ʼ����Ϸ������

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
				try {
					Thread.sleep(100);// �߳�˯��100����
					// ���߳��������
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
	 * ������ķ��� 
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
	
	/* ��Ϸ������ */
	public void mainview() {

		// ���ô�������
		jpanel.setLayout(null);
		this.add(jpanel);

		this.setTitle("�������1.0");// �������
		this.setSize(WIN_WIDHT, WIN_HEIGHT);// �����С
		this.setVisible(true);// ����ɼ���
		this.setLocationRelativeTo(null);// ����λ����Ļ����
		this.setResizable(false);
		this.setDefaultCloseOperation(3);// �˳�
		// �����߳�����ˢ��
		new MyThread().start();
		// ���������¼�
		this.addMouseListener(new MouseAdapter() {
			// ��갴ť��������ͷ�ʱ����
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				// �ж��������ť
				if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
					// �����ķ���ָ�������ʱ�ͷŵĵ�
				
					jpanel.mouseX = e.getX();
					jpanel.mouseY = e.getY();

					// ʵ�����ӵ�����
					Bullet bullet = new Bullet(jpanel);
					// System.out.println(bullet);
					// �����ӵ�����
					bullet.setMouseX(jpanel.mouseX);
					bullet.setMouseY(jpanel.mouseY);
					bullet.setHead(true);
					bullet.setShooted(true);
					// ��bullet��ŵ�������
					jpanel.bulletList.add(bullet);

				}
			}

		});
	}
}
