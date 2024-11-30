package com.raja.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raja.mvc.project.ProductEntity;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>
{

}
