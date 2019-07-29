package br.com.classDesign.exam;

import java.util.ArrayList;

public class IsItFurry {
	static class Chimpmunk {
	}

	public static void main(String args[]) {
		Chimpmunk c = new Chimpmunk();
		ArrayList<Chimpmunk> li = new ArrayList<>();
		Runnable r = new Thread();
		int result = 0;
		if (c instanceof Chimpmunk)
			result += 1;
		if (li instanceof Chimpmunk)
			result += 2;
		if (r instanceof Chimpmunk)
			result += 4;
		
		System.out.println(result);
	}

}
