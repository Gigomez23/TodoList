package ni.edu.uam.ToDoList.modelo;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.DefaultValueCalculator;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.ListProperties;
import org.openxava.annotations.Required;
import org.openxava.calculators.CurrentLocalDateCalculator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

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

    @Column(name = "descripcion_tarea", length = 255, nullable = true)
    @Size(min = 3, max = 255)
    private String descripcion;

    @Column(name = "prioridad_tarea", nullable = false)
    @Required(message = "El titulo de la tarea no puede quedar vacio")
//    @Size(min = 3, max = 60)
    @Min(1)
    @Max(5)
    private int prioridad;

    @Enumerated(EnumType.STRING) // Maps enum name (e.g., "PENDIENTE") to VARCHAR column
    @Column(name = "estado_tarea", length = 30, nullable = false) // Increased length for String
    private EstadoTarea estado;

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
    @Column(name = "fecha_vencimiento_tarea", nullable = false)
    private LocalDate fechaVencimiento;

    @ManyToMany
    @JoinTable(
            name = "tarea_etiqueta",
            joinColumns = @JoinColumn(name = "tarea_oid", referencedColumnName = "oid"),
            inverseJoinColumns = @JoinColumn(name = "etiqueta_oid", referencedColumnName = "oid")
    )
    @ListProperties("nombre, color")
    private List<Etiqueta> etiquetas;
}
