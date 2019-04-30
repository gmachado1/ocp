package br.com.chap02.singleton;

public class LlamaTrainer {

	public boolean feedLlamas(int numberOfLlamas) {
		int amountNeeded = 5 * numberOfLlamas;
		HayStorage hayStorage = HayStorage.getInstance();
		if (hayStorage.getQuantityOfHay() < amountNeeded) {
			hayStorage.addHay(amountNeeded + 10);
		}
		boolean fed = hayStorage.removeHay(amountNeeded);
		if (fed)
			System.out.println("Llamas have been fed");
		return fed;
	}
}
