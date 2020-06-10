package com.hcw.framework.design.pattern.mediator;

/*
中介者模式：负责内部系统之间的调用关系的解藕，内部类之间的依赖转化为只对中介类
 */
public class ConcreteMediator implements Mediator {

    ConcreteColleague concreteColleague = new ConcreteColleague();
    ConcreteColleagueB concreteColleagueB = new ConcreteColleagueB();

    @Override
    public void run() {
        concreteColleagueB.setValue();
        concreteColleague.log();
    }

}
