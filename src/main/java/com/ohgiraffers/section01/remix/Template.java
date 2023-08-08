package com.ohgiraffers.section01.remix;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Template {

    private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String USER = "C##OHGIRAFFERS";
    private static String PASSWORD = "OHGIRAFFERS";

    private static SqlSessionFactory sqlSessionFactory;     // null 상태
    public static SqlSession getSqlSession() {

        if(sqlSessionFactory == null) {     // 첫 생성에만 if문이 작동하도록 한다.
            Environment environment = new Environment("dev",
                    new JdbcTransactionFactory(),
                    new PooledDataSource(DRIVER, URL, USER, PASSWORD));

            Configuration configuration = new Configuration(environment);

            configuration.addMapper(CategoryMapper.class); // MenuMapper의 클래스 정보를 전달한다.

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
            // 설정 정보를 전달하면서 빌드를 호출하면 sqlSessionFactory를 만든다.

            }

        SqlSession sqlSession = sqlSessionFactory.openSession(false);       // DB 연결

        return sqlSession;
    }
}
