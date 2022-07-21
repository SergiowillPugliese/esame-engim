package com.esameEngim.EsameEngim.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ordine {
    private Integer id;
    private Integer numero;
    private String data;
}
