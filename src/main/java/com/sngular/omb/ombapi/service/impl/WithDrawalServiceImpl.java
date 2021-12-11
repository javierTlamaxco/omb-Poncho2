package com.sngular.omb.ombapi.service.impl;

import com.sngular.omb.ombapi.exception.ExceptionFormat;
import com.sngular.omb.ombapi.model.Account;
import com.sngular.omb.ombapi.model.request.WithdrawalRequest;
import com.sngular.omb.ombapi.model.response.WithdrawalResponse;
import com.sngular.omb.ombapi.repository.AccountsRepository;
import com.sngular.omb.ombapi.service.WithDrawalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Class implements interface WithDrawalService
 * */
@Service
@Slf4j
public class WithDrawalServiceImpl implements WithDrawalService {

    /**Accounts Repository.*/
    @Autowired
    AccountsRepository accountsRepository;

    /**Account Withdrawal method service
     *
     * @param  accountId  account Id.
     * @param withdrawReq withdrawalReq.
     * @throws ExceptionFormat if theres an Exception.
     *
     * @return WithdrawalResponse.
     * */
    @Override
    public WithdrawalResponse withdrawAmount(String accountId, WithdrawalRequest withdrawReq) throws ExceptionFormat {
        Optional<Account> accountOptional = accountsRepository.findById(accountId);
        WithdrawalResponse withdrawalResponse = new WithdrawalResponse();
        if(accountOptional.isPresent()) {
            Account account = accountOptional.get();

            if (account.getCurrentBalance()==null){
                account.setCurrentBalance(account.getInitialBalance());
            }
            if (account.getCurrentBalance() < withdrawReq.getAmount()) {
                withdrawalResponse.setAccountId("You do not have enough funds");
                withdrawalResponse.setCurrentBalance(account.getCurrentBalance());
                log.info("The account " + account.getId() + " doesn't have founds");
            } else {
                account.setCurrentBalance(account.getCurrentBalance() - withdrawReq.getAmount());
                accountsRepository.save(account);
                withdrawalResponse.setAccountId(account.getId());
                withdrawalResponse.setCurrentBalance(account.getCurrentBalance());
                log.info("The Current Balance from account " + account.getId() + " is " + account.getCurrentBalance());
            }

        } else {
            log.error("Account not Found");
            return new WithdrawalResponse("Account not Found",0.0);
        }
        return  withdrawalResponse;
    }
}
