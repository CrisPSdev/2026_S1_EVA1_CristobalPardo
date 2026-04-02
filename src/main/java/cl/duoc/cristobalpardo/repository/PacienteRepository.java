package cl.duoc.cristobalpardo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cl.duoc.cristobalpardo.model.Paciente;

@Repository
public class PacienteRepository {
    public List<Paciente> listaPaciente = new ArrayList<>();

    public List<Paciente> buscarPorRun (int numRun, String dvRun){
        List<Paciente> listaResultado = new ArrayList<>();
        for (Paciente pacienteEncontrado: listaPaciente){
            if(pacienteEncontrado.getNumRun() == numRun && pacienteEncontrado.getDvRun().equals(dvRun)){
                listaResultado.add(pacienteEncontrado);
            }
        }
        return listaResultado;
    }

    public Paciente buscarPorAtencion (int numAtencion){
        for (Paciente pacienteEncontrado: listaPaciente){
            if (pacienteEncontrado.getNumAtencion() == numAtencion) {
                return pacienteEncontrado;
            }
        }
        return null;
    }

    public Boolean buscarPorTipoSolicitud (String tipoSolicitud){
        for (Paciente pacienteEncontrado: listaPaciente){
            if (pacienteEncontrado.getTipoAtencion().equals(tipoSolicitud)) {
                return true;
            }
        }
        return false;
    }

    public Paciente nuevaSolicitud (Paciente nuevo){
         
        Paciente val = buscarPorAtencion(nuevo.getNumAtencion());
        if (val == null){
            listaPaciente.add(nuevo);
            return nuevo;
        }
        else{
            return null;
        }
    }

    public List<Paciente> listaCompleta (){
        return listaPaciente;
    }

    public Boolean eliminarPaciente (int numAten){
        Paciente valAten = buscarPorAtencion(numAten);

        if (valAten != null){
            listaPaciente.remove(valAten);
            return true;
        }
        else{
            return false;
        }
    }

    public Paciente actualizarPaciente(Paciente act) {
        for (int i = 0; i < listaPaciente.size(); i++) {
            Paciente p = listaPaciente.get(i);
            if (p.getNumRun() == act.getNumRun() && p.getDvRun().equals(act.getDvRun())
                && p.getNumAtencion() == act.getNumAtencion()) {
            listaPaciente.set(i, act);
            return act;
            }
        }
        return null;
    }
}