package com.sngular.omb.ombapi.service;

import com.sngular.omb.ombapi.exception.ExceptionFormat;
import com.sngular.omb.ombapi.model.Account;

import java.util.List;
import java.util.Optional;

/**
 * Account service interface.
 * */
public interface AccountsService {

    /** Get accounts method
     * @return Account list.
     * @throws ExceptionFormat
     * */
    List<Account> getAccounts() throws ExceptionFormat;

    /** Create accounts method
     * @param account Account object.
     * @throws ExceptionFormat
     * */
    Account postAccounts(Account account) throws ExceptionFormat;

    /** Get accounts method
     * @param accountId  Account Id.
     * @return  Optional Account.
     * @throws ExceptionFormat
     * */
    Optional<Account> getAccountsById(String accountId) throws ExceptionFormat;
}
