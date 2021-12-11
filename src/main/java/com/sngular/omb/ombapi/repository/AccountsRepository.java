package com.sngular.omb.ombapi.repository;

import com.sngular.omb.ombapi.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/** Account repository interface*/
public interface AccountsRepository extends MongoRepository<Account, String> {
}

