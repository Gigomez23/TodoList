package ni.edu.uam.ToDoList.modelo;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Required;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Reporte {
    @Id
    @Column(length = 50) @Required
    private String descripcion;      // <-- $F{descripcion}

    @Required
    private LocalDate fecha;         // <-- $F{fecha}

    @Required
    private BigDecimal cantidad;     // <-- $F{cantidad}
    public Reporte(String descripcion, LocalDate fecha, BigDecimal cantidad) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public Reporte() { }
}
