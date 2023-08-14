package com.shun.yujian.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shun.yujian.common.utils.PageUtils;
import com.shun.yujian.user.entity.UserEntity;

import java.util.Map;

/**
 * 属性&属性分组关联
 *
 * @author luoshun
 * @email
 * @date
 */
public interface UserService extends IService<UserEntity> {

    PageUtils queryPage(Map<String, Object> params) throws Exception;

}

