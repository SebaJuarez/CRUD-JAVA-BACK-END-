package data;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/todolist?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    private static final String JDBC_USR = "root";
    private static final String JDBC_PASS = "admin";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Error");
            System.out.println(e.toString());
        }
    }

    public static DataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USR);
        ds.setPassword(JDBC_PASS);
        ds.setInitialSize(20);
        return ds;
    }
    
    public Connection getConexion() throws SQLException{
        return getDataSource().getConnection();
    }

    public void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public void close(Statement st) throws SQLException{
        st.close();
    }

    public void close(Connection cn) throws SQLException{
        cn.close();
    }

}
