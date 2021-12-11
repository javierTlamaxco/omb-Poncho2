package com.sngular.omb.ombapi.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Withdrawal Request class.
 * */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class WithdrawalRequest {

    /** withdrawal value*/
    private Double amount;
}
