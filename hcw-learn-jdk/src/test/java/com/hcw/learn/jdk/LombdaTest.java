package com.hcw.learn.jdk;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class LombdaTest {


    class UserB{
        int id;
        int age;
        String name;

        public UserB(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "UserB{" +
                    "id=" + id +
                    ", age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    @Test
    public void testMap() {
        Map<Integer,Integer> a = Map.of(1,2,2,4,3,4,5,3);
        Map<Integer,String> b = Map.of(1, "llim",2,"ad",3,"sd",5,"3sd");
        Map<Integer, UserB> userMap = new HashMap<>();
//        a.keySet().stream().map(v->  {
//            userMap.put(v,new UserB(a.get(v),b.get(v)));
//            return userMap;
//        }).forEach(v->System.out.println(v.toString()));

//        Map<Integer, UserB> result = a.entrySet().stream()
//                .flatMap(entry -> b.entrySet().stream()
//                        .filter(v -> v.getKey().equals(entry.getKey()))
//                        .map(k -> new UserB(k.getKey(), entry.getValue(), k.getValue())))
//                .collect(Collectors.toMap(UserB::getId, en -> en));
//
//        result.entrySet().stream().forEach(v->System.out.println(v));
        List<User> userList = List.of(new User(1,1),new User(1,5));
        Map<Integer, List> collect = userList.stream().collect(Collectors.toMap(User::getI,
                e-> Lists.newArrayList(e),(List old, List news)->{
               old.addAll(news);
               return old;
        }));
        collect.entrySet().forEach(v-> System.out.println(v));

    }


    @Test
    public void testListObjectToInt() {
        User user = new User(1,2);
        user.setI(1667);
        User user1 = new User(1,2);
        user.setI(2);
        List<User> userList = List.of(user1,user);
        Optional<Integer> max = userList.stream().map(v -> v.getI()).max(Comparator.comparingInt(v -> v.intValue()));
        System.out.println(max.get());
        userList.removeIf(v->v.getI()!=max.get());
        System.out.println(userList);
    }

    @Test
    public void testOptional() {
        System.out.println((String)Optional.ofNullable(null).orElse(""));

    }


    @Test
    public void testnull() {
        List<Integer> lst = new ArrayList<>();
        Optional<Integer> first = lst.stream().filter(v -> v == 1).findFirst();
    }


    class User{
        int i;
        int j;
        User(int i,int j){
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List.of(1,2,3,4,5,6,7,8,10,2121).parallelStream().forEach(v->{

            System.out.println(Thread.currentThread().getName());
        });

        List.of(1,2,3,4,5,6,7,8,10).parallelStream().forEach(v->{
            System.out.println(Thread.currentThread().getName());
        });
        Thread.currentThread().sleep(1000*30);
    }
}
