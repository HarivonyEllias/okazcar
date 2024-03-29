package com.okazcar.okazcar.repositories;

import com.okazcar.okazcar.models.V_Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface V_Annonce_Repository extends JpaRepository<V_Annonce, Integer> {
    List<V_Annonce> findV_AnnoncesByCategorieAndModeleAndTypeAndLocalisationAndCouleur(
            String categorie,
            String modele,
            String type,
            String localisation,
            String couleur
    );
    List<V_Annonce> findV_AnnoncesByStatus(int status);

    List<V_Annonce> findV_AnnoncesByStatusAndIdUtilisateur(int status, String idUtilisateur);

    long countV_AnnoncesByStatus(int status);
}
