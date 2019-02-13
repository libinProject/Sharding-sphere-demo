package com.itbin.ss.sharingsphere.web;

import com.itbin.ss.sharingsphere.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LIBIN on 2019/2/13 16:28
 * Description:
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/add")
    public String add(){

        orderService.add(10);

        return "ok";
    }
}
