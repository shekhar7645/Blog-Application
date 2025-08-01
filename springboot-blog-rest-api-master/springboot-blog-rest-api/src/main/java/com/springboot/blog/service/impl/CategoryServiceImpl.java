package com.springboot.blog.service.impl;

import com.springboot.blog.entity.Category;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.payload.CategoryDto;
import com.springboot.blog.repository.CategoryRepository;
import com.springboot.blog.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        // Convert DTO to entity
        Category category = mapToEntity(categoryDto);

        // Save the category entity
        Category savedCategory = categoryRepository.save(category);

        // Convert entity back to DTO and return
        return mapToDTO(savedCategory);
    }

    @Override
    public CategoryDto getCategory(Long categoryId) {
        // Find the category by ID or throw exception if not found
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
        return mapToDTO(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        // Fetch all categories and map them to DTOs
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {
        // Find the existing category by ID
        Category existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        // Update category fields
        existingCategory.setName(categoryDto.getName());
        existingCategory.setDescription(categoryDto.getDescription());

        // Save the updated category
        Category updatedCategory = categoryRepository.save(existingCategory);

        // Convert entity to DTO and return
        return mapToDTO(updatedCategory);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        // Find the category by ID
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        // Delete the category
        categoryRepository.delete(category);
    }

    // Convert Entity to DTO
    private CategoryDto mapToDTO(Category category) {
        return mapper.map(category, CategoryDto.class);
    }

    // Convert DTO to Entity
    private Category mapToEntity(CategoryDto categoryDto) {
        return mapper.map(categoryDto, Category.class);
    }
}


