package tech.oldwang.service.impl;

import java.util.List;

import tech.oldwang.dao.ProductDao;
import tech.oldwang.dao.impl.ProductDaoImpl;
import tech.oldwang.domain.Product;
import tech.oldwang.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Override
	public List<Product> findAll() {
		ProductDao productDao = new ProductDaoImpl();
		return productDao.findAll();
	}

}
