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

    @PostMapping("/")
    public ResponseEntity saveNewUserInfo(@RequestBody CreateUserInfoRequestVO createUserInfoRequestVO) {

        log.info("createUserInfoRequestVO : " + createUserInfoRequestVO.toString());

        UserEntity userEntity = transactionDemoService.saveNewUserInfoWithDefault(createUserInfoRequestVO);

        log.info("saveNewUserInfoWithDefault : " + userEntity);

        return ResponseEntity.ok(userEntity);
    }

    @GetMapping("/")
    public ResponseEntity getUserInfo(@RequestParam Long id) throws Exception {

        log.info("getUserInfo Id : " + id);

        UserEntity userEntity = transactionDemoService.getUserInfoById(id);

        log.info("getUserInfo : " + userEntity);

        return ResponseEntity.ok(userEntity);
    }


    @PutMapping("/")
    public ResponseEntity putUserInfo(@RequestBody CreateUserInfoRequestVO createUserInfoRequestVO) {

        log.info("putUserInfo : " + createUserInfoRequestVO.toString());

        UserEntity userEntity = transactionDemoService.putUserInfo(createUserInfoRequestVO);

        log.info("putUserInfo : " + userEntity.toString());

        return ResponseEntity.ok(userEntity);
    }


    @DeleteMapping("/")
    public ResponseEntity deleteUserInfo(@RequestParam Long id) {

        log.info("getUserInfo Id : " + id);

        int delResult = transactionDemoService.deleteUserInfoById(id);

        log.info("deleteUserInfo : " + delResult);

        return ResponseEntity.ok(delResult);
    }


    @PostMapping("/failure")
    public ResponseEntity saveNewUserInfoWithReadOnly(@RequestBody CreateUserInfoRequestVO createUserInfoRequestVO) {

        UserEntity userEntity = transactionDemoService.saveNewUserInfoWithReadOnlyTrue(createUserInfoRequestVO);

        log.info("saveNewUserInfoWithReadOnly : " + userEntity.toString());

        return ResponseEntity.ok(userEntity);
    }

}
