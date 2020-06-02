package com.hcw.learn.mybatis;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

import com.hcw.learn.jdbc.DbUtil;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TransactionTest {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());


    @Before
    public void before() throws FileNotFoundException {
        
    }

    /**
     * select @@tx_isolation;
     * set global transaction isolation level read committed; 
     * 修改后，事务之间没有隔离性，数据不一致
     * set global transaction isolation level Repeatable Read; 
     * 隔离级别：可重复读 REPEATABLE-READ ps：mysql默认隔离级别
     * 事务之间是隔离的。另一个事务修改，对正在查询的事务不可见。
     * 
     * @throws SQLException
     * @throws InterruptedException
     */
    @Test
    public void testRepeatAbleRead() throws SQLException, InterruptedException {
        Connection  conn  = DbUtil.openConnection();
        conn.setAutoCommit(false);
        ResultSet resultSet = DbUtil.query(conn, "select * from t_course where course_id=2");

        while(resultSet.next()){
            String orginCover = resultSet.getString("cover");
            LOG.info("first query result:"+orginCover+"*************");
            break;
        }

        CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(new Runnable(){
        
            @Override
            public void run() {
                try {
                    Connection conn = DbUtil.openConnection();
                    conn.setAutoCommit(true);
                    int updateResult = DbUtil.update(conn, "update t_course set  cover='hello world"+UUID.randomUUID()+"' where course_id=2");
                    LOG.info("update sql execute result:"+updateResult+"*************");
                    countDownLatch.countDown();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
            }
        }).start();

        countDownLatch.await();
        ResultSet resuletSet2 = DbUtil.query(conn, "select * from t_course where course_id=2");
        while(resuletSet2.next()){
            LOG.info("second query result:"+resuletSet2.getString("cover")+"*************");
        }
        conn.commit();
    }
    
}