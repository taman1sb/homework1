package Dao;

import Utils.Profile;

public interface DaoLayer {

    public void profileSave(Profile profile);
    public void deleteProfile(int id);
    public Profile viewProfile(int id);
    public String deposit (int amount, int id);
    public String withdrawal (int amount, int id);

}
