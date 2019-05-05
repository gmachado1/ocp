package br.com.chap05.propertyFiles;

import java.util.*;

public class Zoo_en extends ListResourceBundle {
	protected Object[][] getContents() {
		return new Object[][] { { "hello", "Hello" }, { "open", "The zoo is open" }, { "tax", "new UsTaxCode(2)" } };
	}

	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("resourcebundles.Tax", Locale.US);
		System.out.println(rb.getObject("tax"));
	}
}