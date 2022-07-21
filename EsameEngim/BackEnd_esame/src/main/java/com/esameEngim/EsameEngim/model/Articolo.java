package com.esameEngim.EsameEngim.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Articolo {
    private Integer id;
    private String codice;
    private String descrizione;
    private Double peso;
}
