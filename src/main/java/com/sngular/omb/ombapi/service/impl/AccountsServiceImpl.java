package com.sngular.omb.ombapi.service.impl;

import com.sngular.omb.ombapi.exception.ExceptionFormat;
import com.sngular.omb.ombapi.model.Account;
import com.sngular.omb.ombapi.repository.AccountsRepository;
import com.sngular.omb.ombapi.service.AccountsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Class implements interface AccountService
 * */
@Service
@Slf4j
public class AccountsServiceImpl implements AccountsService {

    /**Accounts Repository.*/
    @Autowired
    AccountsRepository accountsRepository;

    /**Get Accounts method service.
     *
     * @throws ExceptionFormat if theres an Exception.
     *
     * @return Account List.
     * */
    @Override
    public List<Account> getAccounts()  throws ExceptionFormat {

        if(!accountsRepository.findAll().isEmpty()){
            return accountsRepository.findAll();
        }
        return null;
    }

    /**Insert new Accounts method service.
     *
     * @throws ExceptionFormat if theres an Exception.
     *
     * @return Account.
     * */
    @Override
    public Account postAccounts(Account account) throws ExceptionFormat {
    try{
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        account.setCurrentBalance(account.getInitialBalance());
        account.setOpenDate(formatter.format(date));
       return  accountsRepository.insert(account);
    } catch (Exception exp){
        log.error("Can't create ");
        throw new ExceptionFormat(400,"Exception creating account"+exp, HttpStatus.BAD_REQUEST);
    }

    }

    /**Get Accounts method service by Id.
     *
     * @param
     * @throws ExceptionFormat if theres an Exception.
     *
     * @return Optional Account.
     * */
    @Override
    public Optional<Account> getAccountsById(String accountId) throws ExceptionFormat {

        try {
            if(accountsRepository.findById(accountId).isEmpty()){
                return Optional.empty();
            }   else {
                log.info("Account found " + accountId);
                return accountsRepository.findById(accountId);
            }
        } catch (Exception exp){
            log.error("Account not found"+accountId);
            throw new ExceptionFormat(400,"Not Found Account"+exp,HttpStatus.BAD_REQUEST);
        }

    }
}
