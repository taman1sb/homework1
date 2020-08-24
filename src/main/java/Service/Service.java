package Service;

import Utils.Profile;

public interface Service {

    public void addProfile(Profile profile);

    public void deleteProfile(int id);

    public Profile viewProfile(int id);

    public String deposit(int amount, int id);

    public String withdrawal(int amount, int id);
}
