package br.com.designPatternsPriciples.singleton.lazy;

//Lazy instantiation
public class VisitorTicketTrackerNotSafe {
	private static VisitorTicketTrackerNotSafe instance;

	private VisitorTicketTrackerNotSafe() {
	}

	public static VisitorTicketTrackerNotSafe getInstance() {
		if (instance == null) {
			instance = new VisitorTicketTrackerNotSafe(); // NOT THREAD-SAFE!
		}
		return instance;
	}
//Data access methods
}