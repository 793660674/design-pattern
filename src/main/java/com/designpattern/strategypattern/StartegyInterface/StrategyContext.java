package com.designpattern.strategypattern.StartegyInterface;

import com.designpattern.strategypattern.mapper.PaymentChannelMapper;
import com.designpattern.strategypattern.mapper.entity.PaymentChannelEntity;
import com.designpattern.strategypattern.utils.SpringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: Tj
 * @Date: 2019/5/8 14:56  聚合支付平台 策略
 * @Description:
 */
@Component
public class StrategyContext {
    @Autowired
    private PaymentChannelMapper mapper;
    @Autowired
    private SpringUtils springUtil;

    public String toPay(String beanCode){
        //判断 beancode 是否为空
        if (StringUtils.isEmpty(beanCode)){
            return "beanCode 不能为空";
        }
        //从数据库中获取 支付渠道的具体信息，
        // 优化方案 ，可以存在缓存中 项目启动的时候 就加载进去 直接从缓存中获取
        PaymentChannelEntity paymentChannelEntity=mapper.getPaymentChannel(beanCode);
        //判断传的beancode 是否 合法， 是否拥有正确的支付渠道
        if (paymentChannelEntity==null){
            return "渠道不能为空";
        }
        //beanId 不能为空 为空则无法获取 对应spring容器中的 对象
        if (StringUtils.isEmpty(paymentChannelEntity.getStrategyBeanId())){
            return "beanId 为空 请联系管理";
        }
        Strategy strategy=springUtil.getBean(paymentChannelEntity.getStrategyBeanId(),Strategy.class);
        return strategy.toPay();
    }

}