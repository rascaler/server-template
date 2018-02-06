package com.sky.rbac.commons.constant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * 注意：各个模块都需要在这个类中注册异常编码
 *
 *
 *
 * 公共状态码基类,规范公共状态码,不同系统要继承该类
 * 异常码格式：AAABBBCCCC
 * AA 系统编码  BBB 系统模块编码  CCCC 异常编码
 * 10 001 0001
 * Created by wurenqing on 3/17/17.
 */
public class RbacEcode implements Serializable {

    ///////////////////////////// organization  10001
    /** 组织不存在 */
    public final static String ORGANIZATION_NOT_EXISTS = "100010001";

    /** 组织中存在用户 */
    public final static String ORGANIZATION_HAS_USERS = "100010002";

    /** 不能删除根组织 */
    public final static String CAN_NOT_DELETE_ROOT = "100010003";

    /** 组织存在子组织 */
    public final static String ORGANIZATION_HAS_CHILDREN = "100010004";

   ///////////////////////////// user  10002
    /** 用户不存在 */
   public final static String USER_NOT_EXISTS = "100020001";

    ///////////////////////////// role  10003
    /** 角色不存在 */
    public final static String ROLE_NOT_EXISTS = "100030001";

    /** 角色在使用中 */
    public final static String ROLE_IN_USE = "100030002";

    ///////////////////////////// privilege  10004
    /** 权限不存在 */
    public final static String PRIVILEGE_NOT_EXISTS = "100040001";

    ///////////////////////////// menu  10005
    public final static String MENU_HAS_CHILDREN = "100050001";



}
