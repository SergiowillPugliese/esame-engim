package com.esameEngim.EsameEngim.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Voce {
    private Integer id;
    private Integer idOrdine;
    private Integer quantita;
    private Integer idArticolo;
}
