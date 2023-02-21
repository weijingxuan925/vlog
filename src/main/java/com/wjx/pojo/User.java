package com.wjx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private int id;
    private String userAvatar;
    private String userDesc;
    private String userDisplayName;
    private String userEmail;
    private String userName;
    private String userPass;
}
