package project.model.da;


import project.model.entity.Person;
import project.model.utils.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonDa implements AutoCloseable {
    private Connection connection;
    private PreparedStatement statement;

    public void save(Person person) throws SQLException {
        person.setId(Jdbc.getJdbc().getNextId("person_seq"));
        connection = Jdbc.getJdbc().getConnection();
    }

//    edit.remove.findById.findAll ... other


    @Override
    public void close() throws Exception {
        statement.close();
        connection.close();
    }
}
