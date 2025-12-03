package ni.edu.uam.ToDoList.modelo;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Required;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Reporte {
    @Column(length = 50) @Required
    String descripcion;

    LocalDate fecha;
    BigDecimal cantidad;
}
