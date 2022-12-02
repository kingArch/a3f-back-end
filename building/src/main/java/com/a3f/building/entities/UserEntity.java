package com.a3f.building.entities;

import org.springframework.data.annotation.Id;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class UserEntity {
    @Id private String id;
    
    @NonNull
    private String username;
    
    @NonNull
    private String password;
}
