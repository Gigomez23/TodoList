package ni.edu.uam.ToDoList.modelo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.Required;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
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


}
