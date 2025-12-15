package ni.edu.uam.ToDoList.modelo;

import lombok.*;
import org.openxava.annotations.View;
import org.openxava.annotations.Views;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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

    public String getHoraLimiteAsString() {
        if (horaLimite == null) return "";
        return horaLimite.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    @Column(length = 255)
    @Size(min = 3, max = 255)
    private String razonUrgencia;
}