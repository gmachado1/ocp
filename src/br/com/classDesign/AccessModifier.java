package br.com.classDesign;

import br.com.classDesign.cat.BigCat;

public class AccessModifier {
	public static void main(String[] args) {
		BigCat cat = new BigCat();
		System.out.println(cat.name);
		//System.out.println(cat.hasFur);  //compile error
		//System.out.println(cat.hasPaws); //compile error
		///System.out.println(cat.id);		//compile error
	}

}
