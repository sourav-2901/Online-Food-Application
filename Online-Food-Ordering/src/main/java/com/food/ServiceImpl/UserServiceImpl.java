package com.food.ServiceImpl;

import com.food.Config.JwtProvider;
import com.food.Model.User;
import com.food.Repository.UserRepository;
import com.food.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;
    public User findUserByJwtToken(String jwt) throws Exception{
        String email=jwtProvider.getEmailFromJwtToken(jwt);
        if(null!=email){
            return findUserByEmail(email);
        } else{
            throw new Exception("User Not Found !");
        }
    }

    public User findUserByEmail(String email) throws Exception{
        User user=userRepository.findByEmail(email);
        if(null==user){
            throw new Exception("User Not Found !");
        }
        return user;
    }

}
