package com.alex.common.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "steam api reference")
@RestController
@RequestMapping("/steam")
public class SteamController {

	public String getLoginUrl(String url){

		return null;

	}


}
