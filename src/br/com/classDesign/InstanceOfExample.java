package br.com.classDesign;

interface Mother {

}

class HeavyAnimal {
}

class Hippo extends HeavyAnimal {
}

class Elephant extends HeavyAnimal {
}

public class InstanceOfExample {
	public static void main(String[] args) {
		HeavyAnimal hippo = new Hippo();
		boolean b1 = hippo instanceof Hippo; // true
		boolean b2 = hippo instanceof HeavyAnimal; // true
		boolean b3 = hippo instanceof Elephant; // false
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		HeavyAnimal hippo2 = new Hippo();
		boolean b4 = hippo2 instanceof Object; // true
		Hippo nullHippo = null;
		boolean b5 = nullHippo instanceof Object; // false
		System.out.println(b4);
		System.out.println(b3);
		Hippo anotherHippo = new Hippo();
		// boolean b5 = anotherHippo instanceof Elephant; // DOES NOT COMPILE
		HeavyAnimal hippo3 = new Hippo();
		boolean b6 = hippo3 instanceof Mother; // false compile works
		// compiler supose it could future be a: class MotherHippo extends Hippo
		// implements Mother { }

	}

}
