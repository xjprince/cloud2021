package com.atguigu.springcloud.alibaba.service.impl;


import com.atguigu.springcloud.alibaba.dao.AccountDao;
import com.atguigu.springcloud.alibaba.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 账户业务实现类
 */
@Service
public class AccountServiceImpl implements AccountService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);


	@Resource
	AccountDao accountDao;

	/**
	 * 扣减账户余额
	 */
	@Override
	public void decrease(Long userId, BigDecimal money) {

		LOGGER.info("------->account-service中扣减账户余额开始");
		accountDao.decrease(userId, money);
		LOGGER.info("------->account-service中扣减账户余额结束");
	}
}

