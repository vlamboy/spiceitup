package de.spiceitup.web;

import de.spiceitup.service.GewuerzService;
import de.spiceitup.web.api.Gewuerz;
import de.spiceitup.web.api.GewuerzManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Controller
public class GewuerzRestController {

    private final GewuerzService gewuerzService;

    public GewuerzRestController(GewuerzService gewuerzService) {
        this.gewuerzService = gewuerzService;
    }

    @GetMapping(path = "/api/v1/gewuerze")
    ResponseEntity<List<Gewuerz>> fetchGewuerze(){
        return ResponseEntity.ok(gewuerzService.findAll()); //verweist direkt an den Service, der die Businesslogik enthält
    }

    @GetMapping(path = "/api/v1/gewuerze/{id}")
    ResponseEntity<Gewuerz> fetchGewuerzById(@PathVariable Long id){
        var gewuerz = gewuerzService.findById(id);
        return gewuerz != null? ResponseEntity.ok(gewuerz) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/gewuerze")
    ResponseEntity<Void> postGewuerz(@RequestBody GewuerzManipulationRequest request){
        var gewuerz = gewuerzService.create(request);
        return ResponseEntity.created(URI.create("/api/v1/gewuerze/" + gewuerz.getId())).build();
    }

    @PutMapping (path = "/api/v1/gewuerze/{id}")
    ResponseEntity<Gewuerz> updateGewuerz(@PathVariable Long id, @RequestBody GewuerzManipulationRequest request){
        var gewuerz = gewuerzService.update(id, request);
        return gewuerz != null? ResponseEntity.ok(gewuerz) : ResponseEntity.notFound().build();
    }

    @PatchMapping("/api/v1/gewuerze/{id}")
    public ResponseEntity<Gewuerz> updateGewuerzMenge(@PathVariable Long id, @RequestBody GewuerzManipulationRequest request) {
        var gewuerz = gewuerzService.updateMenge(id, request);
        return gewuerz != null? ResponseEntity.ok(gewuerz): ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/gewuerze/{id}")
    ResponseEntity<Void> deleteGewuerz(@PathVariable Long id){
        boolean success = gewuerzService.deleteById(id);
        return success? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
