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
package com.edurt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * DataJpaArticle <br/>
 * 描述 : DataJpaArticle <br/>
 * 作者 : qianmoQ <br/>
 * 版本 : 1.0 <br/>
 * 创建时间 : 2018-05-03 上午12:04 <br/>
 * 联系作者 : <a href="mailTo:shichengoooo@163.com">qianmoQ</a>
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
// 标记该类拥有数据库映射表
@Entity
// 映射到数据库中的数据表
@Table(name = "datajpa_article")
public class DataJpaArticle {

    // 唯一标识,类似于数据库中的primary key
    @Id
    // 标识数据的生成策略
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 标识数据库中对应的字段
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

}