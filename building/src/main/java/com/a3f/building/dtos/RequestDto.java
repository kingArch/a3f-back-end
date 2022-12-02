package com.a3f.building.dtos;

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
public class RequestDto {
    private String id;
    private String initialDate;
    private String requestType;
    private String requestTitle;
    private String description;
    private String urgency;
    private String languagePref;
    private boolean canReceiveSMS;
    private String requesterGiven;
    private String requesterFamily;
    private String requesterEmail;
    private String requesterPhone;
    private String requesterLine;
    private String requesterCity;
    private String requesterState;
    private String requesterPostal;
}
