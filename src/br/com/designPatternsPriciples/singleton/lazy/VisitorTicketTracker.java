package br.com.designPatternsPriciples.singleton.lazy;

public class VisitorTicketTracker {

	private static volatile VisitorTicketTracker instance;

	public static VisitorTicketTracker getInstance() {
		if (instance == null) {
			synchronized (VisitorTicketTracker.class) {
				if (instance == null) {
					instance = new VisitorTicketTracker();//THREAD-SAFE!
				}
			}
		}
		return instance;
	}
}
