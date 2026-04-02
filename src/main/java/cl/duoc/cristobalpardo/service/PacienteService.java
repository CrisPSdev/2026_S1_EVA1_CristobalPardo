package cl.duoc.cristobalpardo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.cristobalpardo.model.Paciente;
import cl.duoc.cristobalpardo.repository.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente agregarPaciente(Paciente nuevo){
        return pacienteRepository.nuevaSolicitud(nuevo);
     }
    
    public List<Paciente> buscarRut (int run, String dvrun){
        return pacienteRepository.buscarPorRun(run, dvrun);
        
    }

    public Paciente buscarAten (int numAten){
        return pacienteRepository.buscarPorAtencion(numAten);
    }

    public Boolean buscarTipoSolicitud (String tipoSolicitud){
        return pacienteRepository.buscarPorTipoSolicitud(tipoSolicitud);
    }

    public List<Paciente> retornarLista (){
        return pacienteRepository.listaCompleta();
    }

    public String eliminarPaciente (int numAtencion){
        Boolean val = pacienteRepository.eliminarPaciente(numAtencion);

        if (val){
            return "Solicitud eliminada";
        }
        else{
            return null;
        }
    }

    public Paciente actualizarPaciente (Paciente act){
        return pacienteRepository.actualizarPaciente(act);
    }
}
