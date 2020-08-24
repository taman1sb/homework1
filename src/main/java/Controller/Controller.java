package Controller;

import Service.Service;
import Service.ServiceImpl;
import Utils.Profile;

public class Controller {

    public void addProfile(Profile profile) {

        Service service = new ServiceImpl();
        service.addProfile(profile);

    }

    public void deleteProfile (int id) {

        Service service = new ServiceImpl();
        service.deleteProfile(id);

    }

    public Profile  viewProfile (int id) {

        Service service = new ServiceImpl();
       Profile profile= service.viewProfile(id);
       return profile;

    }

    public String  deposit (int amount, int id) {

        Service service = new ServiceImpl();
        String message= service.deposit(amount,id);
        return message ;

    }

    public String  withdrawal(int amount, int id) {

        Service service = new ServiceImpl();
        String message= service.withdrawal(amount,id);
        return message ;

    }

}
