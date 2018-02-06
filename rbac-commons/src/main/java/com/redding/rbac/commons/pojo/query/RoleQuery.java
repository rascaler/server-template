package com.sky.rbac.commons.pojo.query;

import com.sky.rbac.commons.pojo.BasePoJo;
import com.sky.rbac.commons.utils.annotation.EmptyToNullFormat;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/5/18 8:58
 */
@Getter
@Setter
public class RoleQuery extends BasePoJo{

    @EmptyToNullFormat
    private String name;

    /**
     * 角色状态
     */
    private Integer state;

    /**
     * 企业id
     */
    private Integer enterpriseId;

}
