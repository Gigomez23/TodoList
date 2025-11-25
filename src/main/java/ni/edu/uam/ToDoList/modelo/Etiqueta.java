package ni.edu.uam.ToDoList.modelo;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.ListProperties;
import org.openxava.annotations.ReadOnly;
import org.openxava.annotations.Required;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "etiquetas")
public class Etiqueta {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy="uuid2")
    @Hidden
    private String oid;

    @Column(name = "nombre_etiqueta", length = 60, nullable = false )
    @Required(message = "El nombre de la etiqueta no puede quedar vacio")
    @Size(min = 3, max = 60)
    private String nombre;

    @Column(name= "color_etiqueta",  length = 60, nullable = false )
    @Required(message = "El nombre del color no puede quedar vacio")
    @Size(min = 3, max = 60)
    private String color;

    @ManyToMany(mappedBy = "etiquetas")
    @ReadOnly
    @ListProperties("titulo, descripcion") // or "id, titulo" if you want an id column shown
    private List<Tarea> tareas;
}
