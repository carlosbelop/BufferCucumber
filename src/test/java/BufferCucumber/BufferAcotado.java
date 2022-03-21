package BufferCucumber;

/**
 * Clase que implementa un buffer acotado
 * @author Carlos Beltr�n
 * @version 1.1
 *
 */
public class BufferAcotado<T> {
	
	public class Node<T>{
		private T element;
		private Node<T> next; //referencia al siguiente nodo
		
		public Node(T it, Node<T> nextval){
			element = it;
			next = nextval;
		}
		
		public Node(Node<T> nextval) {
			element = null;
			next = nextval;
		}
		public Node<T> setNext(Node<T> nextval) { return next = nextval;}
		public Node<T> next(){ return next;}
		public T setElement(T it) {return element = it;}
		public T element() {return element;}
	}
	
	private int capacidad;
	private int size;
	private Node<T> head,tail;

	/**
	 * CONSTRUCTOR
	 * @param capacidad :int capacidad del buffer (numero maximo de elementos que puede contener)
	 * @throws IllegalArgumentException if (!capacidad<=0) // precondition
	 */
	public BufferAcotado(int capacidad) {
		
		if (capacidad <=0) {
			throw new IllegalArgumentException("La capacidad no puede ser 0 o negativa");
		}
		if (capacidad>Integer.MAX_VALUE) {
			throw new IllegalArgumentException("Capacidad demasiado grande para el tipo Integer");
		}
		this.capacidad=capacidad;
		size=0;
		head=tail=null;
	}
	
	/**
	 * Inserts the specified element at the end of the Buffer 
	 * if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available
	 * @param  element :T -- the element to insert
	 * @throws IllegalStateException if the buffer is full.
	 * @post   the size of the buffer is increased by 1
	 * @post   the new element becomes the last element of the buffer
	 */
	public void put(T element) {
		if (this.size()==capacidad) throw new IllegalStateException("Buffer lleno");
		Node<T> nuevo = new Node<T>(element,null);
		if (head == null)  head = tail = nuevo;
		else  tail = tail.setNext(nuevo);
		size++;
		
	}
	
	/**
	 * Retrieves and removes the head of the Buffer
	 * @return :T -- the element that was at the head of the Buffer
	 * @throws IllegalStateException if the buffer is empty -- precondition
	 * @post   the size of the buffer is decreased by 1
	 * @post   buffer@pre = buffer.prepend(result) 
	 */
	public T get() {
		if (head == null) throw new IllegalStateException("La pila est� vacia");
		else {
			T it = head.element();
			head = head.next();
			if (head == null) tail = null;
			size--;
			return it;
		}
		
	}
	
	/**
	 * This is a query operation that returns the number of elements currently in the buffer
	 * @return :int -- elements.size()
	 */
	public int size() {
		return size;
	}
	
	/**
	 * This is a query operation that checks if the buffer is full
	 * @return :boolean -- elements.size()==capacidad
	 */
	public boolean isFull() {
		return size==capacidad;
	}
	
	/**
	 * This is a query operation that checks if the buffer is empty
	 * @return :boolean -- elements.size()==0
	 */
	public boolean isEmpty() {
		return size==0;
	}
}
