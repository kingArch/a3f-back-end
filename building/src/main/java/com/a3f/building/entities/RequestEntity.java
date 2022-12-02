package com.a3f.building.entities;
import org.springframework.data.annotation.Id;

import com.a3f.building.models.Person;
import com.mongodb.lang.NonNull;

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
public class RequestEntity {
    @Id private String id;
    @NonNull
    private Person requester;
    @NonNull
    private String initialDate;
    @NonNull
    private String requestType;
    @NonNull
    private String requestTitle;
    @NonNull
    private String description;
    private String urgency;
    @NonNull
    private String languagePref;
    private boolean canReceiveSMS;
}