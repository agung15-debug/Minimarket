package controller;
import java.sql.*;
import com.mysql.cj.jdbc.MysqlDataSource;

public class Connector {
    static Connection con;
    public static Connection connection(){
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("minimarket");
            data.setUser("root");
            data.setPassword("");
            try {
                con = data.getConnection();
                System.out.print("Koneksi Berhasil");
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.print("Koneksi Gagal");
            }
        return con;
    }

}
