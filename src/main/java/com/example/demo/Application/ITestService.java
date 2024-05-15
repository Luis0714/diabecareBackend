package com.example.demo.Application;

import com.example.demo.Application.Dtos.CustomResponse;
import com.example.demo.Application.Dtos.PaginatedResponse;
import com.example.demo.Application.Dtos.TestDto;
import com.example.demo.Persistence.Entities.TestEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITestService {
    CustomResponse<PaginatedResponse<TestEntity>> getTestPaginated(Pageable pageable);
}
