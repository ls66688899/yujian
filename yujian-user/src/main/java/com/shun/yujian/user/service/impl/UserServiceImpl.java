package com.shun.yujian.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shun.yujian.common.utils.PageUtils;
import com.shun.yujian.common.utils.Query;
import com.shun.yujian.user.dao.UserDao;
import com.shun.yujian.user.entity.UserEntity;
import com.shun.yujian.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("UserService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Exception {
        IPage<UserEntity> page = this.page(
                new Query<UserEntity>().getPage(params),
                new QueryWrapper<UserEntity>()
        );

        return new PageUtils(page);
    }



}