package cl.duoc.cristobalpardo.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Paciente {
    
    @NotNull(message = "El run no puede estar vacío.")
    private int numRun;

    @NotBlank(message = "El digito verfificador no puede estar vacío")
    private String dvRun;

    @NotBlank(message = "El paciente debe tener nombre.")
    private String nombre;

    @NotNull(message = "El paciente debe tener edad.")
    private int edad;

    @NotBlank(message = "El paciente debe tener ingresada una atención")
    private String tipoAtencion;

    @NotBlank(message = "La solicitud debe tener un estado")
    private String estado;

    @NotNull(message = "La solicitud debe tener fecha de registro.")
    private LocalDateTime fechaRegistro;
    
    @NotBlank(message = "La solicitud debe tener prioridad")
    private String nivelPrioridad;

}
