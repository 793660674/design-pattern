package com.designpattern.strategypattern.controller;

import com.designpattern.strategypattern.StartegyInterface.StrategyContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Tj
 * @Date: 2019/5/8 14:48
 * @Description:
 */

@RestController
@RequestMapping(value = "/strategyPattern")
@Api(description = "策略模式测试 swagger")
public class StrategyController {
    @Autowired
    private StrategyContext strategyContext;


    @ApiOperation(value = "测试")
    @RequestMapping(value = "/test" , method = RequestMethod.GET)
    @ApiImplicitParam(name = "payCode", value = "payCode", required = true, dataType = "String",paramType = "query")
    public Object strategyPatternTest(String payCode){
        if(StringUtils.isEmpty(payCode)){
            return "渠道code不能为空!";
        }
        return strategyContext.toPay(payCode);
    }
}