package com.niit.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.model.Category;
import com.niit.model.Product;

@Repository("proDao")

public class ProductDaoImplementation implements ProductDao
{

	
	SessionFactory sessionFactory;
	
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		   this.sessionFactory = sessionFactory;
		}

	public boolean addProduct(Product product)
	{
				
		// TOO Auto-generated method stub
		System.out.println("I am in add product Dao");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(product);
			tx.commit();
			return true;
		} catch (Exception e) {
			// TODO:handle exception
			e.printStackTrace();
			//System.out.println(e);
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Product> allProducts() {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		return session.createQuery("From Product").getResultList();
	}
	public Product get (int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		return session.get(Product.class, id);
	}

	public boolean update(Product product)
	{
	System.out.println("Product price::::::::::::::::::" + product.getProductPrice());
	// TODO Auto-generated method stub
	Session session=sessionFactory.openSession();
	Transaction tx=session.beginTransaction();
	try {
		session.update(product);
		tx.commit();
		return true;
	}
	catch (Exception e) {
		System.out.println("Exception in ProductDao:::::::" + e);
		return false;
	}
}

@SuppressWarnings({ "deprecation", "rawtypes"})
public boolean delete (int id) {
	System.out.println("i am in delete code");
	Session session=sessionFactory.openSession();
	Transaction tx=session.beginTransaction();
	Query q;
	try {
		 q = session.createQuery("DELETE Product WHERE productId= :ID");
		q.setParameter("ID", id);
		q.executeUpdate();
		tx.commit();
		return true;
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
		return false;
	}
}
@SuppressWarnings({"deprecation","unchecked","rawtypes"})
public List<Product> getCatProducts(Integer id) {
	// TODO Auto-generated method stub
	Session session= sessionFactory.openSession();
	try {
		Query q=session.createQuery("from Product where categoryid=:Id");

		q.setParameter("id", id);
		return q.getResultList();
	} catch (Exception e) {
		// TODO: handle exception
		return null;
	}
}

@Override
public Product get(Integer id) {
	// TODO Auto-generated method stub
	return null;
}



}