package com.example.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CreateClientRequestDTO {
    private String nom ;
    private String adresse ;
    private String mail;
    private String tele;
}