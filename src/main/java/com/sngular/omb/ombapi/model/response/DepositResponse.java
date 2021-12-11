package com.sngular.omb.ombapi.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Deposite Response class.
 * */
@AllArgsConstructor
@Builder
@Data
public class DepositResponse {

    /** Account Id*/
    private String accountId;

    /** Current Balance*/
    private Double currentBalance;

    /**Contructor for new Accounts*/
    public DepositResponse(String accountId, double currentBalance) {
    }
}
