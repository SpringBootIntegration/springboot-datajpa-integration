/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.edurt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * DataJpaDataSourceConfig <br/>
 * 描述 : DataJpaDataSourceConfig <br/>
 * 作者 : qianmoQ <br/>
 * 版本 : 1.0 <br/>
 * 创建时间 : 2018-05-02 下午11:50 <br/>
 * 联系作者 : <a href="mailTo:shichengoooo@163.com">qianmoQ</a>
 */
@Configuration
public class DataJpaDataSourceConfig {

    @Autowired
    private Environment environment;

    @Bean
    @Description(value = "用于抽取配置文件中的配置属性, 并将其映射为数据源")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("datajpa.source.driver-class"));
        dataSource.setUrl(environment.getProperty("datajpa.source.url"));
        dataSource.setUsername(environment.getProperty("datajpa.source.username"));
        dataSource.setPassword(environment.getProperty("datajpa.source.password"));
        return dataSource;
    }

//    @Bean
//    @Description(value = "生成datasource第二种写法")
//    @ConfigurationProperties(prefix = "datajpa.source")
//    public DataSource source() {
//        return new DriverManagerDataSource();
//    }

}