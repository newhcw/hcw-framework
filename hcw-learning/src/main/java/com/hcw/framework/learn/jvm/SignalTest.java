package com.hcw.framework.learn.jvm;

import sun.misc.Signal;
import sun.misc.SignalHandler;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SignalTest {

    public static void main(String[] args) throws InterruptedException {
        Signal.handle(new Signal("INT"), new SignalHandler() {
            @Override
            public void handle(Signal signal) {
                System.out.println(signal.toString() + "   catched");
                execute();
            }
        });

        Signal.handle(new Signal("TERM"), new SignalHandler() {
            @Override
            public void handle(Signal signal) {
                System.out.println(signal.toString() + " catched");



            }
        });

        while (true) {
            Thread.sleep(1000L);
            System.out.println(123);
        }
    }

    public static void execute() {
        String[] cmds = {"/bin/sh", "-c", "ps -ef|grep java"};
        Process pro = null;
        try {
            pro = Runtime.getRuntime().exec(cmds);
            pro.waitFor();
            InputStream in = pro.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = read.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
