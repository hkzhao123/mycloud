package com.zhao.oauth.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * <h3>cloud</h3>
 * <p></p>
 *
 * @author : hkzhao
 * @date : 2020-07-26 13:48
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class UserDTO{
    private Long id;
    private String username;
    private String password;
    private Integer status;
    private List<String> roles;

}
