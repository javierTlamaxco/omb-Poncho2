package com.sngular.omb.ombapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sngular.omb.ombapi.exception.ExceptionFormat;
import com.sngular.omb.ombapi.model.Account;
import com.sngular.omb.ombapi.model.request.WithdrawalRequest;
import com.sngular.omb.ombapi.model.response.WithdrawalResponse;
import com.sngular.omb.ombapi.service.WithDrawalService;
import com.sngular.omb.ombapi.util.AccountType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@SpringBootTest
@ActiveProfiles("test")
public class WithdrawalControllerTest {

    @Autowired
    WithDrawalController withDrawalController;

    @MockBean
    WithDrawalService withDrawalService;

    private static ObjectMapper mapper = new ObjectMapper();

    /***
     * Withdrawal controller test.
     * */
    @Test
    public void testPutWithdrawal() throws ExceptionFormat {

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Account account = new Account();
        account.setId("1");
        account.setName("Josua Smith Third");
        account.setAccountType(AccountType.checkingAccount);
        account.setDateBirth("1992-04-30");
        account.setInitialBalance(200.0);
        account.setCurrentBalance(200.0);
        account.setRoutingNumber("12455554118");
        account.setAccountNumber("787878784484");

        WithdrawalRequest withdrawalRequest = new WithdrawalRequest();
        withdrawalRequest.setAmount(100.0);

        WithdrawalResponse withdrawalResponse = new WithdrawalResponse();
        withdrawalResponse.setAccountId(account.getId());
        withdrawalResponse.setCurrentBalance(100.0);

        ResponseEntity<WithdrawalResponse> responseEntity = withDrawalController.postWithdrawal("1",withdrawalRequest);

        Mockito.when(withDrawalService.withdrawAmount(account.getId(), withdrawalRequest)).thenReturn(withdrawalResponse);

       Assertions.assertEquals(200,responseEntity.getStatusCodeValue());

        }

/*        WithdrawalResponse withdrawalResponse = new WithdrawalResponse();
      //  Mockito.when(put("/accounts/{accountId}/withdraw/"))
       //         .andEx

    }*/
}
