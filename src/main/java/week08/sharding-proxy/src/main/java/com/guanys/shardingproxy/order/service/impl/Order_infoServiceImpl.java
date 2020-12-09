package com.guanys.shardingproxy.order.service.impl;

import com.guanys.shardingproxy.order.entity.Order_info;
import com.guanys.shardingproxy.order.mapper.Order_infoMapper;
import com.guanys.shardingproxy.order.service.IOrder_infoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author guanys
 * @since 2020-12-09
 */
@Service
public class Order_infoServiceImpl extends ServiceImpl<Order_infoMapper, Order_info> implements IOrder_infoService {

}
