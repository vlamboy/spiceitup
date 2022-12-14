package de.spiceitup.service;

import de.spiceitup.persistence.GewuerzEntity;
import de.spiceitup.persistence.GewuerzRepository;
import de.spiceitup.web.api.Gewuerz;
import de.spiceitup.web.api.GewuerzManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GewuerzService {

    private final GewuerzRepository gewuerzRepository;

    public GewuerzService(GewuerzRepository gewuerzRepository) {
        this.gewuerzRepository = gewuerzRepository;
    }

    public List<Gewuerz> findAll(){
        List<GewuerzEntity> gewuerze = gewuerzRepository.findAll();
        return gewuerze.stream()
                .map(GewuerzEntity -> new Gewuerz(
                        GewuerzEntity.getId(),
                        GewuerzEntity.getName(),
                        GewuerzEntity.isVorraetig(),
                        GewuerzEntity.getMenge()
                )).collect(Collectors.toList());
    }

    public Gewuerz findById(Long id){
        var gewuerzEntity = gewuerzRepository.findById(id);
        return gewuerzEntity.isPresent()?
                new Gewuerz(
                gewuerzEntity.get().getId(),
                gewuerzEntity.get().getName(),
                gewuerzEntity.get().isVorraetig(),
                gewuerzEntity.get().getMenge()
                ) :
                null;
    }

    public Gewuerz create(GewuerzManipulationRequest request){
        var gewuerzEntity = new GewuerzEntity (request.getName(), request.isVorraetig(), request.getMenge());
        gewuerzEntity = gewuerzRepository.save(gewuerzEntity);
        return new Gewuerz(
                gewuerzEntity.getId(),
                gewuerzEntity.getName(),
                gewuerzEntity.isVorraetig(),
                gewuerzEntity.getMenge()
        );
    }

    public Gewuerz update(Long id, GewuerzManipulationRequest request){
        var gewuerzEntityOptional = gewuerzRepository.findById(id);
        if (gewuerzEntityOptional.isEmpty()){
            return null;
        } else {
            var gewuerzEntity = gewuerzEntityOptional.get();
            gewuerzEntity.setName(request.getName());
            gewuerzEntity.setVorraetig(request.isVorraetig());
            gewuerzEntity.setMenge(request.getMenge());
            gewuerzRepository.save(gewuerzEntity); //hier gibt es schon eine ID, daher scheint hier nur ein Update gemacht zu werden
            return new Gewuerz(
                    gewuerzEntity.getId(),
                    gewuerzEntity.getName(),
                    gewuerzEntity.isVorraetig(),
                    gewuerzEntity.getMenge()
            );
        }
    }

    public Gewuerz updateMenge(Long id, GewuerzManipulationRequest request){
        var gewuerzEntityOptional = gewuerzRepository.findById(id);
        if (gewuerzEntityOptional.isEmpty()){
            return null;
        } else {
            var gewuerzEntity = gewuerzEntityOptional.get();
            gewuerzEntity.setName(request.getName());
            gewuerzEntity.setVorraetig(request.isVorraetig());
            gewuerzEntity.setMenge(request.getMenge());
            gewuerzRepository.save(gewuerzEntity); //hier gibt es schon eine ID, daher scheint hier nur ein Update gemacht zu werden
            return new Gewuerz(
                    gewuerzEntity.getId(),
                    gewuerzEntity.getName(),
                    gewuerzEntity.isVorraetig(),
                    gewuerzEntity.getMenge()
            );
        }
    }

    public boolean deleteById(Long id){
        if (!gewuerzRepository.existsById(id)) {
            return false;
        }
        else {
            gewuerzRepository.deleteById(id);
            return true;
        }
    }
}
