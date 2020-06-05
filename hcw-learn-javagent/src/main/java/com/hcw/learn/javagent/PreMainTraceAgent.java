package com.hcw.learn.javagent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * JVM启动前静态Instrument# 使用 javaagent 需要几个步骤： 定义一个 MANIFEST.MF 文件，必须包含
 * Premain-Class 选项，通常也会加入Can-Redefine-Classes 和 Can-Retransform-Classes 选项。
 * 创建一个Premain-Class 指定的类，类中包含 premain 方法，方法逻辑由用户自己确定。 将 premain 的类和 MANIFEST.MF
 * 文件打成 jar 包。 使用参数 -javaagent: jar包路径 启动要代理的方法。
 */
public class PreMainTraceAgent {

    public static void premain(final String agentArgs, final Instrumentation inst) {
        System.out.println("premain agentArgs : " + agentArgs);
        inst.addTransformer(new DefineTransformer());
    }

    public static void agentmain(final String agentArgs, final Instrumentation instrumentation) {
        System.out.println("agentmain agentArgs : " + agentArgs);
        instrumentation.addTransformer(new DefineTransformer());
    }

    static class DefineTransformer implements ClassFileTransformer {

        @Override
        public byte[] transform(final ClassLoader loader, final String className, final Class<?> classBeingRedefined,
                final ProtectionDomain protectionDomain, final byte[] classfileBuffer)
                throws IllegalClassFormatException {
             System.out.println("premain load Class:" + loader.getName());
            ClassPool classPool = ClassPool.getDefault();
            classPool.appendSystemPath();

            if (className.contains("com/hcw/learn/javagent/AppTest")) {

                // classPool.appendClassPath(loader.getName())

                try {

                    // Class userClass = Class.forName(
                    // "com.hcw.learn.javagent.AppTest",
                    // true,
                    // ClassLoader.getSystemClassLoader());

                    final CtClass cc = classPool.get("com.hcw.learn.javagent.AppTest");
                    final CtMethod method = cc.getDeclaredMethod("startWork");
                    // CtMethod method = classPool.getMethod("com.hcw.learn.javagent.UserService",
                    // "startWork");
                    method.insertAfter("System.out.println(System.currentTimeMillis());");

                    final byte[] byteCode = cc.toBytecode();

                    return byteCode;
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            } else {
                return null;
            }

            return classfileBuffer;
        }
    }
}