public class WordGame {
	
	static Scanner inp=new Scanner(System.in);
	public static void main(String[] args) {
		String s="mariam";
		System.out.println("Word Guessing Game");
		System.out.println("Enter the Character ,You got 5 Wrong tries");
		String check=s;
		StringBuilder itr=new StringBuilder("*".repeat(s.length()));
		String inpCheck="";
		for(int i=0;i<5;) {
			String in=inp.nextLine();
			if(!inpCheck.contains(in)) {
				inpCheck=inpCheck.concat(in.trim().charAt(0)+"");
			}
			else {
				System.out.println("You Already Guessed "+in);
				continue;
			}
			if(!check.contains(in)) {
				i++;
				System.out.println("No Charcter of that word is found in the letter");
				System.out.println("You got "+(5-i)+" tries Left");
			}
			else {
				for(int j=0;j<s.length();j++) {
					if(check.charAt(j)==in.charAt(0)) {
						itr.setCharAt(j, check.charAt(j));
					}
				}
			}
			if(itr.toString().equals(s)) {
				System.out.println(" You Found The Word Successfully");
				System.out.println(s);
				return;
			}
			System.out.println(itr);
		}
		System.out.println("You Cant Found The Word within the tries");
		System.out.println("The Word is "+s);
	}

}