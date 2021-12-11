package com.sngular.omb.ombapi.service;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.sngular.omb.ombapi.model.Account;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.client.MongoClients;

public class MongoApp {

    private static final Log log = LogFactory.getLog(MongoApp.class);

    public static void main(String[] args) throws Exception {

      /*  ConnectionString connectionString = new ConnectionString("mongodb+srv://userMongo:mongo$M0nG0@cluster0.juorh.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("test");*/

        MongoOperations mongoOps = new MongoTemplate(MongoClients.create(), "omb");

        Account cuenta = new Account();
        cuenta.setName("Account 29");
        cuenta.setRoutingNumber("1235");
        cuenta.setAccountNumber("9876");
        cuenta.setOpenDate("2021-04-28");
        cuenta.setCurrentBalance(0.0);

        mongoOps.insert(cuenta);

        log.info(mongoOps.findOne(new Query(where("name").is("Account 7")), Account.class));

    //    mongoOps.dropCollection("account");
    }
}