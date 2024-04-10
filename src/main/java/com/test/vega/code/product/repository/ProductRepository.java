package com.test.vega.code.product.repository;

import com.test.vega.code.data.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends ListCrudRepository<ProductEntity, UUID> {

    Optional<ProductEntity> findById(UUID id);
}
