package com.eccomerce.project.controller;

import com.eccomerce.project.model.Category;
import com.eccomerce.project.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/public/categories", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

@RequestMapping(value = "/public/categories", method = RequestMethod.POST)
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>("Created successfully",HttpStatus.CREATED);
    }

@RequestMapping(value = "/admin/categories/{categoryId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCategory(@PathVariable long categoryId) {
            String status = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(status,HttpStatus.OK );
    }

@RequestMapping(value = "/public/categories/{categoryId}", method = RequestMethod.PUT)
public ResponseEntity<String> updateCategory(@Valid @RequestBody Category category, @PathVariable long categoryId) {
            Category savedCategory = categoryService.updateCategory(category, categoryId);
            return new ResponseEntity<>("Updated successfully with category id: " + categoryId ,HttpStatus.OK);
    }
}
