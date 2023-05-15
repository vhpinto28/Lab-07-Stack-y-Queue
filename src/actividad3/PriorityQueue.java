package actividad3;

import actividad1.ExceptionIsEmpty;

public interface PriorityQueue<E, P extends Comparable<P>> {
	
    // métodos de la cola de prioridad

	void enqueue(E x, P pr);
	E dequeue() throws ExceptionIsEmpty;
	E front() throws ExceptionIsEmpty;
	E back() throws ExceptionIsEmpty;
	boolean isEmpty();
}