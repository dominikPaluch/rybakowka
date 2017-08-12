package com.backend.rybakowka.conrtoller;

import com.backend.rybakowka.dto.AccountDto;
import com.backend.rybakowka.model.Account;
import com.backend.rybakowka.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountDto> getListAccount() {
        return accountService.getListAccount();
    }

    @GetMapping(value = "/{id}")
    public AccountDto findAccountById(@PathVariable Long id) {
        return accountService.findAccoundById(id);
    }

    //?
    @GetMapping(value = "find")
    public AccountDto findAccoundByLogin(@RequestParam("login") String login){
        return accountService.findAccountByLogin(login);
    }

    @PostMapping()
    public @ResponseBody
    AccountDto save(@RequestBody @Valid AccountDto account) {
        accountService.save(account);

        return account;
    }

    @PutMapping(value = "/update/{id}")
    public @ResponseBody
    AccountDto update(@PathVariable("id") Long id, @RequestBody AccountDto account) {
        account.setId(id);
        accountService.update(account);
        return account;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        return accountService.delete(id);
    }
}
