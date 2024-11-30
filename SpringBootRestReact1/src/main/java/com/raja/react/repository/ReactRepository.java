package com.raja.react.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raja.react.entity.ReactEntity;
@Repository
public interface ReactRepository extends JpaRepository<ReactEntity, Long> {

}
