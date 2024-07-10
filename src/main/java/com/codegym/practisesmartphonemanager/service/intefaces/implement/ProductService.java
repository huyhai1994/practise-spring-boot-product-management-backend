package com.codegym.practisesmartphonemanager.service.intefaces.implement;

import com.codegym.practisesmartphonemanager.entity.Product;
import com.codegym.practisesmartphonemanager.repository.IProductRepository;
import com.codegym.practisesmartphonemanager.service.intefaces.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    public final IProductRepository productRepository;

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        if (productRepository.findById(id).isPresent())
            productRepository.deleteById(id);
        else
            throw new RuntimeException("Product not found");
    }

    @Override
    public Optional<Product> findById(Long id) {
        if (productRepository.findById(id).isPresent())
            return productRepository.findById(id);
        else
            throw new RuntimeException("Product not found");
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }
}
