package com.okazcar.okazcar.repositories;

import com.okazcar.okazcar.models.V_Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface V_Annonce_Repository extends JpaRepository<V_Annonce, Integer> {
}