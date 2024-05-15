package com.example.demo.Persistence.Repositories.Crud;
import com.example.demo.Persistence.Entities.TestEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITestCrudRepository extends PagingAndSortingRepository<TestEntity, Integer> {
}
