package cn.javabs.book.service;

import cn.javabs.book.entity.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 添加分类
     * @param category
     * @return
     */
    int addCategory(Category category);

    /**
     * 删除分类
     * @param id
     * @return
     */
    int deleteCategory(Integer id);

    /**
     * 修改分类
     * @param category
     * @return
     */
    int updateCategory(Category category);

    /**
     * 查询全部分类
     * @return
     */
    List<Category> findAllCategories();

    /**
     * 根据id查询分类
     * @param id
     * @return
     */
    Category findCategoryById(Integer id);

}
