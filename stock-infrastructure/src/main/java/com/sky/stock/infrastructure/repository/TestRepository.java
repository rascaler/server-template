package com.sky.stock.infrastructure.repository;

import com.sky.stock.infrastructure.domain.mongo.TestMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TestRepository extends MongoRepository<TestMongo, String> {
  List<TestMongo> findByName(String name);
}
