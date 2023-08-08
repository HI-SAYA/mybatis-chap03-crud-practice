package com.ohgiraffers.section01.remix;

import java.util.List;
import java.util.Map;

public class CategoryController {

    private final CategoryService categoryService;
    private final PrintResult printResult;

    public CategoryController() {
        categoryService = new CategoryService();
        printResult = new PrintResult();
    }

    public void selectAllCategory() {
        List<CategoryDTO> categoryList = categoryService.selectAllCategory();

        if (categoryList != null) {
            printResult.printCategoryList(categoryList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void selectCategoryByCode(Map<String, String> parameter) {

        int code = Integer.parseInt(parameter.get("code"));

        CategoryDTO category = categoryService.selectCategoryByCode(code);

        if(category != null) {
            printResult.printCategory(category);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }

    public void registCategory(Map<String, String> parameter)  {

        String name = parameter.get("name");
        int refCategoryCode = Integer.parseInt(parameter.get("refCategoryCode"));

        CategoryDTO category = new CategoryDTO();
        category.setName(name);
        category.setRefCategoryCode(refCategoryCode);

        if(categoryService.registCategory(category)) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }

    public void modifyCategory(Map<String, String> parameter) {

        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        int refCategoryCode = Integer.parseInt(parameter.get("refCategoryCode"));

        CategoryDTO category = new CategoryDTO();
        category.setCode(code);
        category.setName(name);
        category.setRefCategoryCode(refCategoryCode);

        if(categoryService.registCategory(category)) {
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
    }

    public void deleteCategory(Map<String, String> parameter) {

        int code = Integer.parseInt(parameter.get("code"));

        if(categoryService.deleteCategory(code)) {
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }
    }
}


