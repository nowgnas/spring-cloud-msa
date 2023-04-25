package com.example.user.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseData {
    private Long userId;
    private String username;
    private TeamResponseData team;

}
