package springboot.model;

import java.time.LocalDateTime;

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
public class Rdv {
    private int id_appointment;
    private LocalDateTime appointment_request;
    private LocalDateTime appointment_date;
    private String description;
    private int id_client;
    private int id_place;
}