package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDao
{

	public boolean addProduct(Product product);
	public List<Product>allProducts();
	public  Product get(Integer id);
	public boolean update(Product product);
	public boolean delete(int id);
	List<Product>getCatProducts(Integer id);
	
}
