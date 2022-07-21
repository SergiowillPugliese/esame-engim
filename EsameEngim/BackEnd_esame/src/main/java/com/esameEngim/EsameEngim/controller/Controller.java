package com.esameEngim.EsameEngim.controller;

import com.esameEngim.EsameEngim.model.Articolo;
import com.esameEngim.EsameEngim.model.Ordine;
import com.esameEngim.EsameEngim.model.Repository.ArticoloRepository;
import com.esameEngim.EsameEngim.model.Repository.OrdineRepository;
import com.esameEngim.EsameEngim.model.Repository.TariffaCorriereRepository;
import com.esameEngim.EsameEngim.model.Repository.VoceRepository;
import com.esameEngim.EsameEngim.model.TariffaCorriere;
import com.esameEngim.EsameEngim.model.Voce;
import com.esameEngim.EsameEngim.payload.TariffaCorrierePayload;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/spedizionearticoli")
@CrossOrigin("*")
public class Controller {

    //restituisco la lista degli articoli
    @GetMapping("/articolo")
    public List<Articolo> articolo() {
        return ArticoloRepository.getArticoli();
    }

    //restituisco la lista degli ordini
    @GetMapping("ordini")
    public List<Ordine> ordine() {
        return OrdineRepository.getOrdini();
    }

    @GetMapping("tariffe_corriere")
    public List<TariffaCorriere> tariffa() {
        return TariffaCorriereRepository.getTariffe();
    }

    @GetMapping("voce")
    public List<Voce> voce() {
        return VoceRepository.getVoce();
    }




    @GetMapping("/Preventivo")
    public static ArrayList<TariffaCorrierePayload> getTariffaMigliore() {
        ArrayList ordiniConPreventivo = new ArrayList();
        ArrayList<Ordine> ordini = OrdineRepository.getOrdini();

        for (Ordine ordine: ordini) {
            TariffaCorriere migliorPreventivo = getMigliorPreventivo(ordine);

            TariffaCorrierePayload tariffaCorrierePayload = new TariffaCorrierePayload(
                    ordine.getId(),
                    ordine.getNumero(),
                    ordine.getData(),
                    migliorPreventivo);

            ordiniConPreventivo.add(tariffaCorrierePayload);
        }
        return  ordiniConPreventivo;
    }









    public static TariffaCorriere getMigliorPreventivo(Ordine ordine) {
        ArrayList<Articolo> articoliOrdine = ArticoloRepository.getArticoliPerOrdine(ordine.getId());
        double totalePesoOrdine = sommaPeso (articoliOrdine);
        return migliorTariffaPerOrdine(totalePesoOrdine);
    }



    public static double sommaPeso(ArrayList<Articolo> articoli) {
        double sommaArticoli = 0;
        for (Articolo pesoArticolo: articoli) {
            sommaArticoli = sommaArticoli + pesoArticolo.getPeso();
        }
        return sommaArticoli;
    }



    public static TariffaCorriere migliorTariffaPerOrdine(double pesoTotaleOrdine) {

        ArrayList<TariffaCorriere> tariffe = TariffaCorriereRepository.getTariffe();
        ArrayList<TariffaCorriere> tariffeValide = new ArrayList<>();

        //mi recupero le tariffe
        for (TariffaCorriere tariffaCorriere: tariffe) {
            if(pesoTotaleOrdine < tariffaCorriere.getPesoMassimo()){
                tariffeValide.add(tariffaCorriere);
            }
        }
        //verifico la più valida
        TariffaCorriere migliorTariffa = tariffeValide.get(0);
        for (TariffaCorriere rate: tariffeValide) {
            if(migliorTariffa.getCosto() > rate.getCosto() ) {
                migliorTariffa = rate;
            }
        }
        return migliorTariffa;
    }



}
