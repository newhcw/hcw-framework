package com.hcw.learn.javagent;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * JVM启动前静态Instrument# 使用 javaagent 需要几个步骤： 定义一个 MANIFEST.MF 文件，必须包含
 * Premain-Class 选项，通常也会加入Can-Redefine-Classes 和 Can-Retransform-Classes 选项。
 * 创建一个Premain-Class 指定的类，类中包含 premain 方法，方法逻辑由用户自己确定。 将 premain 的类和 MANIFEST.MF
 * 文件打成 jar 包。 使用参数 -javaagent: jar包路径 启动要代理的方法。
 */
public class PreMainTraceAgent {

    public static void premain(final String agentArgs, final Instrumentation instrumentation) {
        System.out.println("premain agentArgs : " + agentArgs);


        ClassPool classPool = new ClassPool();
        classPool.appendSystemPath();
        classPool.insertClassPath(new ClassClassPath(PreMainTraceAgent.class));

        instrumentation.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(final ClassLoader loader, final String className,
                    final Class<?> classBeingRedefined, final ProtectionDomain protectionDomain,
                    final byte[] classfileBuffer) {
                //System.out.println("premain load Class:" + className);
                if (className.contains("com/hcw/learn/javagent/UserService")) {

                    try {
                        CtClass cc = classPool.get(className.replaceAll("/", "."));
                        CtMethod method = cc.getDeclaredMethod("startWork");
                        method.insertBefore("System.out.println(System.currentTimeMillis());");
                        return cc.toBytecode();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                   
                }
                return classfileBuffer;
            }
        });
    }

    

}