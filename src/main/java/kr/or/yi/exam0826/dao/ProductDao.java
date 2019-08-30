package kr.or.yi.exam0826.dao;

import java.util.List;

import kr.or.yi.exam0826.dto.Product;

public interface ProductDao {
	public List<Product> selectProductByAll();
	public Product selectProductByCode(Product product);
}
