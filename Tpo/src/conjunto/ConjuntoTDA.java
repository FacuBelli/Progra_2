package conjunto;

// Interfaz para definir los métodos para un Conjunto
public interface ConjuntoTDA {
    // Método para inicializar el conjunto
    void InicializarConjunto();
    
    // Método para agregar un elemento x al conjunto
    void Agregar(int x);
    
    // Método que devuelve un elemento cualquiera del conjunto
    int Elegir();
    
    // Método que verifica si el conjunto está vacío
    boolean ConjuntoVacio();
    
    // Método para eliminar un elemento x del conjunto
    void Sacar(int x);
    
    // Método que verifica si un elemento x pertenece al conjunto
    boolean Pertenece(int x);
}
