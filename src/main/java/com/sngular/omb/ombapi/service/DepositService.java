package com.sngular.omb.ombapi.service;

import com.sngular.omb.ombapi.exception.ExceptionFormat;
import com.sngular.omb.ombapi.model.request.DepositRequest;
import com.sngular.omb.ombapi.model.response.DepositResponse;

/**
 * Account Deposit Service interface.
 * */
public interface DepositService {

    /** Make deposit account method.
     * @param accountId Account Id-
     * @param depositRequest Deposit Request.
     * @return DepositResponse deposite response.
     * @throws ExceptionFormat
     * */
    DepositResponse makeDeposit(String accountId, DepositRequest depositRequest) throws ExceptionFormat;
}
