package com.kratiukkarol.shoppingBackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kratiukkarol.shoppingBackend.dao.CategoryDAO;
import com.kratiukkarol.shoppingBackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Category get(int id) {
		try {
			return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> list() {
		try {
			return sessionFactory.getCurrentSession().createQuery("FROM Category", Category.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;		
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		try {
			category.setActive(false);
			sessionFactory.getCurrentSession().update(category);
			return true;		
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
