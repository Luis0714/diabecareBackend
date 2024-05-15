package com.example.demo.Persistence.Repositories.Implementations;

import com.example.demo.Persistence.Entities.TestEntity;
import com.example.demo.Persistence.Repositories.Abstrations.ITestRepository;
import com.example.demo.Persistence.Repositories.Crud.ITestCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository implements ITestRepository {
    @Autowired
    private ITestCrudRepository testCrudRepository;

    @Override
    public Page<TestEntity> getTestEntitiesPaginated(Pageable pageable) {
        return this.testCrudRepository.findAll(pageable);
    }
}
