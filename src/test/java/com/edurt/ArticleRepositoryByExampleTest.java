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
package com.edurt;

import com.edurt.model.DataJpaArticle;
import com.edurt.repository.DataJpaArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ArticleRepositoryByExampleTest <br/>
 * 描述 : ArticleRepositoryByExampleTest <br/>
 * 作者 : qianmoQ <br/>
 * 版本 : 1.0 <br/>
 * 创建时间 : 2018-05-03 下午11:53 <br/>
 * 联系作者 : <a href="mailTo:shichengoooo@163.com">qianmoQ</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleRepositoryByExampleTest {

    @Autowired
    private DataJpaArticleRepository repository;

    /**
     * 特点与约束(局限性):
     * 1. 支持动态查询(支持条件不固定的情况)
     * 2. 不支持过滤条件分组(不支持过滤条件分组or做数据连接查询, 只是一个简单的and连接)
     * 3. 仅支持字符串的查询(开始/结束/包含/正则表达式匹配)
     * 3. 支持其他类型的精确匹配
     */

    /**
     * Example查询条件表现方式
     * <p>
     * 第一部分是条件值 第二部分是查询方式
     * 查询值是使用实体对象来保存, 构建相对来说较为简单
     * 查询方式是使用ExampleMatcher来表示, 情况复杂的时候需要考虑以下几点:
     * 1. Null数据值的处理(使用Ignore忽略Null值的数据, 必须要添加到ignorePaths)
     * 2. 基本类型的数据处理(int, double)
     * 3. 忽略某些属性
     * 4. 不同的过滤方式
     * 5. 大小写匹配
     */

    @Test
    public void test1() {
        // 查询id为1的数据
//        repository.findOne(1);

        // 1. 创建查询数据的实体对象(将我们查询的所有条件注入到类中)
        DataJpaArticle article = new DataJpaArticle();
        article.setTitle("我是第一条测试数据");

        // 2. 创建查询匹配器, 需要使用的查询条件
        ExampleMatcher matcher = ExampleMatcher.matching() // 构建查询匹配器
                .withMatcher("title", ExampleMatcher.GenericPropertyMatchers.exact()); // 全字匹配title字段

        // 3. 构建查询实例
        Example<DataJpaArticle> example = Example.of(article, matcher);

        // 4. 开始执行查询
        System.out.println(repository.findOne(example));
    }

}