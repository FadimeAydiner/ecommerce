package com.tpe.service;

import com.tpe.domain.Category;
import com.tpe.dto.request.CategoryRequestDTO;
import com.tpe.dto.response.CategoryResponseDTO;
import com.tpe.exception.ConflictException;
import com.tpe.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryResponseDTO saveCategory(CategoryRequestDTO categoryRequestDTO) {
        //we need to check name of category is already exists in DB
        if(categoryRepository.existsByName(categoryRequestDTO.getName())){
            throw new ConflictException(categoryRequestDTO.getName()+" is already exisxts");
        }


        //mapped CategoryRequestDTo to Category
        Category newCategory=new Category();
        newCategory.setName(categoryRequestDTO.getName());

        categoryRepository.save(newCategory);

       //to return  CategoryResponseDTO  we need to map Category to  CategoryResponseDTO
        CategoryResponseDTO categoryResponseDTO=new CategoryResponseDTO();
        categoryResponseDTO.setId(newCategory.getId());
        categoryResponseDTO.setName(newCategory.getName());

        return categoryResponseDTO;
    }
}
