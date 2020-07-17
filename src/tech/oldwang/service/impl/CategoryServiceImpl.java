package tech.oldwang.service.impl;

import java.util.List;

import tech.oldwang.dao.CategoryDao;
import tech.oldwang.dao.impl.CategoryDaoImpl;
import tech.oldwang.domain.Category;
import tech.oldwang.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	@Override
	public List<Category> findAll() {
		// call DAO
		CategoryDao categoryDao = new CategoryDaoImpl();
		return categoryDao.findAll();
	}

	@Override
	public void save(Category category) {
		CategoryDao categoryDao = new CategoryDaoImpl();
		categoryDao.save(category);
		
	}

	@Override
	public Category findOne(Integer cid) {
		CategoryDao categoryDao = new CategoryDaoImpl();
		
		return categoryDao.findOne(cid);
	}

	@Override
	public void update(Category category) {
		CategoryDao categoryDao = new CategoryDaoImpl();
		categoryDao.update(category);
	}

	@Override
	public void delete(Integer cid) {
		CategoryDao categoryDao = new CategoryDaoImpl();
		categoryDao.delete(cid);
		
	}

}
