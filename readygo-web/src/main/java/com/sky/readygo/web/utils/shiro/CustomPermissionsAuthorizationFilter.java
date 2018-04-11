package com.sky.readygo.web.utils.shiro;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sky.commons.utils.constant.BasicCode;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomPermissionsAuthorizationFilter extends PermissionsAuthorizationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
//        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
//        httpServletResponse.setContentType("application/json;charset=utf-8");
//        PrintWriter out = httpServletResponse.getWriter();
//        out.write(JSON.toJSONString(new OuterResult(BasicCode.PERMISSION_DENIED, "你无此操作权限"), SerializerFeature.WriteMapNullValue));
//
        return false;
    }

}