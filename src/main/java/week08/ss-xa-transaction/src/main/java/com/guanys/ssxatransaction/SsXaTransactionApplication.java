package com.guanys.ssxatransaction;

import com.guanys.ssxatransaction.order.entity.Order_info;
import com.guanys.ssxatransaction.order.service.IOrder_infoService;
import com.guanys.ssxatransaction.order.service.XAService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@MapperScan("com.guanys.ssxatransaction.order.mapper")
@SpringBootApplication
public class SsXaTransactionApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SsXaTransactionApplication.class, args);
        sSXAStart(applicationContext);
    }

    public static void sSXAStart(ConfigurableApplicationContext context) {

        XAService service = context.getBean(XAService.class);
        List<Order_info> list = service.addTenOrderInfo();
        log.info("Order_info list: {}", list);

        List<Order_info> rollbackUserList = new ArrayList<>();
        try {
            service.addTenOrderInfoWithError(rollbackUserList);
        } catch (Exception e) {
            log.warn("rollback", e);
        }

        IOrder_infoService orderService = context.getBean(IOrder_infoService.class);
        Order_info orderInfo = orderService.getById(rollbackUserList.get(0).getOrder_id());
        log.info("order -- null: {}", orderInfo);
    }

}
