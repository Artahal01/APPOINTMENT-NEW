package springboot.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Client {
    private int id_client;
    private String name;
    private String phone_number;
    private String address;
    private String email;
    private String password;
}
