package com.backend.rybakowka.service;

import com.backend.rybakowka.dto.AccountDto;
import com.backend.rybakowka.model.Account;
import com.backend.rybakowka.repository.AccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountService {

    List<AccountDto> getListAccount();

    AccountDto findAccoundById(Long id);

    AccountDto findAccountByLogin(String login);

    AccountDto save(AccountDto account);

    AccountDto update(AccountDto account);

    ResponseEntity delete(Long id);
}
