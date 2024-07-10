package com.codegym.practisesmartphonemanager.service.intefaces.implement;

import com.codegym.practisesmartphonemanager.entity.Category;
import com.codegym.practisesmartphonemanager.repository.ICategoryRepository;
import com.codegym.practisesmartphonemanager.service.intefaces.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    public final ICategoryRepository categoryRepository;

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        if (categoryRepository.findById(id).isPresent())
            categoryRepository.deleteById(id);
        else
            throw new RuntimeException("Category not found");
    }

    @Override
    public Optional<Category> findById(Long id) {
        if (categoryRepository.findById(id).isPresent())
            return categoryRepository.findById(id);
        else
            throw new RuntimeException("Category not found");
    }

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }
}
