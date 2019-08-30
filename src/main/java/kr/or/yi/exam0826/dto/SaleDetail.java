package kr.or.yi.exam0826.dto;

public class SaleDetail {
	private Sale no;
	private int salePrice;
	private int addTax;
	private int supPrice;
	private int marPrice;
	
	public SaleDetail() {
	}

	public Sale getNo() {
		return no;
	}

	public void setNo(Sale no) {
		this.no = no;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public int getAddTax() {
		return addTax;
	}

	public void setAddTax(int addTax) {
		this.addTax = addTax;
	}

	public int getSupPrice() {
		return supPrice;
	}

	public void setSupPrice(int supPrice) {
		this.supPrice = supPrice;
	}

	public int getMarPrice() {
		return marPrice;
	}

	public void setMarPrice(int marPrice) {
		this.marPrice = marPrice;
	}

	@Override
	public String toString() {
		return "SaleDetail [no=" + no + ", salePrice=" + salePrice + ", addTax=" + addTax + ", supPrice=" + supPrice
				+ ", marPrice=" + marPrice + "]";
	}
	
}
