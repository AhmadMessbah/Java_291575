package project.model.entity;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

public class Person{
    private int id;
    private String name;

    @Override
    public String toString() {
        // Comment
        return new Gson().toJson(this);
    }
}
