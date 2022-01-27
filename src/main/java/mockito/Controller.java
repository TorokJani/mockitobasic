package mockito;

import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private Service servcie;

    public Controller(Service servcie) {
        this.servcie = servcie;
    }

    public Service getServcie() {
        return servcie;
    }

    public void setServcie(Service servcie) {
        this.servcie = servcie;
    }

    public List<User> getElderlyUser(){
        List<User> list = servcie.findUser().stream()
                .filter(x ->x.getAge() > 70)
                .collect(Collectors.toList());

        return list;
    }
}
