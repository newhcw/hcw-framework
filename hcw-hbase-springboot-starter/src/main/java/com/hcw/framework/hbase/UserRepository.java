package com.hcw.framework.hbase;

import java.util.List;

import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import com.spring4all.spring.boot.starter.hbase.api.RowMapper;
import com.spring4all.spring.boot.starter.hbase.api.TableCallback;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private HbaseTemplate hbaseTemplate;

    private String tableName = "users";

    public static byte[] CF_INFO = Bytes.toBytes("cfInfo");

    private byte[] qUser = Bytes.toBytes("user");
    private byte[] qEmail = Bytes.toBytes("email");
    private byte[] qPassword = Bytes.toBytes("password");

    public List<User> findAll() {
        return hbaseTemplate.find(tableName, "cfInfo", new RowMapper<User>() {
            @Override
            public User mapRow(Result result, int rowNum) throws Exception {
                return new User(Bytes.toString(result.getValue(CF_INFO, qUser)),
                        Bytes.toString(result.getValue(CF_INFO, qEmail)),
                        Bytes.toString(result.getValue(CF_INFO, qPassword)));
            }
        });

    }

    public User save(final String userName, final String email, final String password) {
        return hbaseTemplate.execute(tableName, new TableCallback<User>() {
            @Override
            public User doInTable(Table table) throws Throwable {
                User user = new User(userName, email, password);
                Put p = new Put(Bytes.toBytes(user.getName()));
                p.add(CF_INFO, qUser, Bytes.toBytes(user.getName()));
                p.add(CF_INFO, qEmail, Bytes.toBytes(user.getEmail()));
                p.add(CF_INFO, qPassword, Bytes.toBytes(user.getPassword()));
                table.put(p);
                return user;
            }
		});
	}

    
}