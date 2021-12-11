package com.sngular.omb.ombapi.controller;

import com.sngular.omb.ombapi.service.AccountsService;
import jdk.jfr.MemoryAddress;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class AccountsControllerTest {

    @Autowired
    AccountsController accountsController;

    @Mock
    AccountsService accountsService;

    @Test
    public void getAccounts_test(){


    }

}
