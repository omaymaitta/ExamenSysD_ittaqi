package com.example.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCategorieRequestDTO {
    private String id;
    private String nom;
    private String prenom;
    private Date ddn;
    private String email;
    private String numTel;
}
