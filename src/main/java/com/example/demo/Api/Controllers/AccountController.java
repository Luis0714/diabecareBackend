package com.example.demo.Api.Controllers;

import com.example.demo.Application.Dtos.CredentialsDto;
import com.example.demo.Application.Dtos.CustomResponse;
import com.example.demo.Application.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/account")
public class AccountController {

    private final IAccountService accountService;
    @Autowired
    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/login")
    public CustomResponse<String> login(@RequestBody CredentialsDto credentials){
        return  accountService.login(credentials);
    }
}
