package com.test.vega.code.product.repository;

import com.test.vega.code.data.entity.PriceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PriceRepository extends CrudRepository<PriceEntity, UUID> {

}
