package com.example.demo.Application;

import com.example.demo.Application.Dtos.CredentialsDto;
import com.example.demo.Application.Dtos.CustomResponse;

public interface IAccountService {
    CustomResponse<String> login(CredentialsDto credentials);
}
