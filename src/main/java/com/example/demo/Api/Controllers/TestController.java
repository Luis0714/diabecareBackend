package com.example.demo.Api.Controllers;

import com.example.demo.Application.Dtos.CustomResponse;
import com.example.demo.Application.Dtos.PaginatedResponse;
import com.example.demo.Application.Dtos.TestDto;
import com.example.demo.Application.ITestService;
import com.example.demo.Persistence.Entities.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ITestService testService;

    @GetMapping("/")
    public Map<String, String> hello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from DiabeCare API");
        return response;
    }

    @GetMapping("/getTestPaginated")
    public CustomResponse<PaginatedResponse<TestEntity>> getTestEntitiesPaginated(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        return testService.getTestPaginated(PageRequest.of(page, size));
    }
}
