import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * 这是Mock + junit5 写单元测试的例子
 */
public class MockTest {


    /**
     * Mockito 会追踪 Mock 对象的所用方法调用和调用方法时所传递的参数
     *  add(3) 方法调用3次
     *
     */
    @Test
    public void testMock() {
        List list = mock(List.class);//静态方法mock mock一个list
        when(list.size()).thenReturn(1);
        Assertions.assertTrue(list.size()==1);
        when(list.add(1)).thenReturn(true);
        list.add(1);
        verify(list, atLeastOnce()).add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        verify(list).add(2);
        verify(list, times(3)).add(3);// add(3) 方法调用3次
    }


    /**
     * spy部分模拟对象
     * spy包装对象，如果没有定制spy的方法，则调用的是原来对象的方法
     *
     */
    @Test
    public void testSpy() {
        LinkedList<Object> objects = new LinkedList<>();
        List spy = spy(objects);
        spy.add("one");
        spy.add("two");
        spy.add("three");
        Assertions.assertTrue(spy.size()==3);
        Assertions.assertTrue(objects.size()==3);
        Assertions.assertTrue(spy.get(0)=="one");
        Assertions.assertTrue(objects.get(0) == "one");

        when(spy.size()).thenReturn(10);//定制来spy.size ，所以用的是定制的方法
        Assertions.assertTrue(spy.size()==10);
    }

    /**
     * Mockito 允准我们捕获一个 Mock 对象的方法调用所传递的参数,
     * 我们通过 verify(mockedList).addAll(argument.capture()) 语句来获取 mockedList.addAll 方法所传递的实参 list.
     */
    @Test
    public void testCaptureArgument() {
        List list = Arrays.asList(1, 2);
        List mockList = mock(List.class);
        ArgumentCaptor<List> argumentCaptor = ArgumentCaptor.forClass(List.class);
        mockList.addAll(list);
        verify(mockList).addAll(argumentCaptor.capture());
        Assertions.assertTrue(2==argumentCaptor.getValue().size());
        Assertions.assertTrue(list == argumentCaptor.getValue());

    }

}
