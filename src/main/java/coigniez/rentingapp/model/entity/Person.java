package coigniez.rentingapp.model.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @EqualsAndHashCode(of = "id")
public class Person {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private Date birthDate;
}
