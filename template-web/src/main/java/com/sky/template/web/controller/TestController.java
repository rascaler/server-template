//package com.sky.template.web.controller;
//
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.*;
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import com.sky.rbac.commons.constant.BasicEcode;
//import com.sky.rbac.commons.exception.SPIException;
//import com.sky.rbac.commons.utils.json.DateJsonDeserializer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.IOException;
//import java.io.Serializable;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * @Author: wurenqing
// * @Description:
// * @Date 2017/4/1 14:09
// */
//@Controller
//public class TestController {
//
//    @Value("${server.port}")
//    private String serverPort;
//
//    @RequestMapping(value = "/test",method = RequestMethod.POST)
//    @ResponseBody
//    String testDate(@RequestBody Test test) {
//        return "Hello World1!";
//    }
//
//    @RequestMapping(value = "/test2",method = RequestMethod.GET)
//    @ResponseBody
//    String test2(Test2 test2) {
//        return "Hello World2!";
//    }
//
//    @RequestMapping(value = "/test3",method = RequestMethod.POST)
//    @ResponseBody
//    String test3(Test2 test2) {
//        return "Hello World2!";
//    }
//
//    @RequestMapping(value = "/test4",method = RequestMethod.GET)
//    @ResponseBody
//    String test4() {
//        throw new SPIException(BasicEcode.FAILED);
//    }
//
//
//}
//
//
//
//
//
//class Test implements Serializable{
//
//    @JsonDeserialize(using = DateJsonDeserializer.class)
//    private Date date;
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//}
//class Test2 implements Serializable{
//
//    @DateTimeFormat(pattern = "yyyy-MM-dd",iso = DateTimeFormat.ISO.DATE_TIME)
//    private Date date;
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//}
//
//class DateJsonSerializer extends JsonSerializer<Date> {
//
//    @Override
//    public void serialize(Date date, JsonGenerator generator, SerializerProvider provider)
//            throws IOException, JsonProcessingException {
//        ObjectMapper om = new ObjectMapper();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        om.writeValue(generator, sdf.format(date));
//    }
//
//}
//
