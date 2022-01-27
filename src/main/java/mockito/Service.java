package mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Service implements UserService
{
    @Override
    public List<User> findUser(){
        return Arrays.asList(new User("John",56),new User("Wick",77));
    }

    public int cicuska(int num){
        return 22;
    }
}
