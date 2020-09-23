package com.chdlsp.datapractice.repository;

import com.chdlsp.datapractice.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    boolean existsByEmail(String email);

}
