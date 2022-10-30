package com.company.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Getter
@Setter
public class TextFiles extends BaseEntity{
    Date datetime;
    String Eng;
    String Rus;
    Integer intNumber;
    Double doubleNumber;

}
