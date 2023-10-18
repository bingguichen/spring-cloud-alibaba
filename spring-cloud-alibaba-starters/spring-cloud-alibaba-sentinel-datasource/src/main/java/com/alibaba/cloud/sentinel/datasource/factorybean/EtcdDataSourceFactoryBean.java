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

package com.alibaba.cloud.sentinel.datasource.factorybean;


import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.datasource.etcd.EtcdConnectionConfig;
import com.alibaba.csp.sentinel.datasource.etcd.EtcdDataSource;
import com.alibaba.csp.sentinel.log.RecordLog;
import com.google.gson.JsonObject;
import io.netty.handler.codec.json.JsonObjectDecoder;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.util.StringUtils;

/**
 * A {@link FactoryBean} for creating {@link EtcdDataSource} instance.
 *
 * @author <a href="mailto:mengjindc@gmail.com">mengjin</a>
 * @see EtcdDataSource
 */
public class EtcdDataSourceFactoryBean implements FactoryBean<EtcdDataSource> {

	private String endpoints;
	private boolean authEnable;
	private String authority;
	private String charset;
	private String user;
	private String password;

	private String ruleKey;

	private Converter converter;

	@Override
	public EtcdDataSource getObject() throws Exception {
		EtcdConnectionConfig.Builder builder = EtcdConnectionConfig.builder();
		if (StringUtils.hasText(endpoints)) {
			builder.withEndpoints(endpoints);
		}
		if (isAuthEnable()) {
			builder.withUser(user).withPassword(password).withAuthority(authority).withCharset(charset);
		}
		RecordLog.info("[EtcdDataSource] init builder");
		return new EtcdDataSource(builder.build(), ruleKey, converter);
	}

	@Override
	public Class<?> getObjectType() {
		return EtcdDataSource.class;
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

	public Converter getConverter() {
		return converter;
	}

	public void setConverter(Converter converter) {
		this.converter = converter;
	}
}
