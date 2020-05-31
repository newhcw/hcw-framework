package com.hcw.learn.mybatis;

import java.io.FileNotFoundException;
import java.util.Map;

import com.hcw.learn.mybatis.entity.Course;

import org.apache.ibatis.executor.BatchExecutor;
import org.apache.ibatis.executor.CachingExecutor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.ReuseExecutor;
import org.apache.ibatis.executor.SimpleExecutor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootMybatisApplication.class })
public class ExecutorTest {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

 
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    Configuration configuration;
    JdbcTransaction jdbcTransaction;

    MappedStatement mappedStatement;

    @Before
    public void before() throws FileNotFoundException {
         configuration = sqlSessionFactory.getConfiguration();
         jdbcTransaction = new JdbcTransaction(sqlSessionFactory.openSession().getConnection());
         mappedStatement = configuration.getMappedStatement("com.hcw.learn.mybatis.mapper.CourseMapper.selectAll");
    }

    //简单执行器：每次都新建prepearment
    @Test
    public void testSimpleExecutor() throws Exception {
       
        
        
        SimpleExecutor simpleExecutor = new SimpleExecutor(configuration, jdbcTransaction);
        
        
        simpleExecutor.doQuery(mappedStatement, 1, RowBounds.DEFAULT, SimpleExecutor.NO_RESULT_HANDLER,mappedStatement.getBoundSql(1));
        simpleExecutor.doQuery(mappedStatement, 1, RowBounds.DEFAULT, SimpleExecutor.NO_RESULT_HANDLER,mappedStatement.getBoundSql(1));
       
    }

      //可重用执行器
      @Test
      public void testReuseExecutor() throws Exception {
          
          ReuseExecutor reuseExecutor = new ReuseExecutor(configuration, jdbcTransaction);
          
          reuseExecutor.doQuery(mappedStatement, 1, RowBounds.DEFAULT, ReuseExecutor.NO_RESULT_HANDLER,mappedStatement.getBoundSql(1));
          reuseExecutor.doQuery(mappedStatement, 1, RowBounds.DEFAULT, ReuseExecutor.NO_RESULT_HANDLER,mappedStatement.getBoundSql(1));
         
      }


      // 批处理执行器:
      // 只针对修改有用
      //必须手动提交批处理刷新
      @Test
      public void testBatchExecutor() throws Exception {
          
          BatchExecutor batchExecutor = new BatchExecutor(configuration, jdbcTransaction);
          mappedStatement = configuration.getMappedStatement("com.hcw.learn.mybatis.mapper.CourseMapper.update");

          Map map = Map.of("finished", (short)8, "courseId", 3l,"cover","batch update");

          batchExecutor.doUpdate(mappedStatement,map);
          batchExecutor.doUpdate(mappedStatement,map);

          batchExecutor.doFlushStatements(false);
      }


    //基础执行器BaseExecutor，会有一级缓层，子类有：simpleExecutor，BatchExcutor，ReuseExcutor  
    @Test
    public void testBaseExecutor() throws Exception {
        
        Executor executor = new SimpleExecutor(configuration, jdbcTransaction);
        executor.query(mappedStatement, 1, RowBounds.DEFAULT, Executor.NO_RESULT_HANDLER);
        executor.query(mappedStatement, 1, RowBounds.DEFAULT, Executor.NO_RESULT_HANDLER);
       
    }


    // 二级缓存执行器，cachingExecutor
    @Test
    public void testCachingExecutor() throws Exception {
        
        Executor executor = new SimpleExecutor(configuration, jdbcTransaction);
        CachingExecutor cachingExecutor = new CachingExecutor(executor);//二级缓存装饰

        
        cachingExecutor.query(mappedStatement, 1, RowBounds.DEFAULT, Executor.NO_RESULT_HANDLER);
        cachingExecutor.commit(true);//先走二级缓存，再走一级缓存
        cachingExecutor.query(mappedStatement, 1, RowBounds.DEFAULT, Executor.NO_RESULT_HANDLER);
        cachingExecutor.query(mappedStatement, 1, RowBounds.DEFAULT, Executor.NO_RESULT_HANDLER);
    }


    //sqlSession 门面模式提供访问jdbc的api
    @Test
    public void sqlSessionTest(){
        Course course =  sqlSessionFactory.openSession().selectOne("com.hcw.learn.mybatis.mapper.CourseMapper.getOne",2l);
        LOG.info("query {}",course);
    }

}