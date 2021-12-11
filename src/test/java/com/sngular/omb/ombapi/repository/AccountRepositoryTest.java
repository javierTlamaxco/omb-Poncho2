package com.sngular.omb.ombapi.repository;

import com.sngular.omb.ombapi.model.Account;
import com.sngular.omb.ombapi.util.AccountType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@DataMongoTest
public class AccountRepositoryTest {

/*    @BeforeEach
    void setUp(){
        this.account = new Account();
        this.account.setName("Josua Smith Third");
        this.account.setAccountType(AccountType.checkingAccount);
        this.account.setDateBirth("1992-04-30");
        this.account.setInitialBalance(200.0);
        this.account.setRoutingNumber("12455554118");
        this.account.setAccountNumber("787878784484");
    }

    @Autowired
    private Account account;

    @Autowired
    private AccountsRepository accountsRepository;

    @Test
    void whenFindByid_ReturnWithdrawalResponse(){

    }*/
}
