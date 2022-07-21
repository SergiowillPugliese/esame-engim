package com.esameEngim.EsameEngim.controller;

import com.esameEngim.EsameEngim.model.Articolo;
import com.esameEngim.EsameEngim.model.Ordine;
import com.esameEngim.EsameEngim.model.Repository.ArticoloRepository;
import com.esameEngim.EsameEngim.model.Repository.OrdineRepository;
import com.esameEngim.EsameEngim.model.Repository.TariffaCorriereRepository;
import com.esameEngim.EsameEngim.model.Repository.VoceRepository;
import com.esameEngim.EsameEngim.model.TariffaCorriere;
import com.esameEngim.EsameEngim.model.Voce;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
