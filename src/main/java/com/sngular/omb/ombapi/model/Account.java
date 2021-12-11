package com.sngular.omb.ombapi.model;

import com.sngular.omb.ombapi.util.AccountType;
import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@Getter
@Setter
@Data
@Document(collection = "accounts")
public class Account {

    /**Id Account*/
    @Id
    private String id;

    /**Name*/
    @NotEmpty(message = "Name is mandatory")
    @Size (min = 3, message = "The name should have at least 3 charaters")
    private String name;

    /**Account Type*/
    @NotNull(message = "Must define an Account Type")
    private AccountType accountType;

    /**Date Birth*/
    @NotEmpty(message = "Date Birth is mandatory")
    private String dateBirth;

    /**Initial Balance*/
    @NotNull(message = "Initial Balance is mandatory")
    private Double initialBalance;

    /**Routing Number*/
    private String routingNumber;

    /**Account Number*/
    private String accountNumber;

    /**Open Date*/
    private String openDate;

    /**Currente Balance*/
    private Double currentBalance;

    /**Contructor for new Accounts*/
    public Account(String name, String routingNumber, String accountNumber, String openDate, double currentBalance) {
    }

    /**Empty Contructor for new Accounts*/
    public Account() {

    }
}
