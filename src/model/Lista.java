package model;

public class Lista<T> implements IntLista<T> {

	No<T> primeiro;
	
	@Override
	public boolean isEmpty() {
		if (primeiro == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void addFirst(T valor) {		
		No<T> elemento = new No<>();
		elemento.dado = valor;
		elemento.proximo = primeiro;
		primeiro = elemento;
	}

	@Override
	public void addLast(T valor) {
		if (isEmpty()) {
			addFirst(valor);
		} else {
			int tamanho = size();
			No<T> elemento = new No<>();
			elemento.dado = valor;
			elemento.proximo = null;
			try {
				No<T> ultimo = getNo(tamanho - 1);
				ultimo.proximo = elemento;
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			
		}
	}

	@Override
	public void add(int posicao, T valor) throws Exception {
		int tamanho = size();
		if (posicao < 0 || posicao > tamanho) {
			throw new Exception("Posição Inválida.");
		} else if (posicao == 0) {
			addFirst(valor);
		} else if (posicao == tamanho) {
			addLast(valor);
		} else {
			No<T> elemento = new No<>();
			elemento.dado = valor;
			No<T> anterior = getNo(posicao - 1);
			elemento.proximo = anterior.proximo;
			anterior.proximo = elemento;
		}
		
	}

	@Override
	public void removeFirst() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia.");
		} else {
			primeiro = primeiro.proximo;
		}
	}

	@Override
	public void removeLast() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia.");
		} else {
			int tamanho = size();
			if (tamanho == 1) {
				removeFirst();
			} else {
				No<T> penultimo = getNo(tamanho - 2);
				penultimo.proximo = null;
			}
		}
	}

	@Override
	public void remove(int posicao) throws Exception {
		int tamanho = size();
		if (isEmpty()) {
			throw new Exception("Lista Vazia.");
		} else if (posicao < 0 || posicao > tamanho){
			throw new Exception("Posicao Inválida.");
		} else if (posicao == 0){
			removeFirst();
		} else if (posicao == (tamanho -1)) {
			removeLast();
		} else {
			No<T> atual = getNo(posicao);
			No<T> anterior = getNo(posicao-1);
			anterior.proximo = atual.proximo;
		}
		
	}

	@Override
	public T get(int posicao) throws Exception {
		int tamanho =  size();
		if (isEmpty()){
			throw new Exception("Lista Vazia.");
		} else if (posicao < 0 || posicao > tamanho) {
			throw new Exception("Posição Inválida.");
		} else if (posicao == 0) {
			return primeiro.dado;
		} else {
			No<T> aux = primeiro;
			int cont = 0;
			while (cont < posicao) {
				cont++;
				aux = aux.proximo;
			}
			return aux.dado;
		}
	}

	@Override
	public int size() {
		int cont = 0;
		if (!isEmpty()) {
			No<T> aux = primeiro;
			while (aux != null) {
				cont++;
				aux = aux.proximo;
			}
		}
		return cont;
	}
	
	private No<T> getNo(int posicao) throws Exception {
		int tamanho = size();
		if (isEmpty()) {
			throw new Exception("Lista Vazia.");
		}
		if (posicao < 0 || posicao > tamanho) {
			throw new Exception("Posição Inválida.");
		} else if (posicao == 0) {
			return primeiro;
		} else {
			No<T> aux = primeiro;
			int cont = 0;
			while (cont < posicao) {
				cont++;
				aux = aux.proximo;
			}
			return aux;
		}
	}
	
	public void clean() {
		primeiro.dado = null;
		primeiro.proximo = null;
	}
}
