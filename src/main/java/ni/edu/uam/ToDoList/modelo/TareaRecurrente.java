package ni.edu.uam.ToDoList.modelo;

import lombok.*;
import org.openxava.annotations.View;
import org.openxava.annotations.Views;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Getter @Setter
@Table(name="tareas_recurrentes")
@Views({
        @View(members=
                "titulo, descripcion, prioridad, estado, fechaVencimiento, etiquetas; " +
                        "intervaloDias"
        )
})
public class TareaRecurrente extends Tarea {

    @Min(1)
    @Max(365)
    private int intervaloDias;
}