package com.example.carauthorization.model.dtos;

import lombok.Data;

@Data
public class GroupDto {
    private int groupId;
    private String groupName;
    private String groupDescription;
    private String companyName;

}
