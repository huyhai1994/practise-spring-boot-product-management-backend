package com.codegym.practisesmartphonemanager.repository;

import com.codegym.practisesmartphonemanager.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
