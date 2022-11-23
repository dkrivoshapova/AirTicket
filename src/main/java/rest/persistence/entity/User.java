package rest.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "loginAndPasword")
public class User {
    @Id
    private UUID id;
    private String email;
    private String password;
}
