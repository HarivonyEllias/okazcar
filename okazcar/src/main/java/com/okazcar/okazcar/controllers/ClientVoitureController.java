package com.okazcar.okazcar.controllers;

import java.util.List;

import com.okazcar.okazcar.models.VoitureUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.okazcar.okazcar.models.ClientVoiture;
import com.okazcar.okazcar.services.ClientVoitureService;

@RestController
public class ClientVoitureController {
    private final ClientVoitureService clientVoitureService;

    @Autowired
    public ClientVoitureController(ClientVoitureService clientVoitureService){
        this.clientVoitureService = clientVoitureService;
    }
    @GetMapping("/clientVoitures")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<ClientVoiture>> getAll(){
        List<ClientVoiture> clientVoitures=clientVoitureService.getAllClientVoiture();
        return new ResponseEntity<>(clientVoitures,HttpStatus.OK);
    }

    @PostMapping("/clientVoiture")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<?> create(@ModelAttribute ClientVoiture clientVoiture){
        try {
            ClientVoiture createdClientVoiture=clientVoitureService.createClientVoiture(clientVoiture);
            return new ResponseEntity<>(createdClientVoiture,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/ajouterFavori/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<?> updateFavori(@PathVariable("id") int id){
        try {
            return new ResponseEntity<>(clientVoitureService.updateClientVoiture(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }
}
