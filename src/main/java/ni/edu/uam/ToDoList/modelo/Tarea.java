package ni.edu.uam.ToDoList.modelo;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.DateTime;
import org.openxava.annotations.Hidden;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name="tareas")
public class Tarea {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy="uuid2")
    @Hidden
    private String oid;

    private String titulo;

    private String descripcion;

    private int prioridad;

    private int estado;

    private DateTime fechaVencimiento;

}
