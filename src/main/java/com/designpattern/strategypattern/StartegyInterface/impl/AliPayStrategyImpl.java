package com.designpattern.strategypattern.StartegyInterface.impl;

import com.designpattern.strategypattern.StartegyInterface.Strategy;
import org.springframework.stereotype.Component;

/**
 * @Auther: Tj
 * @Date: 2019/5/8 14:52
 * @Description:
 */
@Component
public class AliPayStrategyImpl implements Strategy {
    @Override
    public String toPay() {
        return "聚合支付平台，策略模式，支付宝平台";
    }
}