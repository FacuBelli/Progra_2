package colas;

public interface ColaTDA {
	void InicializarCola();
	void AcolarPrioridad(int x,int prioridad);
	void Desacolar();
	boolean ColaVacia();
	int Primero();
	int Prioridad();
}
