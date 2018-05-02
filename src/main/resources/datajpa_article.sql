DROP TABLE IF EXISTS datajpa_article;
CREATE TABLE datajpa_article (
  id    INT(10) AUTO_INCREMENT,
  title VARCHAR(10) NOT NULL,
  PRIMARY KEY (id)
);
INSERT INTO datajpa_article (title) VALUES ("我是第一条测试数据");