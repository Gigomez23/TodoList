package ni.edu.uam.ToDoList.modelo;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.DateTime;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.Required;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalTime;

@Entity
@Getter @Setter
@Table(name="tareas")
public class Tarea {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy="uuid2")
    @Hidden
    private String oid;

    @Column(name = "titulo_tarea", length = 60, nullable = false)
    @Required(message = "El titulo de la tarea no puede quedar vacio")
    @Size(min = 3, max = 60)
    private String titulo;

    @Column(name = "descripcion_tarea", length = 60, nullable = true)
    @Size(min = 3, max = 60)
    private String descripcion;

    @Column(name = "prioridad_tarea", length = 60, nullable = false)
    @Required(message = "El titulo de la tarea no puede quedar vacio")
    @Size(min = 3, max = 60)
    private int prioridad;

    @Column(name = "estado_tarea", length=6, nullable = false)
    private int estado;


    private LocalTime fechaVencimiento;
}
