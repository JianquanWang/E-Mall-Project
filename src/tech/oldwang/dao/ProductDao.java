package tech.oldwang.dao;

import java.util.List;

import tech.oldwang.domain.Product;

public interface ProductDao {

	List<Product> findAll();

}
