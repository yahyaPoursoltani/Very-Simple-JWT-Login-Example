package edu.sharif.webclass.security.JWT.Prac.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EndUsers")
@Data
@NoArgsConstructor
public class EndUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String userName;
    private String password;
    private String role;
    public EndUser(String userName, String password, String role){
        this.role= role;
        this.userName= userName;
        this.password= password;
    }

}
