package Dao;

import Utils.Utils;
import Utils.Profile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoImpl implements DaoLayer {

    @Override
    public void profileSave(Profile profile) {
        try {
            Connection con = Utils.connection();
            PreparedStatement preparedStatement = con.prepareStatement("insert into account_info (account_name, address, mobile, ssn) values(?,?,?,?)");

            preparedStatement.setString(1,profile.getAccount_name());
            preparedStatement.setString(2,profile.getAddress());
            preparedStatement.setString(3,profile.getMobile());
            preparedStatement.setString(4, profile.getSsn());

            preparedStatement.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void deleteProfile(int id) {
        try {
            Connection con = Utils.connection();
            PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM account_info WHERE id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public Profile viewProfile(int id) {
            Profile profile = null;
            try {
                Connection con = Utils.connection();
                PreparedStatement preparedStatement = con.prepareStatement("select * FROM account_info WHERE id=?");

                preparedStatement.setInt(1, id);
                profile = new Profile();
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {


                    profile.setAccount_name(rs.getString("account_name"));
                    profile.setAddress(rs.getString("address"));
                    profile.setMobile(rs.getString("mobile"));
                    profile.setSsn(rs.getString("ssn"));
                    profile.setAccountNumber(rs.getInt("id"));

                }


            } catch (Exception e) {
                e.printStackTrace();
            }
            return profile;

        }

    public String deposit (int amount, int id) {
        Profile profile = null;
        int finalBalance=0;
        String message="";
        try {
            Connection con = Utils.connection();
            PreparedStatement preparedStatement = con.prepareStatement("select * FROM account_balance_tbl WHERE account_number=?");

            preparedStatement.setInt(1, id);
            profile = new Profile();
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                int currentBalance= rs.getInt("total_balance");
                finalBalance = amount+currentBalance;
              //  System.out.println(finalBalance);
            }
           // System.out.println(finalBalance);
          message = updateBalance(finalBalance,id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return message ;

    }

    public String updateBalance(int amount, int id) {

        try {
            Connection con = Utils.connection();

            PreparedStatement preparedStatement = con.prepareStatement("UPDATE account_balance_tbl SET total_balance= ? WHERE account_number = ?");
            preparedStatement.setInt(1,amount);
            preparedStatement.setInt(2,id);

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "udated transaction successfully";

    }

    public String withdrawal (int amount, int id) {

        int finalBalance=0;
        String message="";
        try {
            Connection con = Utils.connection();
            PreparedStatement preparedStatement = con.prepareStatement("select * FROM account_balance_tbl WHERE account_number=?");

            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                int currentBalance= rs.getInt("total_balance");
                finalBalance = currentBalance-amount;
                 // System.out.println(finalBalance);
            }
            // System.out.println(finalBalance);

            if(finalBalance>0){
            message = updateBalance(finalBalance,id);}
            else {message = "Insufficient balance";}

        } catch (Exception e) {
            e.printStackTrace();
        }
        return message ;

    }





}
