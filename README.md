Cálculo de costos de las operaciones de los TDAs utilizados (Cola con Prioridades y Conjunto) y del servicio pedido (desencolar clientes y agregarlos a los Conjuntos correspondientes).

Costos de operaciones de Cola con Prioridades (Implementacion_2_colas):

●	InicializarCola(): Costo constante O(1), ya que simplemente se inicializa el índice y se crea un arreglo de tamaño fijo.
●	AcolarPrioridad(int x, int prioridad): En el peor caso, cuando se inserta un elemento con la prioridad más alta, se deben desplazar todos los elementos existentes una posición hacia la derecha. Por lo tanto, el costo es O(n), donde n es el número de elementos en la cola.
●	Desacolar(): Costo constante O(1), ya que simplemente se elimina el último elemento y se decrementa el índice.
●	Primero(): Costo constante O(1), ya que solo se accede al último elemento del arreglo.
●	ColaVacia(): Costo constante O(1), ya que solo se compara el índice con cero.
●	Prioridad(): Costo constante O(1), ya que solo se accede al campo prioridad del último elemento del arreglo.}

Costos de operaciones de Conjunto (Implementacion_colas):

●	InicializarConjunto(): Costo constante O(1), ya que simplemente se crea un arreglo de tamaño fijo y se inicializa la variable cant.
●	Agregar(int x): En el peor caso, cuando se agrega un elemento que no está presente en el conjunto, se debe recorrer todo el arreglo para verificar su pertenencia. Por lo tanto, el costo es O(n), donde n es el número de elementos en el conjunto.
●	Elegir(): Costo constante O(1), ya que solo se accede al último elemento del arreglo.
●	ConjuntoVacio(): Costo constante O(1), ya que solo se compara la variable cant con cero.
●	Sacar(int x): En el peor caso, cuando se elimina un elemento que está presente en el conjunto, se debe recorrer todo el arreglo para encontrarlo. Luego, se desplazan los elementos restantes hacia una posición a la izquierda. Por lo tanto, el costo es O(n), donde n es el número de elementos en el conjunto.
●	Pertenece(int x): En el peor caso, cuando el elemento no se encuentra en el conjunto, se debe recorrer todo el arreglo. Por lo tanto, el costo es O(n), donde n es el número de elementos en el conjunto.

Costo del servicio (desencolar clientes y agregarlos a los Conjuntos correspondientes):

El servicio consiste en desencolar todos los clientes de la Cola de Prioridad y agregarlos a los Conjuntos correspondientes según su tipo lo que implica realizar las siguientes operaciones:

●	Desencolar un cliente de la Cola de Prioridad: Costo O(1).
●	Agregar el cliente al Conjunto correspondiente: Costo O(n), donde n es el número de elementos en el Conjunto.


