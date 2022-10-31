package com.company.model;

import lombok.*;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class TextFiles extends BaseEntity{
    private Date datetime;
    private String Eng;
    private String Rus;
    private Integer intNumber;
    private Double doubleNumber;

}
