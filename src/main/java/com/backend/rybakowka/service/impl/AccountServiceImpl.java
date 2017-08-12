package com.backend.rybakowka.service.impl;

import com.backend.rybakowka.dto.AccountDto;
import com.backend.rybakowka.exception.AccountException;
import com.backend.rybakowka.model.Account;
import com.backend.rybakowka.repository.AccountRepository;
import com.backend.rybakowka.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDto> getListAccount() {
        return accountRepository.findAll().stream()
                .map(Account::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto findAccoundById(Long id) {
        return Optional.ofNullable(accountRepository.findOne(id))
                .orElseThrow(
                        () -> new AccountException("Account doesn't exixts!"))
                .toDto();
    }

    @Override
    public AccountDto findAccountByLogin(String login) {
        return accountRepository
                .findBylogin(login)
                .orElseThrow(
                        () -> new AccountException("There is no account with given login")
                ).toDto();
    }

    @Override
    public AccountDto save(AccountDto accountDto) {
        Account account = new Account(accountDto);
        return accountRepository.saveAndFlush(account).toDto();
    }

    @Override
    public AccountDto update(AccountDto accountDto) {
        Account account = new Account(accountDto);
        return accountRepository.saveAndFlush(account).toDto();
    }

    @Override
    public ResponseEntity delete(Long id) {
        accountRepository.delete(id);
        return ResponseEntity.ok().build();
    }

}
