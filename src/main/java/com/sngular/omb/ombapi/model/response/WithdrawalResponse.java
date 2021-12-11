package com.sngular.omb.ombapi.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Withdrawal Response
 * */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WithdrawalResponse {

    /**Account Id Info.*/
    private String accountId;

    /**Current Balance from Account Id.*/
    private Double currentBalance;
}
