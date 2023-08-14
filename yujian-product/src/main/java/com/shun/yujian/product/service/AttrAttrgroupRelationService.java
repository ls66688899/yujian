package com.shun.yujian.product.service;

import com.shun.yujian.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shun.yujian.product.entity.AttrAttrgroupRelationEntity;

import java.util.Map;

/**
 * 属性&属性分组关联
 *
 * @author luoshun
 * @email
 * @date
 */
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelationEntity> {

    PageUtils queryPage(Map<String, Object> params) throws Exception;

}

