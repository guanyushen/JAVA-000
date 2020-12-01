package com.database.masterslave.autocreate.service;

import com.database.masterslave.autocreate.entity.T1;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author guanys
 * @since 2020-12-01
 */
public interface IT1Service extends IService<T1> {

    public List<Integer> getList();

    public void add(Integer id);
}
