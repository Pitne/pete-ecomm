package com.eccomerce.project.service;

import com.eccomerce.project.model.Category;
import com.eccomerce.project.payload.CategoryDTO;
import com.eccomerce.project.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(long categoryId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, long categoryId);
}
