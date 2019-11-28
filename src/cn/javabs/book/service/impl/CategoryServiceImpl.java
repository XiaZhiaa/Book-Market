package cn.javabs.book.service.impl;

import cn.javabs.book.dao.CategoryDao;
import cn.javabs.book.dao.impl.CategoryDaoImpl;
import cn.javabs.book.entity.Category;
import cn.javabs.book.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public int addCategory(Category category) {
        return categoryDao.addCategory(category);
    }

    @Override
    public int deleteCategory(Integer id) {
        return categoryDao.deleteCategory(id);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryDao.updateCategory(category);
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryDao.findAllCategories();
    }

    @Override
    public Category findCategoryById(Integer id) {
        return categoryDao.findCategoryById(id);
    }
}
