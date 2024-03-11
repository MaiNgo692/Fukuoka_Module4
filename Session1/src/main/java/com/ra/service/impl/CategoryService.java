package com.ra.service.impl;

import com.ra.entity.Category;
import com.ra.repository.IRepository;
import com.ra.repository.impl.CategoryRepository;
import com.ra.repository.impl.Repository;
import com.ra.service.IService;

import java.util.List;

public class CategoryService implements IService<Category,Integer> {
    CategoryRepository categoryRepository = new CategoryRepository();
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll(Category.class);
    }

    @Override
    public Category findId(Integer id) {
        return categoryRepository.findId(id,Category.class);
    }

    @Override
    public Category add(Category entity) {
        return categoryRepository.add(entity);
    }

    @Override
    public Category edit(Category entity) {
        return categoryRepository.edit(entity);
    }

    public Category findByName(String key){
            return categoryRepository.findByName(key);
    }
}
