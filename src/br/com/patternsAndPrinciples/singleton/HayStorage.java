package br.com.patternsAndPrinciples.singleton;

public class HayStorage {

	private int quantityOfHay = 0;
	private final static HayStorage hayStorage;// = new HayStorage(); ou linhas abaixo
	// caso queira a instância lazy, comente as linhas 8-9
	static {
		hayStorage = new HayStorage();
	}

	private HayStorage() {

	}

	public static HayStorage getInstance() {
		// caso queira intancia lazy tire o termo final e descomente aqui
//		if (hayStorage==null) { 
//				hayStorage = new HayStorage();
//		}
		return hayStorage;
	}

	public synchronized void addHay(int amount) {
		quantityOfHay += amount;
	}

	public synchronized boolean removeHay(int amount) {
		if (quantityOfHay < amount) {
			return false;
		}
		quantityOfHay -= amount;
		return true;
	}

	public synchronized int getQuantityOfHay() {
		return quantityOfHay;
	}
}
