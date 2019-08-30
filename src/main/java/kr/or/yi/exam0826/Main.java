package kr.or.yi.exam0826;

import java.awt.EventQueue;

import kr.or.yi.exam0826.ui.CoffeeUI;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeUI frame = new CoffeeUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
