package com.zhao.user.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <h3>cloud</h3>
 * <p></p>
 *
 * @author : hkzhao
 * @date : 2020-07-23 18:06
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class User {
    @ApiModelProperty("用户ID")
    private Long id;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("密码")
    private String password;
}