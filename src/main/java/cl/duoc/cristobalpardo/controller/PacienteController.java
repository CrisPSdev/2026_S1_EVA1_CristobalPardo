package cl.duoc.cristobalpardo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.cristobalpardo.model.Paciente;
import cl.duoc.cristobalpardo.service.PacienteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    @Autowired 
    PacienteService pacienteService;
    
    @GetMapping
    public List<Paciente> listarPacientes(){
        return pacienteService.retornarLista();
    }
    
    

}
