package com.hcw.learn.jdk;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LombdaTest {



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
