package com.hcw.learn.jdk;

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
        List<User> userList = List.of();
        Map<Integer, Integer> collect = userList.stream().collect(Collectors.toMap(User::getI, User::getJ));

        //a.entrySet().stream().map(entry->{return new UserB(entry.getKey(),entry.getValue(),b.get(entry.getKey()));}).collect(Collectors.toMap(UserB::getId,user->user)).forEach((k,v)-> System.out.println(v.toString()));

    }


    @Test
    public void testListObjectToInt() {
        User user = new User();
        user.setI(1667);
        User user1 = new User();
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




    class User{
        int i;
        int j;

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
}
