package com.chdlsp.datapractice.service;

import com.chdlsp.datapractice.domain.entity.UserEntity;
import com.chdlsp.datapractice.domain.interfaces.request.CreateUserInfoRequestVO;
import com.chdlsp.datapractice.domain.interfaces.response.CreateUserInfoResponseVO;
import com.chdlsp.datapractice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TransactionDemoService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public UserEntity saveNewUserInfoWithDefault(CreateUserInfoRequestVO requestVO) {

        UserEntity saveInfo = UserEntity.builder()
                .email(requestVO.getEmail())
                .password(requestVO.getPassword())
                .build();

        return userRepository.save(saveInfo);
    }

    @Transactional(readOnly = true)
    public UserEntity saveNewUserInfoWithReadOnlyTrue(CreateUserInfoRequestVO requestVO) {

        UserEntity saveInfo = UserEntity.builder()
                .email(requestVO.getEmail())
                .password(requestVO.getPassword())
                .build();

        return userRepository.save(saveInfo);
    }
}
