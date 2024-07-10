package com.codegym.practisesmartphonemanager.repository;

import com.codegym.practisesmartphonemanager.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
