package com.esameEngim.EsameEngim.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TariffaCorriere {
    private Integer id;
    private String nome;
    private String nomeTariffa;
    private Double pesoMassimo;
    private Double costo;
}
