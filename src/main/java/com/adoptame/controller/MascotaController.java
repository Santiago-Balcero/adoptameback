package com.adoptame.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adoptame.model.Mascota;
import com.adoptame.services.MascotaService;


//Decorador para que esta clase procese las peticiones HTTP
@RestController
@RequestMapping("/adoptame/mascotas")
public class MascotaController {
    private MascotaService service;

    public MascotaController() {
        service = new MascotaService();
    }

    @GetMapping("/show/{username}")
    @CrossOrigin("*")
    public List<Mascota> getListaMascotas(@PathVariable(name="username") String username) {
        return service.getListaMascotas(username);
    }

    @GetMapping("/ciudades")
    @CrossOrigin("*")
    public List<Mascota> getCiudades() {
        return service.getCiudades();
    }

    @GetMapping("/razas")
    @CrossOrigin("*")
    public List<Mascota> getRazas() {
        return service.getRazas();
    }

    @GetMapping("/{idmascota}")
    @CrossOrigin("*")
    public Mascota getMascota(@PathVariable(name="idmascota") int idmascota) {
        return service.getMascota(idmascota);
    }

    @GetMapping("/username/{username}")
    @CrossOrigin("*")
    public List<Mascota> getMascotasUsuario(@PathVariable(name="username") String idcontacto) {
        return service.getMascotasUsuario(idcontacto);
    }

    @PostMapping
    @CrossOrigin("*")
    public String createMascota(@RequestBody Mascota mascota) {
        return service.createMascota(mascota);
    }

    @PutMapping
    @CrossOrigin("*")
    public String updateMascota(@RequestBody Mascota mascota) {
        return service.updateMascota(mascota);
    }

    @DeleteMapping("/{idmascota}")
    @CrossOrigin("*")
    public String deleteMascota(@PathVariable(name="idmascota")int idmascota) {
        return service.deleteMascota(idmascota);
    }

}
