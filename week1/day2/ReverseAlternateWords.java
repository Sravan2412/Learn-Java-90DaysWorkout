package week1.day2;

public class ReverseAlternateWords {

	public static void main(String[] args) {
		
		/* PROGRAM:
		    Write a java program to do the following.
			Input: "When the world realise its own mistake, corona will dissolve automatically"
			output: "When eht world esilaer its nwo mistake, anoroc will evlossid automatically"
		*/
		
		
		
		String text = "When the world realise its own mistake, corona will dissolve automatically";
		String[] split = text.split("\\s");
		StringBuffer stb = new StringBuffer();
		for (int i = 0; i < split.length; i++) {
			if(i % 2 !=0) {
				stb.append(" ").append(new StringBuffer(split[i]).reverse());
			}
			else {
				stb.append(" ").append(new StringBuffer(split[i]).append(" "));
			}
		}
			System.out.println(stb);
	}
}
