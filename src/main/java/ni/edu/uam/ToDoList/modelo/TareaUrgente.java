package ni.edu.uam.ToDoList.modelo;

import lombok.*;
import org.openxava.annotations.View;
import org.openxava.annotations.Views;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalTime;

@Entity
@Getter @Setter
@Table(name="tareas_urgentes")
@Views({
        @View(members=
                "titulo, descripcion, prioridad, estado, fechaVencimiento, etiquetas; " +
                        "horaLimite, razonUrgencia"
        )
})
public class TareaUrgente extends Tarea {

    @Column(name="hora_limite")
    private LocalTime horaLimite;

    @Column(length = 255)
    @Size(min = 3, max = 255)
    private String razonUrgencia;
}