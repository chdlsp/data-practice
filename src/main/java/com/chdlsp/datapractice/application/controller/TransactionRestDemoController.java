package com.chdlsp.datapractice.application.controller;

import com.chdlsp.datapractice.domain.entity.UserEntity;
import com.chdlsp.datapractice.domain.interfaces.request.CreateUserInfoRequestVO;
import com.chdlsp.datapractice.service.TransactionDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/users")
public class TransactionRestDemoController {

    @Autowired
    private TransactionDemoService transactionDemoService;

    @PostMapping("/success")
    public ResponseEntity saveNewUserInfoWithDefault(@RequestBody CreateUserInfoRequestVO createUserInfoRequestVO) {

        log.info("createUserInfoRequestVO : " + createUserInfoRequestVO.toString());

        UserEntity userEntity = transactionDemoService.saveNewUserInfoWithDefault(createUserInfoRequestVO);

        log.info("saveNewUserInfoWithDefault : " + userEntity.toString());

        return ResponseEntity.ok(userEntity);
    }

    @PostMapping("/failure")
    public ResponseEntity saveNewUserInfoWithReadOnly(@RequestBody CreateUserInfoRequestVO createUserInfoRequestVO) {

        UserEntity userEntity = transactionDemoService.saveNewUserInfoWithReadOnlyTrue(createUserInfoRequestVO);

        log.info("saveNewUserInfoWithReadOnly : " + userEntity.toString());

        return ResponseEntity.ok(userEntity);
    }

}
