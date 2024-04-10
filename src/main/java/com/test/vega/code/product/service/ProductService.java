package com.test.vega.code.product.service;

import com.test.vega.code.data.converters.ProductConverter;
import com.test.vega.code.data.dto.Product;
import com.test.vega.code.data.entity.PriceEntity;
import com.test.vega.code.data.entity.ProductEntity;
import com.test.vega.code.exceptions.ProductNotFoundException;
import com.test.vega.code.product.repository.PriceRepository;
import com.test.vega.code.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {


    private final ProductRepository productResource;

    private final PriceRepository priceResource;

    private final ProductConverter converter;


    @Transactional
    public Product saveProduct(Product productDto) {
        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setPriceValue(productDto.price());
        priceEntity = priceResource.save(priceEntity);
        ProductEntity p = converter.convert(productDto, priceEntity);
        ProductEntity data = productResource.save(p);
        return converter.convert(data);
    }

    public Product getProductById(String id) throws ProductNotFoundException {
        Optional<ProductEntity> p = productResource.findById(UUID.fromString(id));
        if (p.isPresent()) {
            return converter.convert(p.get());
        }
        throw new ProductNotFoundException("Product not found");
    }

    public List<Product> getProducts() {
        return productResource.findAll().stream()
                .map(converter::convert)
                .toList();
    }

    public Product updateProduct(Product productDto) throws ProductNotFoundException {
        Optional<ProductEntity> p = productResource.findById(UUID.fromString(productDto.id()));
        if (p.isPresent()) {
            ProductEntity productEntity = p.get();
            productEntity.setName(productDto.name());
            productEntity.setDescription(productDto.description());
            productEntity.getPrice().setPriceValue(productDto.price());
            productEntity = productResource.save(productEntity);
            return converter.convert(productEntity);
        } else {
            throw new ProductNotFoundException("Product not found");
        }
    }
}
