package project.controller;

import lombok.extern.log4j.Log4j;
import project.model.entity.Person;
import project.model.service.PersonService;
import project.model.utils.Validator;

@Log4j
public class PersonController {
    private static PersonController controller = new PersonController();

    private PersonController() {
    }

    public static PersonController getController() {
        return controller;
    }


    public String save(String name) {
        try {
                Person person = Person
                        .builder()
                        .name(Validator.getValidator().nameValidator(name, "Name Is Invalid"))
                        .build();
                PersonService.getService().save(person);
            log.info("Person Saved " + person);
            return "Person Saved";
        } catch (Exception e) {
            log.error("Person Save Error : " + e.getMessage());
            return e.getMessage();
        }
    }
}
