package br.com.classDesign.nestedClasses;

public class AnonInner2 {
	interface SaleTodayOnly {
		int dollarsOff();
	}

	public int pay() {
		return admission(5, new SaleTodayOnly() {
							public int dollarsOff() {
								return 3;
							}
						});
	}

	public int admission(int basePrice, SaleTodayOnly sale) {
		return basePrice - sale.dollarsOff();
	}
}
