package com.example.demo.Application.Mappers;

import com.example.demo.Application.Dtos.TestDto;
import com.example.demo.Application.Entities.Test;
import com.example.demo.Persistence.Entities.TestEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITestMapper {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "lastname", target = "lastname"),
        @Mapping(source = "password", target = "password")
    })
    Test toTest(TestEntity testEntity);
    List<Test> toTests(List<TestEntity> testEntities);
   @InheritInverseConfiguration
    TestEntity toTestEntity(Test test);

   @InheritInverseConfiguration
    List<TestEntity> toTestEntities(List<Test> tests);

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "lastname", target = "lastname")
    })
    TestDto toTestDto(Test test);

    List<TestDto> toTestDtos(List<Test> tests);
}
