package Service;

import Dao.DaoImpl;
import Dao.DaoLayer;
import Utils.Profile;

public class ServiceImpl implements Service {

    @Override
    public void addProfile(Profile profile){

        DaoLayer daoLayer = new DaoImpl();
        daoLayer.profileSave(profile);
    }

    public void deleteProfile(int id){

        DaoLayer daoLayer = new DaoImpl();
        daoLayer.deleteProfile(id);
    }

    public Profile viewProfile(int id){

        DaoLayer daoLayer = new DaoImpl();
        Profile profile = daoLayer.viewProfile(id);
        return profile;
    }

    public String deposit(int amount, int id){

        DaoLayer daoLayer = new DaoImpl();
        String message= daoLayer.deposit(amount, id);
        return message;
    }

    public String withdrawal(int amount, int id){

        DaoLayer daoLayer = new DaoImpl();
        String message= daoLayer.withdrawal(amount, id);
        return message;
    }

}
