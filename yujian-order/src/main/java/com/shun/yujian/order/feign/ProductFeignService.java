package com.shun.yujian.order.feign;

import com.shun.yujian.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author luoshun
 * @since 2023/6/25
 * 声明式的远程调用
 */
@FeignClient("yujian-product")
public interface ProductFeignService {

    @RequestMapping("product/attrattrgrouprelation/order/list")
    public R orderProductList();


}
