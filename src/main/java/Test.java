import Dao.DaoImpl;
import Service.Service;
import Service.ServiceImpl;
import Utils.Profile;

import java.util.Scanner;

public class Test {


    public static void main(String[] args) {

        int i =0;

        for (i=0;i<2;i++){

        System.out.println("Please enter your choice save/update/delete/view/deposit/withdrawal");
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        switch (input){

            case "save":
                Profile profile= new Profile();
                System.out.println("Enter Account name");
                profile.setAccount_name(scan.nextLine());
                System.out.println("Enter address");
                profile.setAddress(scan.nextLine());
                System.out.println("Enter Mobile");
                profile.setMobile(scan.nextLine());
                System.out.println("Enter ssn");
                profile.setSsn(scan.nextLine());
                Service service = new ServiceImpl();
                service.addProfile(profile);
                break;

            case "delete":
                System.out.println("Enter ssn");
                int id = scan.nextInt();
                Service service1 = new ServiceImpl();
                service1.deleteProfile(id);
                break;


            case "view" :
                System.out.println("Enter Id");
                int id1 = scan.nextInt();
                Service service2 = new ServiceImpl();
                Profile profile2 = service2.viewProfile(id1);
                System.out.println(profile2);
                break;

            case "deposit" :
                System.out.println("Enter account number");
                int id2 = scan.nextInt();
                System.out.println("Enter Amount to be deposited");
                int amount = scan.nextInt();
                Service service3 = new ServiceImpl();
                String message = service3.deposit(amount, id2);
                System.out.println(message);
                break;

            case "withdrawal" :
                System.out.println("Enter account number");
                int id3 = scan.nextInt();
                System.out.println("Enter Amount to be withdrawn");
                int amount1 = scan.nextInt();
                Service service4 = new ServiceImpl();
                String message1 = service4.withdrawal(amount1, id3);
                System.out.println(message1);
                break;
        }
            System.out.println("Please enter 0 to continue and 1 to exit");
        i = scan.nextInt();


    }}
}



