package com.sky.rbac.commons.pojo.dto.auth;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by rascaler on 8/7/17.
 */
@Getter
@Setter
public class RoleAuthDto {

    private Integer id;
    private String name;
    private String code;
    private List<String> privileges;
}
