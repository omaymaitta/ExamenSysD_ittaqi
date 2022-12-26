package com.example.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategorieRequestDTO {
    private String nom;
    private String prenom;
    private Date ddn;
    private String email;
    private String numTel;
}
