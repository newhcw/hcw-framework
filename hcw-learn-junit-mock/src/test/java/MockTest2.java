import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

/**
 * 注解版本
 */
@ExtendWith(MockitoExtension.class)
public class MockTest2 {

    @Mock
    List list;

    @Test
    void testMock() {
        when(list.size()).thenReturn(1);
        Assertions.assertTrue(list.size()==1);
    }








}
