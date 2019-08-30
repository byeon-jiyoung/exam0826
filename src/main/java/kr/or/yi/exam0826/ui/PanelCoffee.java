package kr.or.yi.exam0826.ui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import kr.or.yi.exam0826.dto.Product;
import kr.or.yi.exam0826.dto.Sale;

@SuppressWarnings("serial")
public class PanelCoffee extends JPanel {
	private JTextField tfProductCode;
	private JTextField tfSalePrice;
	private JTextField tfSaleCnt;
	private JTextField tfMarginRate;
	private JTextField tfProductName;

	public PanelCoffee() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pCoffee1 = new JPanel();
		add(pCoffee1);
		pCoffee1.setLayout(new GridLayout(0, 2, 5, 5));
		
		JLabel lblProductCode = new JLabel("제품코드");
		lblProductCode.setHorizontalAlignment(SwingConstants.TRAILING);
		pCoffee1.add(lblProductCode);
		
		tfProductCode = new JTextField();
		pCoffee1.add(tfProductCode);
		tfProductCode.setColumns(10);
		
		JLabel lblSalePrice = new JLabel("제품단가");
		lblSalePrice.setHorizontalAlignment(SwingConstants.TRAILING);
		pCoffee1.add(lblSalePrice);
		
		tfSalePrice = new JTextField();
		tfSalePrice.setColumns(10);
		pCoffee1.add(tfSalePrice);
		
		JLabel lblSaleCnt = new JLabel("판매수량");
		lblSaleCnt.setHorizontalAlignment(SwingConstants.TRAILING);
		pCoffee1.add(lblSaleCnt);
		
		tfSaleCnt = new JTextField();
		tfSaleCnt.setColumns(10);
		pCoffee1.add(tfSaleCnt);
		
		JLabel lblMarginRate = new JLabel("마진율");
		lblMarginRate.setHorizontalAlignment(SwingConstants.TRAILING);
		pCoffee1.add(lblMarginRate);
		
		tfMarginRate = new JTextField();
		tfMarginRate.setColumns(10);
		pCoffee1.add(tfMarginRate);
		
		JPanel pCoffee2 = new JPanel();
		add(pCoffee2);
		pCoffee2.setLayout(new GridLayout(0, 1, 5, 5));
		
		JPanel panel = new JPanel();
		pCoffee2.add(panel);
		panel.setLayout(new GridLayout(0, 2, 5, 0));
		
		JLabel lblProductName = new JLabel("제품명");
		lblProductName.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(lblProductName);
		
		tfProductName = new JTextField();
		tfProductName.setColumns(10);
		panel.add(tfProductName);
		
		JPanel p1 = new JPanel();
		pCoffee2.add(p1);
		JPanel p2 = new JPanel();
		pCoffee2.add(p2);
		JPanel p3 = new JPanel();
		pCoffee2.add(p3);
	}
	
	public void clear() {
		tfProductCode.setText("");
		tfSalePrice.setText("");
		tfSaleCnt.setText("");
		tfMarginRate.setText("");
		tfProductName.setText("");
	}
	
}
