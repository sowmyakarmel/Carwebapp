package com.niit.testcase;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.ApplicationContextConfig;
import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.CategoryDao;
/*import com.niit.dao.ProductDao;*/
import com.niit.dao.RegisterDao;
import com.niit.model.Category;
import com.niit.model.Category;
import com.niit.model.CreateUser;
/*import com.niit.model.Product;*/
import com.niit.model.Product;

public class TestApp {
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		System.out.println("I am in Main class");

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ApplicationContextConfig.class);
		// context.scan("com.niit");
		// context.refresh();

	/*RegisterDao regDao = (RegisterDao) context.getBean("regDao");

		CreateUser user = new CreateUser();
		user.setEmail("sowmyanarisetty@gmail.com");
		user.setMyname("sowmya1@");
		user.setContactno("8125141969");
		user.setPassword("sowmyan");
		user.setRole("ROLE_ADMIN");
		user.setIs_active(true);
		regDao.addData(user);
		
		*/



	CategoryDao catDao= (CategoryDao) context.getBean("catDao");
	
	/*Category category=new Category();
	category.setCategoryId(1);
	category.setCategoryName("Jaguar");
	catDao.newCategory(category);
	*/

	
	ProductDao proDao=(ProductDao) context.getBean("proDao");
	
	Product product=new Product();
	product.setProductId(1);
	product.setProductName("Jaguar");
	product.setProductDescription("speed highest");
	product.setProductDescription("Jaguar is a car");
	product.setCategory(catDao.getCategory(1));
	product.setProductPrice(100000);
	product.setQuantity(1);
	product.setStatus(true);
	proDao.addProduct(product);
	proDao.delete(35);
	}
}