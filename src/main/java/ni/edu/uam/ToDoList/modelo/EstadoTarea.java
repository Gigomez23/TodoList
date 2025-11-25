package ni.edu.uam.ToDoList.modelo;

import lombok.Getter;

@Getter
public enum EstadoTarea {
    PENDIENTE(1, "Pendiente"),
    EN_PROGRESO(2, "En Progreso"),
    COMPLETADA(3, "Completada"),
    CANCELADA(4, "Cancelada");

    // Value to be stored in the database
    private final int codigo;
    // Human-readable description
    private final String descripcion;

    EstadoTarea(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
}