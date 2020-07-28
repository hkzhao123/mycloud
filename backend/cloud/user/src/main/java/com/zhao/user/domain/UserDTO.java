package com.zhao.user.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * <h3>cloud</h3>
 * <p></p>
 *
 * @author : hkzhao
 * @date : 2020-07-26 14:16
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private List<String> roles;
}