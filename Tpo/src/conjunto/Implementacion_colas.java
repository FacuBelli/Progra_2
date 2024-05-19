package conjunto;

// Implementación de la interfaz ConjuntoTDA
public class Implementacion_colas implements ConjuntoTDA {
    int[] a; // Arreglo para almacenar los elementos del conjunto
    int cant; // Contador para llevar el control del número de elementos en el conjunto
    
    // Método para inicializar el conjunto
    public void InicializarConjunto() {
        a = new int[100]; // Inicializa el arreglo con un tamaño de 100
        cant = 0; // Inicializa el contador en 0
    }
    
    // Método para agregar un elemento x al conjunto
    public void Agregar(int x) {
        if (!this.Pertenece(x)) { // Verifica si el elemento no está ya en el conjunto
            a[cant] = x; // Agrega el elemento al arreglo
            cant++; // Incrementa el contador de elementos
        }
    }
    
    // Método que verifica si el conjunto está vacío
    public boolean ConjuntoVacio() {
        return cant == 0; // Retorna true si el contador es 0
    }
    
    // Método que devuelve un elemento cualquiera del conjunto
    public int Elegir() {
        return a[cant - 1]; // Retorna el último elemento agregado al conjunto
    }
    
    // Método que verifica si un elemento x pertenece al conjunto
    public boolean Pertenece(int x) {
        int i = 0;
        while (i < cant && a[i] != x) { // Recorre el arreglo hasta encontrar el elemento o llegar al final
            i++;
        }
        return (i < cant); // Retorna true si encontró el elemento
    }
    
    // Método para eliminar un elemento x del conjunto
    public void Sacar(int x) {
        int i = 0;
        while (i < cant && a[i] != x) { // Recorre el arreglo hasta encontrar el elemento o llegar al final
            i++;
        }
        if (i < cant) { // Si encontró el elemento
            a[i] = a[cant - 1]; // Reemplaza el elemento a eliminar con el último del conjunto
            cant--; // Decrementa el contador de elementos
        }
    }
}

