package colas;

// Interfaz para definir los métodos para una Cola con Prioridad
public interface ColaTDA {
    // Método para inicializar la cola
    void InicializarCola();
    
    // Método para agregar un elemento x a la cola con una prioridad específica
    void AcolarPrioridad(int x, int prioridad);
    
    // Método para eliminar el elemento con la mayor prioridad
    void Desacolar();
    
    // Método que verifica si la cola está vacía
    boolean ColaVacia();
    
    // Método que devuelve el primer elemento en la cola (con la mayor prioridad)
    int Primero();
    
    // Método que devuelve la prioridad del primer elemento en la cola
    int Prioridad();
}
