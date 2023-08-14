package com.shun.yujian.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shun.yujian.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 属性&属性分组关联
 *
 * @author luoshun
 * @email
 * @date
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}
