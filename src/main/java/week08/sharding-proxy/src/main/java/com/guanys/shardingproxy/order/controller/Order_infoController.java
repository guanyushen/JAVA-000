package com.guanys.shardingproxy.order.controller;


import com.guanys.shardingproxy.order.entity.Order_info;
import com.guanys.shardingproxy.order.service.IOrder_infoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author guanys
 * @since 2020-12-09
 */
@Controller
@RequestMapping("/order_info")
public class Order_infoController {

    @Autowired
    private IOrder_infoService service;

    @RequestMapping("/getById")
    public Order_info getById(@RequestParam("id") Integer id){
        return service.getById(id);
    }

    @RequestMapping("/add")
    public void add(@RequestBody Order_info bean){
        service.save(bean);
    }

    @RequestMapping("/update")
    public void update(@RequestBody Order_info bean){
        service.updateById(bean);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") Integer id){
        service.removeById(id);
    }
}
