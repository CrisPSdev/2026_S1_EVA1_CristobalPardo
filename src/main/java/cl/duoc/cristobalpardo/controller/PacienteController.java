package cl.duoc.cristobalpardo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.cristobalpardo.model.Paciente;
import cl.duoc.cristobalpardo.service.PacienteService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    @Autowired 
    PacienteService pacienteService;
    
    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes(){
        List<Paciente> lista = pacienteService.retornarLista();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<Paciente> agregarPaciente(@Valid @RequestBody Paciente pas){
        Paciente nuevo = pacienteService.agregarPaciente(pas);
        if (nuevo != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        }
        else{
            return ResponseEntity.badRequest().body(nuevo);
        }
    }
    
    @DeleteMapping("/{numAtencion}/numAtencion")
    public ResponseEntity<String> eliminarAtencion(@Valid @PathVariable int numAtencion){
        String resultado = pacienteService.eliminarPaciente(numAtencion);
        if (resultado != null){
            return ResponseEntity.ok(resultado);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping                                                                                                              
    public ResponseEntity<Paciente> actualizar(@Valid @RequestBody Paciente paciente) {
        Paciente resultado = pacienteService.actualizarPaciente(paciente);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } 
        else{
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/{numAtencion}/numAtencion")
    public ResponseEntity<Paciente> buscarPorAtencion(@Valid @PathVariable int numAtencion) {
        Paciente resultado = pacienteService.buscarAten(numAtencion);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{numRun}/{dvRun}/numRun/dvRun")
    public ResponseEntity<List<Paciente>> buscarPorRun(@Valid @PathVariable int numRun, @Valid @PathVariable String dvRun) {
        List<Paciente> resultado = pacienteService.buscarRut(numRun, dvRun);
        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado);
    }


}