package com.designpattern.strategypattern.mapper;

import com.designpattern.strategypattern.mapper.entity.PaymentChannelEntity;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface PaymentChannelMapper {
     @Select("\n" +
             "SELECT * FROM payment_channel where channelId=#{payCode}")
     public PaymentChannelEntity getPaymentChannel(String payCode);
}
