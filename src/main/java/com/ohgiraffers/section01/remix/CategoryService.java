package com.ohgiraffers.section01.remix;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.remix.Template.getSqlSession;

public class CategoryService {

    private CategoryMapper categoryMapper;

    public List<CategoryDTO> selectAllCategory() {

        SqlSession sqlSession = getSqlSession();

        categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        List<CategoryDTO> categoryList = categoryMapper.selectAllCategory();

        sqlSession.close();

        return categoryList;
    }

    public CategoryDTO selectCategoryByCode(int code) {

        SqlSession sqlSession = getSqlSession();
        categoryMapper = sqlSession.getMapper(CategoryMapper.class);

        CategoryDTO category = categoryMapper.selectCategoryByCode(code);

        sqlSession.close();

        return category;
    }

    public boolean registCategory(CategoryDTO category) {

        SqlSession sqlSession = getSqlSession();
        categoryMapper = sqlSession.getMapper(CategoryMapper.class);

        int result = categoryMapper.insertCategory(category);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

    public boolean modifyCategory(CategoryDTO category) {

        SqlSession sqlSession = getSqlSession();
        categoryMapper = sqlSession.getMapper(CategoryMapper.class);

        int result = categoryMapper.updateCategory(category);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

    public boolean deleteCategory(int code){

        SqlSession sqlSession = getSqlSession();
        categoryMapper = sqlSession.getMapper(CategoryMapper.class);

        int result = categoryMapper.deleteCategory(code);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

}
