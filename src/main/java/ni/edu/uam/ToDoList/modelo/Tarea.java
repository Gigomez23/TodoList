package ni.edu.uam.ToDoList.modelo;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentLocalDateCalculator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter
@Table(name="tareas")
public abstract class Tarea {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy="uuid2")
    @Hidden
    private String oid;

    @Column(length = 60, nullable = false)
    @Required
    @Size(min = 3, max = 60)
    private String titulo;

    @Column(length = 255)
    @Size(min = 3, max = 255)
    private String descripcion;

    @Required
    @Min(1)
    @Max(5)
    private int prioridad;

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private EstadoTarea estado;

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
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
