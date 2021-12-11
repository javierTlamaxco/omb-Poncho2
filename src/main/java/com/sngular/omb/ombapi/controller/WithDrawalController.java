package com.sngular.omb.ombapi.controller;

import com.sngular.omb.ombapi.exception.ExceptionFormat;
import com.sngular.omb.ombapi.model.Account;
import com.sngular.omb.ombapi.model.request.WithdrawalRequest;
import com.sngular.omb.ombapi.model.response.WithdrawalResponse;
import com.sngular.omb.ombapi.service.WithDrawalService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * Service class for withdrawal services.
 * */
@RestController
@CrossOrigin(origins = "*")
@Slf4j
public class WithDrawalController {

    /**Withdrawal Service*/
    @Autowired
    WithDrawalService withDrawalService;

    /**
     * Service for withdrawal with id Client
     *
     * @param accountId Account ID.
     * @param  withdrawalRequest withdrawal request.
     *
     * @return WithdrawalResponse withdrawal Response.
     * @throws ExceptionFormat the exception format
     * */
    @PutMapping("/accounts/{accountId}/withdraw/")
    @ApiOperation(value = "Method Put withdrawal for OMB",
            response = WithdrawalResponse.class,
            notes = "Method put for withdrawal from an account from OMB")
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successfull",response = WithdrawalResponse.class),
            @ApiResponse(code = 500,
                    message = "Processing error in the request",response = WithdrawalResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid entrance parameters",response = WithdrawalResponse.class)
    })
    public ResponseEntity<WithdrawalResponse> postWithdrawal(@PathVariable String accountId, @RequestBody WithdrawalRequest withdrawalRequest) throws ExceptionFormat {

        if (withdrawalRequest.getAmount() < 0.0) {
            return new ResponseEntity(new WithdrawalResponse(accountId,withdrawalRequest.getAmount()),HttpStatus.BAD_REQUEST);
        }
        log.info(accountId, withdrawalRequest.getAmount());
        return new ResponseEntity(withDrawalService.withdrawAmount(accountId, withdrawalRequest), HttpStatus.OK) ;
    }


}
