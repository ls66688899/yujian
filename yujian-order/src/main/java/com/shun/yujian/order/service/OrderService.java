package com.shun.yujian.order.service;

import com.shun.yujian.common.utils.PageUtils;
import com.shun.yujian.order.entity.OrderEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 订单
 *
 * @author luoshun
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params) throws Exception;
}

