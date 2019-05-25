package br.com.classDesign.nestedClasses;

/**
 * The rule that all methods in an interface are public still applies. A class
 * that implements the interface must define that method as public. The
 * interface itself does not have to be public, though. Just like any inner
 * class, an inner interface can be private. This means that the interface can
 * only be referred to within the current outer class.
 * 
 * @author gustavo
 *
 */
public class CaseOfThePrivateInterface {
	private interface Secret {
		public void shh();
	}

	class DontTell implements Secret {
		public void shh() {
		}
	}
}
