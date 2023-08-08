package com.ohgiraffers.section01.remix;

import java.util.List;

public class PrintResult {
    public void printCategoryList(List<CategoryDTO> categoryList) {
        categoryList.forEach(System.out::println);
    }

    public void printCategory(CategoryDTO category) { System.out.println(category);
    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = " ";
        switch (errorCode) {
            case "selectList" : errorMessage = "카테고리 목록 조회에 실패하였습니다."; break;
            case "selectOne" : errorMessage = "카테고리 코드 조회에 실패하였습니다."; break;
            case "insert" : errorMessage = "카테고리 등록에 실패하였습니다."; break;
            case "update" : errorMessage = "카테고리 수정에 실패하였습니다."; break;
            case "delete" : errorMessage = "카테고리 삭제에 실패하였습니다."; break;
        }
        System.out.println(errorMessage);
    }

    public void printSuccessMessage(String successCode) {
        String successMessage = "";
        switch(successCode) {
            case "insert" : successMessage = "신규 카테고리 등록이 완료 되었습니다."; break;
            case "update" : successMessage = "카테고리 수정이 완료 되었습니다."; break;
            case "delete" : successMessage = "카테고리 삭제가 완료 되었습니다."; break;
        }
        System.out.println(successMessage);
    }
}
