package com.itbin.ss.sharingsphere.model;

import lombok.Data;

import javax.persistence.Table;

/**
 * Created by LIBIN on 2019/2/13 16:26
 * Description:
 */
@Data
@Table(name = "t_order")
public class Order {


    private Long orderId;

    private Integer userId;

    private String status;
}
