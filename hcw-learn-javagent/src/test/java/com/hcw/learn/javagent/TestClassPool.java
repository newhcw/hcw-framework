package com.hcw.learn.javagent;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import org.junit.Test;

import java.util.Iterator;

public class TestClassPool {

    @Test
    public void testClassPool() throws NotFoundException {

        new AppTest();

        ClassPool classPool = ClassPool.getDefault();
        classPool.importPackage("com.hcw.learn.javaagent");
       // classPool.appendSystemPath();
        classPool.insertClassPath(new ClassClassPath(this.getClass()));
        Iterator iterator = classPool.getImportedPackages();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        CtClass cc = classPool.get("com.hcw.learn.javagent.TestClassPool");
        classPool.get("com.hcw.learn.javagent.AppTest");
    }
}
