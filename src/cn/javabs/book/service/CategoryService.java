package cn.javabs.book.service;

import cn.javabs.book.entity.Category;

import java.util.List;

public interface CategoryService {

    int addCategory(Category category);

    int deleteCategory(Integer id);

    int updateCategory(Category category);

    List<Category> findAllCategories();

    Category findCategoryById(Integer id);
}
