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
        Paciente val = pacienteRepository.nuevaSolicitud(nuevo);
        if (val != null){
            return val;
        }
        else{
            return null;
        }
    }
    
    public Boolean buscarRut (int run, String dvrun){
        Boolean val = pacienteRepository.buscarPorRun(run, dvrun);
        return val;
    }

    public Boolean buscarAten (int numAten){
        Boolean val = pacienteRepository.buscarPorAtencion(numAten);
        return val;
    }

    public Boolean buscarTipoSolicitud (String tipoSolicitud){
        Boolean val = pacienteRepository.buscarPorTipoSolicitud(tipoSolicitud);
        return val;
    }

    public List<Paciente> retornarLista (){
        return pacienteRepository.listaPaciente;
    }

    public String eliminarPaciente (Paciente eliminar){
        Boolean val = pacienteRepository.eliminarPaciente(eliminar);

        if (val){
            return "Solicitud eliminada";
        }
        else{
            return "Solicitud no encontrada";
        }
    }

    public void actualizarPaciente (Paciente act){
        pacienteRepository.actualizarPaciente(act);
    }
}
