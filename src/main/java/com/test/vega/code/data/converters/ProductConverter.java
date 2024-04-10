package com.test.vega.code.data.converters;

import com.test.vega.code.data.dto.Product;
import com.test.vega.code.data.entity.PriceEntity;
import com.test.vega.code.data.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductConverter {

    public ProductEntity convert(final Product productDto, final PriceEntity priceEntity) {

        return new ProductEntity(productDto.id() != null ? UUID.fromString(productDto.id()) : null, productDto.name(), productDto.description(), priceEntity);
    }

    public Product convert(final ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId().toString())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice().getPriceValue())
                .build();
    }
}
