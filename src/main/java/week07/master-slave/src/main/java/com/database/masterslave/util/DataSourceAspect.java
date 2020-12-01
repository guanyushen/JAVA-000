package com.database.masterslave.util;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * @Author: guanys
 * @version: V1.0
 * @Package: com.database.masterslave.util
 * @ClassName: DataSourceAspect
 * @Description:
 * @Date: 2020/12/1 15:03
 */

@Slf4j
@Aspect
@Component
public class DataSourceAspect implements Ordered {

    @Pointcut("@annotation(com.database.masterslave.util.readOnly)")
    public void dataSourcePointCut() {

    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        readOnly ds = method.getAnnotation(readOnly.class);
        if (ds == null) {
            DynamicDataSource.setDataSource(DataSourceNames.FIRSET_DATASOURCE);
            log.debug("set datasource is " + DataSourceNames.FIRSET_DATASOURCE);
        } else {
            DynamicDataSource.setDataSource(ds.name());
            log.debug("set datasource is " + ds.name());
        }

        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
            log.debug("clean datasource");
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
