package com.sky.stock.web.controller;

import com.huobi.api.ApiClient;
import com.huobi.response.KlineResponse;
import com.sky.commons.web.annotation.OuterResponseBody;
import com.sky.stock.infrastructure.mapper.KlineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/4/1 14:09
 */
@Controller
@RequestMapping("/kline")
public class KlineController {

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    @OuterResponseBody
    KlineResponse start() {
        String API_KEY = "ad0ec705-ae83da3e-5e595370-d9517";
        String API_SECRET = "8b321ade-4442682f-db441702-84d43";
        ApiClient client = new ApiClient(API_KEY, API_SECRET);
        return client.kline("btcusdt", "5min", "100");
    }

    @Autowired
    private KlineMapper klineMapper;


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @OuterResponseBody
    void test() {
        klineMapper.selectAll();
    }
}
