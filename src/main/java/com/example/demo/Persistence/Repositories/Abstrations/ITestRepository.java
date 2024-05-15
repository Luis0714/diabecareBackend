package com.example.demo.Persistence.Repositories.Abstrations;

import com.example.demo.Persistence.Entities.TestEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITestRepository {
    Page<TestEntity> getTestEntitiesPaginated(Pageable pageable);
}
