package com.shun.yujian.order.dao;

import com.shun.yujian.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 *
 *
 * @author luoshun
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
