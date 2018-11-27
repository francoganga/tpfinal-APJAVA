package com.unaj.edu.models;
import lombok.*;

import com.unaj.edu.web.PasswordEncoder;


@Data
public class UserLogin {
    private String username;
    private String password;
    private String type;
    private String salt;
    

}