package model;

public interface IntLista<T> {

	public boolean isEmpty();
	public void addFirst(T valor);
	public void addLast(T valor);
	public void add(int posicao, T valor) throws Exception;
	public void removeFirst() throws Exception;
	public void removeLast() throws Exception;
	public void remove(int posicao) throws Exception;
	public T get(int posicao) throws Exception;
	public int size();
	
}
