package com.hcw.framework.redis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;
import com.hcw.framework.redis.core.KVRedisTemplate;
import com.hcw.framework.redis.core.ListRedisTemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisStringCommands.BitOperation;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {


    @Autowired
    private KVRedisTemplate kvRedisTemplate;
    @Autowired
    private ListRedisTemplate listRedisTemplate;
    /**
     * 使用时间作为cacheKey，然后用户ID为offset，如果当日活跃过就设置为1
     * 那么我该如果计算某几天/月/年的活跃用户呢(暂且约定，统计时间内只有有一天在线就称为活跃)，
     * 有请下一个redis的命令 命令 BITOP  destkey key [key ...]
     * 查询某一天的日活 bitcount
     * 
     */
    @Test
    public void queryActiveClientList() {

        final var data = Map.of("{date}2020-01-01", List.of(40040072, 40040071, 40040076, 40040075), "{date}2020-01-02", List.of(40040032, 40040072, 40040073, 50043032, 30040032), "{date}2020-01-03",
                List.of(29340022, 30040072,40040072));

        // 批量设置活跃状态
        data.entrySet().forEach(v -> {
            final var date = v.getKey();
            final var custIdList = v.getValue();
            custIdList.forEach(id -> kvRedisTemplate.setBit(date, id, true));
        });

        data.entrySet().stream().forEach(v->{
            final var date = v.getKey();
            final var custIdList = v.getValue();
            custIdList.forEach(id->System.out.println(date+"_"+id+"_"+kvRedisTemplate.getBit(date, id)+"\n"));
        });

        //活跃用户总数
        final Long activeClientCount = data.entrySet().stream().mapToLong(v -> {
            final var date = v.getKey();
            long count = kvRedisTemplate.bitCount(date);
            System.out.println(date.concat("-").concat(""+count));
            return count;
        }).sum();

        System.out.println("总登录用户："+activeClientCount);


        // 查询某几天活跃用户2020-01-01，2020-01-2，2020-01-03三天都登录的
        kvRedisTemplate.bitOp(BitOperation.AND, "{date}total", "{date}2020-01-01","{date}2020-01-02","{date}2020-01-03");

        System.out.println("2020-01-01，2020-01-2，2020-01-03三天内总活跃用户："+kvRedisTemplate.bitCount("{date}total"));


    }




    @Test
    public void kvTest() {
        Map<String, String> result = new HashMap<>(16);

        // kv test
        String kvKey = "kvKey";
        String kvVal = UUID.randomUUID().toString();
        kvRedisTemplate.setValue(kvKey, kvVal);
        String kvRes = new String(kvRedisTemplate.getValue(kvKey));
        result.put("kv get set", kvRes + "==>" + kvVal.equals(kvRes));


        // kv getSet

        // 如果原始数据存在时
        String kvOldRes = new String(kvRedisTemplate.setAndGetOldValue(kvKey, kvVal + "==>new"));
        result.put("kv setAndGet", kvOldRes + " # " + new String(kvRedisTemplate.getValue(kvKey)));

        // 如果原始数据不存在时
        byte[] kvOldResNull = kvRedisTemplate.setAndGetOldValue("not exists", "...");
        result.put("kv setAndGet not exists", kvOldResNull == null ? "null" : new String(kvOldResNull));


        // 自增
        String cntKey = "kvIncrKey";
        long val = 10L;
        long incrRet = kvRedisTemplate.incr(cntKey, val);
        String incrRes = new String(kvRedisTemplate.getValue(cntKey));
        result.put("kv incr", incrRet + "#" + incrRes);


        // bitmap 测试
        String bitMapKey = "bitmapKey";
        kvRedisTemplate.setBit(bitMapKey, 100, true);
        boolean bitRes = kvRedisTemplate.getBit(bitMapKey, 100);
        boolean bitRes2 = kvRedisTemplate.getBit(bitMapKey, 101);
        result.put("bitMap", bitRes + ">> true | " + bitRes2 + ">> false");
        System.out.println(JSONObject.toJSONString(result));
    }


  

    @Test
    public void showList() {
        Map<String, String> result = new HashMap<>(16);
        String key = "listKey";
        // 删除之前的缓存，避免影响测试数据
        listRedisTemplate.delete(key);

        // 新增一个数据
        listRedisTemplate.lpush(key, "hello");

        // 获取列表中的所有值
        List<String> redisVal = listRedisTemplate.range(key, 0, -1);
        result.put("list", redisVal.toString());


        String indexVal = listRedisTemplate.index(key, 0);
        result.put("index", indexVal + " == hello");


        listRedisTemplate.lpush(key, "12");
        listRedisTemplate.lpush(key, "23");
        listRedisTemplate.lpush(key, "45");
        listRedisTemplate.lpush(key, "67");
        listRedisTemplate.trim(key, 0, 3);
        redisVal = listRedisTemplate.range(key, 0, -1);
        result.put("trim", redisVal.toString());


        String pop = listRedisTemplate.lpop(key);
        result.put("pop", pop + " == 67");
        result.put("size", listRedisTemplate.size(key) + "==3");


        listRedisTemplate.set(key, 0, "aaa");
        result.put("afterSet", listRedisTemplate.index(key, 0) + "==aaa");
        System.out.println(JSONObject.toJSONString(result));
    }
}