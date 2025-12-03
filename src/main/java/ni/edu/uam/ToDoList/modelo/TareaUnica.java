package ni.edu.uam.ToDoList.modelo;

import lombok.*;
import org.openxava.annotations.View;
import org.openxava.annotations.Views;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter @Setter
@Table(name="tareas_unicas")
@Views({@View(members="titulo, descripcion, prioridad, estado, fechaVencimiento, etiquetas")
})
public class TareaUnica extends Tarea {


}