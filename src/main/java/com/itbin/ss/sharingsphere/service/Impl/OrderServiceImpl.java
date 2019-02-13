package com.itbin.ss.sharingsphere.service.Impl;

import com.itbin.ss.sharingsphere.mapper.OrderMapper;
import com.itbin.ss.sharingsphere.model.Order;
import com.itbin.ss.sharingsphere.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by LIBIN on 2019/2/13 16:28
 * Description:
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void add(int nums) {

        while(nums-- >0){
            long orderId = generateTaskId();
            Order orderEntity = new Order();

            orderEntity.setOrderId(orderId);
            orderEntity.setUserId(100000-nums);
            orderEntity.setStatus("Waiting for paying");
            orderMapper.insertSelective(orderEntity);

        }


    }

    private long generateTaskId(){
        try {
            Long now = System.currentTimeMillis();
            Random random = new Random();
            int randNum = random.nextInt(9999)+10000;
            String randStr = String.valueOf(now)+String.valueOf(randNum);
            return Long.parseLong(randStr);
        }catch (Exception e){
            log.error("生成随机的taskId失败");
            return System.currentTimeMillis();
        }
    }
}
