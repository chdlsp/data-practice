package com.chdlsp.datapractice.application;

import com.chdlsp.datapractice.domain.entity.UserEntity;
import com.chdlsp.datapractice.domain.interfaces.request.CreateUserInfoRequestVO;
import com.chdlsp.datapractice.service.TransactionDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TransactionDemoController {

    @Autowired
    private TransactionDemoService transactionDemoService;

    @PostMapping("/users/success")
    public ResponseEntity saveNewUserInfoWithDefault(@RequestBody CreateUserInfoRequestVO createUserInfoRequestVO) {

        log.info("createUserInfoRequestVO : " + createUserInfoRequestVO.toString());

        UserEntity userEntity = transactionDemoService.saveNewUserInfoWithDefault(createUserInfoRequestVO);

        log.info("saveNewUserInfoWithDefault : " + userEntity.toString());

        return ResponseEntity.ok(userEntity);
    }

    @PostMapping("/users/failure")
    public ResponseEntity saveNewUserInfoWithReadOnly(@RequestBody CreateUserInfoRequestVO createUserInfoRequestVO) {

        UserEntity userEntity = transactionDemoService.saveNewUserInfoWithReadOnlyTrue(createUserInfoRequestVO);

        log.info("saveNewUserInfoWithReadOnly : " + userEntity.toString());

        return ResponseEntity.ok(userEntity);
    }

}
