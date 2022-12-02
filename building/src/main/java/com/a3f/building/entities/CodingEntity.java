package com.a3f.building.entities;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class CodingEntity {
    @Id 
    private String id;
    private String code;
    private String value; 
}
