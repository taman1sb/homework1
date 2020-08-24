package Utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Utils {



    public static Connection connection() throws Exception{


        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql:// localhost:3306/vastika_bank", "root", "shanker@123");
        return con;

    }
}
