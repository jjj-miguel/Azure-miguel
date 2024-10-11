package com.atvdeploy.demo.model;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Entity
@Table(name = "[user]")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
   
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}