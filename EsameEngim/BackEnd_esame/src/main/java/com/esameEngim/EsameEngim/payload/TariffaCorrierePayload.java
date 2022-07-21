package com.esameEngim.EsameEngim.payload;

import com.esameEngim.EsameEngim.model.TariffaCorriere;


public class TariffaCorrierePayload {

    private TariffaCorriere preventivoMigliore;
    private Integer id;
    private Integer numero;
    private String data;

    public TariffaCorrierePayload(int id, int numero, String data, TariffaCorriere preventivoMigliore) {
        this.id = id;
        this.numero = numero;
        this.data = data;
        this.preventivoMigliore = preventivoMigliore;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TariffaCorriere getPreventivoMigliore() {
        return preventivoMigliore;
    }

    public void setPreventivoMigliore(TariffaCorriere preventivo_migliore) {
        this.preventivoMigliore = preventivo_migliore;
    }
}
