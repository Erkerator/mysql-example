package com.example.mysqlexample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "guardian_name")),
        @AttributeOverride(name = "email", column = @Column(name = "guardian_email")),
        @AttributeOverride(name = "mobile", column = @Column(name = "guardian_mobile"))
})
public class Guardian {

    private String name;
    private String email;
    private String mobile;

}