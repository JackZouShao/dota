package com.alex.common.feign.inteface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "dota-user-service")
public interface FeignLoginController {

    @GetMapping(value = "/login/test")
    public String test();
}
