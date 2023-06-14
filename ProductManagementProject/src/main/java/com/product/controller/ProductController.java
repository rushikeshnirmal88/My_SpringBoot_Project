package com.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.service.ProdcutService;

@RestController
public class ProductController {

	@Autowired
	private ProdcutService productService;
	
	//@RequestMapping(path = "/getprodcutlist",method = RequestMethod.GET)
	@GetMapping("/getproductlist")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Product> getAllProduct()
	{
		List<Product> products=new ArrayList<>();
		//logic to get all products
		products=productService.getAllProduct();
		return products;
	}
	@PostMapping("/addProduct")
	@CrossOrigin(origins = "http://localhost:4200")
	public Product addProduct(@RequestBody Product product)
	{
		return productService.saveProduct(product);
	}
	@GetMapping("/getProduct/{id}")
	public Product getProdcutById(@PathVariable int id)
	{
		return productService.findProduct(id).get();
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public String DeleteProdcutById(@PathVariable int id)
	{
		return productService.deleteProductById(id);
	}

}
