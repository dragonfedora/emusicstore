package com.emusic.spring.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emusic.spring.dao.ProductDAO;
import com.emusic.spring.model.Product;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory SessionFactory;
	
	@Override
	public Product getProduct(String id) {
		Session session = SessionFactory.getCurrentSession();
		Product product= (Product)session.get(Product.class, id);
		return product;
	}

	@Override
	public void addProduct(Product product) {
		Session session = SessionFactory.getCurrentSession();
		session.save(product);
		session.flush();
	}

	@Override
	public List<Product> getProductList() {
		Session session = SessionFactory.getCurrentSession();
		org.hibernate.Query query = session.createQuery("from Product");
		List<Product> list = query.list();
		
		return list;
	}

	@Override
	public void deletePrductById(String id) {
		Session session = SessionFactory.getCurrentSession();
		session.delete(getProduct(id));
		session.flush();
	}

	@Override
	public void editProduct(Product product) {
		Session session = SessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
		
	}

}
