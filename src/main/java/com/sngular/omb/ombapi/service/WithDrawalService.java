package com.sngular.omb.ombapi.service;

import com.sngular.omb.ombapi.exception.ExceptionFormat;
import com.sngular.omb.ombapi.model.request.WithdrawalRequest;
import com.sngular.omb.ombapi.model.response.WithdrawalResponse;

/**
 * Withdrawal service interface.
 * */
public interface WithDrawalService {

    /** Withdraw method by id account.
     * @param accountId Account Id.
     * @param withdrawReq Withdraw Request.
     * @return withdrawal response.
     * @throws ExceptionFormat exception format.
     * */
    WithdrawalResponse withdrawAmount(String accountId, WithdrawalRequest withdrawReq) throws ExceptionFormat;
}
