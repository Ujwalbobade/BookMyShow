package com.example.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter//lombok feature
//@NoArgsConstructor//no arg construtor
//@AllArgsConstructor//all arg construtor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    @CreatedDate
    Date CreatedAt;
    @LastModifiedDate
    Date LastModifaction;
}
//ORM
//OBJECT _REALTIONAL _MAPPING
//object relation to table
//phonepe -RBI-(yess bank,icic) is ORM
//         jpa(interface) - hibernate
//here hibernate is oRM which write queeries for you
//spring boot has internal ORM is called hiberante
//to imoplement in code we need to use annotation like @ENTITY

//pen  ball and gel pen