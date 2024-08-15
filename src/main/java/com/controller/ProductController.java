package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ProductBean;
import com.dao.ProductDao;

@RestController
public class ProductController {
	@Autowired
	ProductDao productDao;

	@PostMapping("/product")
	public String addProduct(ProductBean productBean) {
		productDao.addProduct(productBean);
		return "Product Added";
	}

	@GetMapping("/products")
	public ArrayList<ProductBean> listProducts() {
		return productDao.listProducts();
	}

	@DeleteMapping("/product/{id}")
	public ArrayList<ProductBean> deleteProduct(@PathVariable("id") int id) {
		
		productDao.deleteProduct(id);
		return productDao.listProducts();//return all products
	}
	
	@PutMapping("/role")
	public ArrayList<ProductBean> updateProduct(ProductBean product){
		productDao.updateProduct(product);
		return productDao.listProducts();
	}
	

}
