package com.example.demo.Application.implementations;

import com.example.demo.Application.Dtos.CustomResponse;
import com.example.demo.Application.Dtos.PaginatedResponse;
import com.example.demo.Application.Dtos.TestDto;
import com.example.demo.Application.Entities.Test;
import com.example.demo.Application.ITestService;
import com.example.demo.Application.Mappers.ITestMapper;
import com.example.demo.Persistence.Entities.TestEntity;
import com.example.demo.Persistence.Repositories.Implementations.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSException;

import java.util.List;
@Service
public class TestService implements ITestService {
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private ITestMapper testMapper;

    @Override
    public CustomResponse<PaginatedResponse<TestEntity>> getTestPaginated(Pageable pageable) {
        Page<TestEntity> testsEntitiesPage = testRepository.getTestEntitiesPaginated(pageable);
        PaginatedResponse<TestEntity> paginatedResponse = new PaginatedResponse<>();
        paginatedResponse.setContent(testsEntitiesPage.getContent());
        paginatedResponse.setPage(testsEntitiesPage.getPageable().getPageNumber());
        paginatedResponse.setSizePage(testsEntitiesPage.getPageable().getPageSize());
        paginatedResponse.setCountPages(testsEntitiesPage.getTotalPages());
        paginatedResponse.setTotal((int)testsEntitiesPage.getTotalElements());
        return  new CustomResponse<>(paginatedResponse, "Test paginated");
    }
}
