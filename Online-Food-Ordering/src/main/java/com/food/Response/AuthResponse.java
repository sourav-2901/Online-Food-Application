package com.food.Response;

import com.food.Model.UserRole;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private String jwt;
    private String message;
    private UserRole role;

}
