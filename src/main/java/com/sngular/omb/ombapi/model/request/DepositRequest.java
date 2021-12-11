package com.sngular.omb.ombapi.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Deposit Request class.
 * */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class DepositRequest {

    /** Ammount value*/
    private Double amount;
}
