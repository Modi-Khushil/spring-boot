package com.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bean.ProductBean;

@Repository
public class ProductDao {

	ArrayList<ProductBean> products = new ArrayList<>();

	public void addProduct(ProductBean productBean) {
		products.add(productBean);

	}

	public ArrayList<ProductBean> listProducts() {
		// TODO Auto-generated method stub
		return products;
	}

	public void deleteProduct(int id) {
		int i = 0;
		for (i = 0; i < products.size(); i++) {
			if (products.get(i).getProductId() == id) {
				break;
			}
		}
		products.remove(i);

	}

	public void updateProduct(ProductBean product) {
		int i = 0;
		for (i = 0; i < products.size(); i++) {
			if (products.get(i).getProductId() == product.getProductId()) {
				break;
			}
		}
		products.remove(i);
		products.add(product);

	}

}
