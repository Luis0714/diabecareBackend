package com.example.demo.Application.implementations;

import com.example.demo.Api.Config.JWTUtils;
import com.example.demo.Application.Dtos.CredentialsDto;
import com.example.demo.Application.Dtos.CustomResponse;
import com.example.demo.Application.IAccountService;
import com.example.demo.Persistence.Entities.UserEntity;
import com.example.demo.Persistence.Repositories.Crud.IUserJpaRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService{
    @Autowired
    private final JWTUtils jwtUtils;
    @Autowired
    private final IUserJpaRepositiry userCrudRepository;

    public AccountService(JWTUtils jwtUtils, IUserJpaRepositiry userCrudRepository) {
        this.jwtUtils = jwtUtils;
        this.userCrudRepository = userCrudRepository;
    }


    @Override
    public CustomResponse<String> login(CredentialsDto credentials) {
        UserEntity userEntity = this.userCrudRepository.findUserByEmail(credentials.getUsername());
        if(userEntity != null){
            if(userEntity.getPassword().equals(credentials.getPassword())){
                String jwt = jwtUtils.create(userEntity);
                return new CustomResponse<>(jwt,"Token de acceso");
            }
        }

       return new CustomResponse<>("", HttpStatus.FAILED_DEPENDENCY.value(), "No autorizado");
    }


}
