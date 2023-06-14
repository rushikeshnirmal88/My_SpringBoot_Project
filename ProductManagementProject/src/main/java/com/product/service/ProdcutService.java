package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

@Service
public class ProdcutService {

	@Autowired
	private ProductRepository prodcutRepo;
	
	public List<Product> getAllProduct()
	{
		return prodcutRepo.findAll();
	}
	
	public Product saveProduct(Product prodcut)
	{
		return prodcutRepo.save(prodcut);
	}
	
	public Optional<Product> findProduct(int id)
	{
		return prodcutRepo.findById(id);
	
	}
	public String deleteProductById(int id)
	{
		String result;
		try {
			
			prodcutRepo.deleteById(id);
			result="Product deleted successfully";
		} catch (Exception e) {
			// TODO: handle exception
			result="Product with id is not deleted successfully";
		}
		return result;
	}
}
