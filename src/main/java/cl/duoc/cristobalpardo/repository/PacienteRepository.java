package cl.duoc.cristobalpardo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cl.duoc.cristobalpardo.model.Paciente;

@Repository
public class PacienteRepository {
    public List<Paciente> listaPaciente = new ArrayList<>();

}
