package tech.oldwang.dao;

import java.util.List;

import tech.oldwang.domain.Category;

public interface CategoryDao {

	List<Category> findAll();

	void save(Category category);

	Category findOne(Integer cid);

	void update(Category category);

	void delete(Integer cid);

}
