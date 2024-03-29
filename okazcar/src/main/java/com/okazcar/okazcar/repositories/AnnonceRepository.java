package com.okazcar.okazcar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.okazcar.okazcar.models.Annonce;


@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {

    Annonce findAnnonceById(int id);

}
