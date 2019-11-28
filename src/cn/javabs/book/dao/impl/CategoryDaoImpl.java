package cn.javabs.book.dao.impl;

import cn.javabs.book.dao.CategoryDao;
import cn.javabs.book.entity.Category;
import cn.javabs.book.exception.CategoryDaoException;
import cn.javabs.book.util.DbcpUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    QueryRunner qr = new QueryRunner(DbcpUtils.getDataSource());

    @Override
    public int addCategory(Category category) {
        try {
            return qr.update("insert into category (name,description) values (? , ?)",category.getName(),category.getDescription());
        } catch (SQLException e) {
            throw new CategoryDaoException(e);
        }
    }

    @Override
    public int deleteCategory(Integer id) {
        try {
            return qr.update("delete from category where id = ?",id);
        } catch (SQLException e) {
            throw new CategoryDaoException(e);
        }
    }

    @Override
    public int updateCategory(Category category) {
        try {
            return qr.update("update category set name = ? , description = ? where id = ?",
                    category.getName(),category.getDescription(),category.getId());
        } catch (Exception e) {
            throw new CategoryDaoException(e);
        }
    }

    @Override
    public List<Category> findAllCategories() {
        try {
            List<Category> categoryList = qr.query("select * from category", new BeanListHandler<Category>(Category.class));
            return categoryList;
        } catch (SQLException e) {
            throw new CategoryDaoException(e);
        }
    }

    @Override
    public Category findCategoryById(Integer id) {
        try {
            Category category = qr.query("select * from category where id = ?", new BeanHandler<Category>(Category.class), id);
            return category;
        } catch (SQLException e) {
            throw new CategoryDaoException(e);
        }
    }
}
