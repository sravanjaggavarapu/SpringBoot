package com.pack.springboot;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	public String homePage(Model model)
	{	List<Product> products = productService.getDetails();
		model.addAttribute("products",products);
		return "index";
	}

	@GetMapping("/new")
	public String newProduct(Model model)
	{	model.addAttribute("product",new Product());
		return "new_product";
	}
	
	@PostMapping("/save")
	public String productSave(Product product)
	{	productService.save(product);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id)
	{
		productService.delete(id);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String updateProduct(@PathVariable Long id,Model model)
	{
		Product product = productService.get(id);
		model.addAttribute("product",product);
		return "edit_form";
	}
}
