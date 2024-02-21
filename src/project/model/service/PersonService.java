package project.model.service;


import project.model.da.PersonDa;
import project.model.entity.Person;

public class PersonService {
    private static PersonService service = new PersonService();

    private PersonService() {
    }

    public static PersonService getService() {
        return service;
    }

    public void save(Person person) throws Exception {
        try (PersonDa personDa = new PersonDa()) {
            personDa.save(person);
        }
    }

    //    edit.remove.findById.findAll ... other

}

