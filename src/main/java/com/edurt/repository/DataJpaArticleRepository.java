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
package com.edurt.repository;

import com.edurt.model.DataJpaArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * DataJpaArticleRepository <br/>
 * 描述 : DataJpaArticleRepository <br/>
 * 作者 : qianmoQ <br/>
 * 版本 : 1.0 <br/>
 * 创建时间 : 2018-05-03 上午12:09 <br/>
 * 联系作者 : <a href="mailTo:shichengoooo@163.com">qianmoQ</a>
 */
public interface DataJpaArticleRepository extends JpaRepository<DataJpaArticle, Integer> {

    /**
     * 生成SQL select * from datajpa_article where id = ?
     * <p>
     * datajpa 解析方法的时候, 首先把多余的前缀去掉,然后对剩下的部分解析(find, findBy, read, readBy, get, getBy)
     * <p>
     * 比如:
     * <p>
     * findById 解析步骤: findByIdLong
     * <p>
     * 1. 剔除findBy
     * 2. 判断Id(根据pojo规范,将首字母变为小写)
     * 3. 从右向左截取第一个大写字母开头的字符串(Id)
     * 4. 处理剩下的Id部分(先判断实体中是否包含id属性)
     * 5. 直接进行sql生成
     * <p>
     * 特殊情况: 字段中包含_   id_long  findById_Long  findById_long
     */
    DataJpaArticle findById(Integer id);

    // nativeQuery 用于标识是否使用本地SQL
    @Query(value = "SELECT id, title FROM datajpa_article WHERE id=?1",
            nativeQuery = true)
    DataJpaArticle queryById(Integer id);

    @Query(value = "SELECT id, title FROM datajpa_article WHERE id = :id",
            nativeQuery = true)
    DataJpaArticle queryById2(@Param(value = "id") Integer id);

    @Query(value = "select id, title from DataJpaArticle where id = ?1",
            nativeQuery = false)
    Object[] queryById3(Integer id);

}