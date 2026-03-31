package cl.duoc.cristobalpardo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cl.duoc.cristobalpardo.model.Paciente;

@Repository
public class PacienteRepository {
    public List<Paciente> listaPaciente = new ArrayList<>();

    public Boolean buscarPorRun (int numRun, String dvRun){
        for (Paciente pacienteEncontrado: listaPaciente){
            if(pacienteEncontrado.getNumRun() == numRun && pacienteEncontrado.getDvRun().equals(dvRun)){
                return true;
            }
        }
        return false;
    }

    public Boolean buscarPorAtencion (int numAtencion){
        for (Paciente pacienteEncontrado: listaPaciente){
            if (pacienteEncontrado.getNumAtencion() == numAtencion) {
                return true;
            }
        }
        return false;
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
        Boolean val = buscarPorAtencion(nuevo.getNumAtencion());
        if (val == false){
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

    public void eliminarPaciente (Paciente eliminar){
        Boolean valRun = buscarPorRun(eliminar.getNumRun(),eliminar.getDvRun());
        Boolean valAten = buscarPorAtencion(eliminar.getNumAtencion());

        if (valRun == true && valAten == true){
            listaPaciente.remove(eliminar);
        }
    }

    public Paciente actualizarPaciente (Paciente act) {
        int idRun  = 0;
        String iddv = "";
        int idaten = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaPaciente.size(); i++) {
            if (listaPaciente.get(i).getNumRun() == act.getNumRun()
                 && listaPaciente.get(i).getDvRun().equals(act.getDvRun())
                 &&  listaPaciente.get(i).getNumAtencion() == act.getNumAtencion()) {

                idRun = act.getNumRun();
                iddv = act.getDvRun();
                idaten = act.getNumAtencion();
                idPosicion = i;
            }
        }

        Paciente pa1 = new Paciente();
        pa1.setNumRun(idRun);
        pa1.setDvRun(iddv);
        pa1.setNombre(act.getNombre());
        pa1.setEdad(act.getEdad());
        pa1.setNumAtencion(idaten);
        pa1.setTipoAtencion(act.getTipoAtencion());
        pa1.setEstado(act.getEstado());
        pa1.setFechaRegistro(act.getFechaRegistro());
        pa1.setNivelPrioridad(act.getNivelPrioridad());
        
        listaPaciente.set(idPosicion, pa1);
        return pa1;
    }
}