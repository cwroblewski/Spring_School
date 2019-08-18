package com.szkola.Szkola.serviceImpl;

import com.szkola.Szkola.model.SystemUser;
import com.szkola.Szkola.repository.SystemUserRepository;
import com.szkola.Szkola.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemUserServiceImpl implements SystemUserService
{

    @Autowired
    SystemUserRepository systemUserRepository;

    @Override
    public SystemUser save(SystemUser systemUser) {return systemUserRepository.save(systemUser);}
}
