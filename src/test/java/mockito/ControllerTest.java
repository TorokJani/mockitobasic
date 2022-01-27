package mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ControllerTest {

    @Test
    void testAnything() {
        Service service = new Service(){
            @Override
            public List<User> findUser() {
                return super.findUser();
            }
        };

        Controller controller = new Controller(service);
        List<User> elderlyUser=controller.getElderlyUser();
        assertEquals(1,elderlyUser.size());

    }

    @Test
    void testAnythingMockito() {
        Service service = Mockito.mock(Service.class);
        when(service.findUser()).thenReturn(Arrays.asList(new User("John",56),new User("Wick",77)));

        Controller controller = new Controller(service);
        List<User> elderlyUser=controller.getElderlyUser();
        assertEquals(1,elderlyUser.size());
        verify(service).findUser();

    }

    @Test
    void testAnythingMockito2() {
        Service service = Mockito.mock(Service.class);
        when(service.cicuska(27)).thenReturn(201);
        when(service.cicuska(anyInt())).thenReturn(22);

        assertEquals(22,service.cicuska(220));
        assertEquals(201,service.cicuska(27));


    }

    @Test
    void testAnythingMockito3() {
        Service service = Mockito.mock(Service.class);

        when(service.cicuska(anyInt())).thenReturn(22).thenReturn(201).thenReturn(20022).thenReturn(234);

        assertEquals(22,service.cicuska(220));
        assertEquals(201,service.cicuska(27));
        assertEquals(20022,service.cicuska(222));


    }

    @Test
    void testAnythingMockito4() {
        Service service = Mockito.mock(Service.class);

        when(service.cicuska(anyInt())).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class,() -> service.cicuska(-1));


    }


}