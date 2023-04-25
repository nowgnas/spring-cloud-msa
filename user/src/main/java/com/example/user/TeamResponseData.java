package com.example.user;

import lombok.Builder;
import lombok.Data;

@Data
public class TeamResponseData {
    private String name;

    @Builder
    public TeamResponseData(String name) {
        this.name = name;
    }
}
