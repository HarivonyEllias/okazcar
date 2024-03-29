package com.okazcar.okazcar.services;

import com.okazcar.okazcar.models.Voiture;
import com.okazcar.okazcar.models.VoitureVoitureImage;
import com.okazcar.okazcar.models.mongodb.VoitureImage;
import com.okazcar.okazcar.repositories.VoitureRepository;
import com.okazcar.okazcar.repositories.mongodb.VoitureImageRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoitureImageService {
    private final VoitureImageRepository voitureImageRepository;
    private final VoitureService voitureService;
    private final VoitureRepository voitureRepository;
    @Autowired
    public VoitureImageService(VoitureImageRepository voitureImageRepository, VoitureService voitureService, VoitureRepository voitureRepository) {
        this.voitureImageRepository = voitureImageRepository;
        this.voitureRepository = voitureRepository;
        this.voitureService=voitureService;
    }

    public VoitureVoitureImage insert(HttpServletRequest request) throws Exception {
        Voiture voiture = new Voiture(request);
        Voiture createdVoiture = voitureService.createVoiture(voiture);
        VoitureImage voitureImage = new VoitureImage(request, voiture);
        voitureImage = voitureImageRepository.save(voitureImage);
        return new VoitureVoitureImage(voitureImage, createdVoiture);
    }

    public List<VoitureVoitureImage> getAll() {
        List<VoitureVoitureImage> voitureVoitureImages = new ArrayList<>();
        List<Voiture> voitures=voitureService.getAllVoitures();
        for (Voiture voiture: voitures) {
            voitureVoitureImages.add(new VoitureVoitureImage(voitureImageRepository.findVoitureImageByVoitureId(voiture.getId()), voiture));
        }
        return voitureVoitureImages;
    }

    public VoitureVoitureImage getVoitureImageById(int voitureId) {
        return new VoitureVoitureImage(voitureImageRepository.findVoitureImageByVoitureId(voitureId), voitureRepository.findVoitureById(voitureId));
    }

    public VoitureVoitureImage update(HttpServletRequest request, int id) throws Exception {
        Voiture voiture = new Voiture(request);
        voiture.setId(id);
        Voiture voitureModifiee = voitureService.updateVoiture(id,voiture);
        VoitureImage voitureImage = new VoitureImage(request, voitureModifiee);
        voitureImage = voitureImageRepository.save(voitureImage);
        return new VoitureVoitureImage(voitureImage, voitureModifiee);
    }
}
