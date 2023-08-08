package com.ohgiraffers.section01.remix;

import java.util.List;

public interface CategoryMapper {

    List<CategoryDTO> selectAllCategory();

    CategoryDTO selectCategoryByCode(int code);

    int insertCategory(CategoryDTO category);

    int updateCategory(CategoryDTO category);

    int deleteCategory(int code);

}
