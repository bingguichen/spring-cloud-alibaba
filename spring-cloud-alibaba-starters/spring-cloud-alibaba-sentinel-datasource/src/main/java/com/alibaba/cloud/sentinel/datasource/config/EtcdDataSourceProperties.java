/*
 * Copyright 2013-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.cloud.sentinel.datasource.config;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.cloud.sentinel.datasource.factorybean.EtcdDataSourceFactoryBean;


/**
 * Consul Properties class Using by {@link DataSourcePropertiesConfiguration} and
 * {@link EtcdDataSourceFactoryBean}.
 *
 * @author <a href="mailto:mengjindc@gmail.com">mengjin</a>
 */
public class EtcdDataSourceProperties extends AbstractDataSourceProperties {

	public EtcdDataSourceProperties() {
		super(EtcdDataSourceFactoryBean.class.getName());
	}

	private String endpoints;
	private boolean authEnable;
	private String authority;
	private String charset;
	private String user;
	private String password;

	private String ruleKey;

	@Override
	public void preCheck(String dataSourceName) {
		if (StringUtils.isEmpty(endpoints)) {
			throw new IllegalArgumentException("EtcdDataSource endpoints is empty");
		}
		if (StringUtils.isEmpty(ruleKey)) {
			throw new IllegalArgumentException(
					"EtcdDataSource ruleKey can not be empty");
		}
	}

	public String getEndpoints() {
		return endpoints;
	}

	public void setEndpoints(String endpoints) {
		this.endpoints = endpoints;
	}

	public boolean isAuthEnable() {
		return authEnable;
	}

	public void setAuthEnable(boolean authEnable) {
		this.authEnable = authEnable;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRuleKey() {
		return ruleKey;
	}

	public void setRuleKey(String ruleKey) {
		this.ruleKey = ruleKey;
	}
}
