package project.model.utils;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc {
    private static final Jdbc jdbc = new Jdbc();
    private static final BasicDataSource basicDataSource = new BasicDataSource();

    private Jdbc() {
    }

    public static Jdbc getJdbc() {
        return jdbc;
    }

    public Connection getConnection() throws SQLException {
        basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        basicDataSource.setUsername("javase");
        basicDataSource.setPassword("java123");
        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxTotal(20);
        return basicDataSource.getConnection();
    }

    public int getNextId(String sequenceName) throws SQLException {
        Connection connection = getJdbc().getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT " + sequenceName + ".NEXTVAL AS NEXT FROM DUAL");
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return resultSet.getInt("NEXT");
    }
}
