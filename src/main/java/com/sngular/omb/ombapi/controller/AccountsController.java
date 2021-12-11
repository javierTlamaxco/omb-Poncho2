package com.sngular.omb.ombapi.controller;

import com.sngular.omb.ombapi.exception.ExceptionFormat;
import com.sngular.omb.ombapi.model.Account;
import com.sngular.omb.ombapi.service.AccountsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
/**
 * Account Controller class.
 * */
@RestController
@CrossOrigin(origins = "*")
@Slf4j
public class AccountsController {
    /**Service Account*/
    @Autowired
    private AccountsService accountsService;

    /**Controller for get all Accounts.
     * @return ResponseEntity account list.
     *
     * @throws ExceptionFormat exception format.
     * */
    @GetMapping("/accounts")
    @ResponseBody
    @ApiOperation(value = "Method Get Accounts for OMB",
                    response = Account.class,
                notes = "Method get all the accounts from OMB")
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                            message = "Successfull",response = Account.class),
            @ApiResponse(code = 500,
                    message = "Processing error in the request",response = Account.class),
            @ApiResponse(code = 400,
            message = "Invalid entrance parameters",response = Account.class)
    })
    public ResponseEntity<List<Account>> getAccounts() throws ExceptionFormat {
       if(!accountsService.getAccounts().isEmpty()){
           log.info("Entrando a Consultar cuentas");
            return new ResponseEntity<>(accountsService.getAccounts(),HttpStatus.OK);
        }
       log.error("No hay informacion de cuentas");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**Controller for get Accounts by Id.
     * @param id id Account.
     * @return ResponseEntity Account.
     *
     * @throws ExceptionFormat
     * */
    @GetMapping("/accounts/{id}")
    @ResponseBody
    @ExceptionHandler(ExceptionFormat.class)
    @ApiOperation(value = "Method Get Accounts by id for OMB",
            response = Account.class,
            notes = "Method get all the accounts by from OMB")
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successfull",response = Account.class),
            @ApiResponse(code = 500,
                    message = "Processing error in the request",response = Account.class),
            @ApiResponse(code = 400,
                    message = "Invalid entrance parameters",response = Account.class)
    })
    public ResponseEntity<Account> getAccounts(@PathVariable String id) throws ExceptionFormat {
        if(!accountsService.getAccountsById(id).isEmpty()) {
            log.info("Getting account info" + id);
            return new ResponseEntity(accountsService.getAccountsById(id),HttpStatus.OK);
        } else {
            log.error("The given account identifier was not found" + id);
            throw  new ExceptionFormat(400,"The given account identifier was not found",HttpStatus.NOT_FOUND);
        }
    }

    /**Controller to Create Accounts
     * @param account Account model.
     * @return ResponseEntity Account.
     * @throws ExceptionFormat exception format.
     * */
    @PostMapping("/accounts")
    @ApiOperation(value = "Method Post Accounts for OMB",
            response = Account.class,
            notes = "Method create new accounts from OMB")
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Inserted Successfully",response = Account.class),
            @ApiResponse(code = 500,
                    message = "Processing error in the request",response = Account.class),
            @ApiResponse(code = 400,
                    message = "Invalid entrance parameters",response = Account.class)
    })
        public ResponseEntity<Account> postAccounts (@Valid @RequestBody(required = true) Account account) throws ExceptionFormat {

        if(account != null) {
           Account savedAccount= accountsService.postAccounts(account);
            log.info("Register inserted"+ account);
            return new ResponseEntity<Account>(savedAccount,HttpStatus.ACCEPTED);
        } else {
            log.error("There is no data on the request");
            return new ResponseEntity<Account>(new Account(),HttpStatus.BAD_REQUEST);
           // return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
        }
}
