package kr.or.yi.exam0826.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CoffeeUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnAdd;
	private JButton btnSale;
	private JButton btnMargin;

	public CoffeeUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		PanelCoffee pInfo = new PanelCoffee();
		contentPane.add(pInfo, BorderLayout.CENTER);
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.SOUTH);
		
		btnAdd = new JButton("입력");
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);
		
		btnSale = new JButton("출력1");
		btnSale.addActionListener(this);
		pBtn.add(btnSale);
		
		btnMargin = new JButton("출력2");
		btnMargin.addActionListener(this);
		pBtn.add(btnMargin);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMargin) {
			actionPerformedBtnMargin(e);
		}
		if (e.getSource() == btnSale) {
			actionPerformedBtnSale(e);
		}
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
	}
	
	protected void actionPerformedBtnAdd(ActionEvent e) {
		
	}
	
	protected void actionPerformedBtnSale(ActionEvent e) {
	
	}
	
	protected void actionPerformedBtnMargin(ActionEvent e) {
	
	}
}
