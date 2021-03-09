package com.alex.feign.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "dota-user-service")
public interface FeignLoginController {

    @GetMapping(value = "/login/test")
    public String test();
}
