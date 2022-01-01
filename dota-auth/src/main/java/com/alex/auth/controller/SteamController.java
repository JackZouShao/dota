package com.alex.auth.controller;

import com.alex.common.exceptions.BusinessException;
import com.alex.common.steam.SteamApi;
import com.alex.common.util.RJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.ArrayDeque;
import java.util.Deque;

@Slf4j
@Api(tags = "steam api reference")
@RestController
@RequestMapping("/steam")
@RequiredArgsConstructor
public class SteamController {

	@Value("dota.url")
	private String domain;

	@ApiOperation("获取steam token")
	@RequestMapping(value = "/token", method = RequestMethod.GET)
	public RJson<String> getLoginUrl()  {
		String token;

		try {
			token = SteamApi.getUrl(domain);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			log.error("获取 steam token 错误");
			throw new BusinessException("获取 steam token 错误");
		}
		return RJson.ok(token);
	}
}
