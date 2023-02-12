package com.tpe.controller;

import com.tpe.dto.request.CategoryRequestDTO;
import com.tpe.dto.response.CategoryResponseDTO;
import com.tpe.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> addCategory(@Valid @RequestBody CategoryRequestDTO categoryRequestDTO){
        CategoryResponseDTO responseDTO=categoryService.saveCategory(categoryRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
