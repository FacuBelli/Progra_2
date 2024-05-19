package colas;

// Implementación de la interfaz ColaTDA
public class Implementacion_2_colas implements ColaTDA {
    // Clase interna que representa un elemento de la cola con su valor y prioridad
    class Elemento {
        int valor;
        int prioridad;
    }
    
    // Arreglo para almacenar los elementos de la cola
    Elemento[] elementos;
    // Índice para llevar el control del tamaño de la cola
    int indice;
    
    // Método para inicializar la cola
    public void InicializarCola() {
        indice = 0; // Inicializa el índice en 0
        elementos = new Elemento[100]; // Inicializa el arreglo con un tamaño de 100
    }
    
    // Método para agregar un elemento con una prioridad específica
    public void AcolarPrioridad(int x, int prioridad) {
        int j = indice;
        // Busca la posición adecuada para agregar el nuevo elemento
        for (; j > 0 && elementos[j-1].prioridad <= prioridad; j--) {
            elementos[j] = elementos[j-1]; // Desplaza los elementos para hacer espacio
        }
        // Crea un nuevo elemento y lo inserta en la posición correcta
        elementos[j] = new Elemento();
        elementos[j].valor = x;
        elementos[j].prioridad = prioridad;
        indice++; // Incrementa el tamaño de la cola
    }
    
    // Método para eliminar el elemento con la mayor prioridad
    public void Desacolar() {
        elementos[indice-1] = null; // Elimina el elemento
        indice--; // Decrementa el tamaño de la cola
    }
    
    // Método para obtener el primer elemento (con la mayor prioridad)
    public int Primero() {
        return elementos[indice-1].valor;
    }
    
    // Método para verificar si la cola está vacía
    public boolean ColaVacia() {
        return (indice == 0);
    }
    
    // Método para obtener la prioridad del primer elemento
    public int Prioridad() {
        return elementos[indice-1].prioridad;
    }

    public void mostrar() {
		for(int i =indice-1;i!=-1;i--) {
			System.out.println("este es el valor "+ elementos[i].valor+ " esta es la prioridad "+ elementos[i].prioridad);
			
		}
	}


}
