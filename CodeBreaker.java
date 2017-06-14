/*
@author Maxwell Lavin

this is a CodeBreaker program where you are given a random scrambled word, and you are tasked
 with correcting it. It will tell you how many letters you have in the right place but not what they
 are.

*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Random;




class CodeBreaker implements ActionListener{
	
	// declaring all parts of the Swing
	
	JFrame Game = new JFrame("CodeBreaker");
	
	JLabel Instructions, Word, Mystery;
	
	JButton Start, Easy,  Med,  Hard, Enter;
	
	JTextField Letter;
	
	String get;
	
	int sel;
	int Strike;
	int hit;
	int fire = 1;
	
	ArrayList<Integer> hat;
    String Search;
	char[] find;
	
	Random Choice = new Random();
	Random Cypher = new Random();
	
	
	
	CodeBreaker() {
		
		// sets the Frame and layout
		
		Game.setLayout(new FlowLayout());
		 
		Game.setSize(1500,  600);
		 
		Game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//instructions and buttons
		
		Instructions = new JLabel("Select difficulty of the game, then try to guess the word that is scrambled. If you are wrong, the game will tell you how many letters you got right. If you are right, the game will tell you you won, and show the word.");
		Word = new JLabel(" ");
		
		
		Mystery = new JLabel(" ");
		
		Letter= new JTextField(5);
		
		Letter.setActionCommand(" ");
		
		
		Start = new JButton("Start");
		Easy = new JButton("Easy");
		Med = new JButton("Medium");
		Hard = new JButton("Hard");
		Enter = new JButton("Enter");
		
		Game.add(Mystery);		
		Game.add(Letter); 
		Game.add(Enter);
		Game.add(Instructions);
		Game.add(Word);
		
		
		Game.add(Start);
		Game.add(Easy);
		Game.add(Med);
		Game.add(Hard);
		
		
		Start.addActionListener(this);
		Easy.addActionListener(this);
		Med.addActionListener(this);
		Hard.addActionListener(this);
		Enter.addActionListener(this);
		Letter.addActionListener(this);
		
		
		
		
		Game.setVisible(true);
		
		Word.setVisible(false);
		Mystery.setVisible(false);
		Letter.setVisible(false);
		
		Easy.setVisible(false);
		Med.setVisible(false);
		Hard.setVisible(false);
		Enter.setVisible(false);
		
			

	}
	// this method makes an arraylist of non repeating random numbers equal to the number entered. it is used for the scramble part.
public ArrayList<Integer> Spin(int take) {
		int hum;
		Random Win = new Random();
		ArrayList<Integer> bat = new ArrayList<Integer>();
		
		while (bat.size() < take){ 
			{
				hum = Win.nextInt(take);
				if (bat.contains(hum) == false){
					bat.add(hum);	
				}
			}
		
	}
		return bat;}
	
	public void actionPerformed(ActionEvent ae){ // takes the buttons and jfields and makes then work
		String Hold = " ";
		String Enigma = " ";
		
		if(ae.getActionCommand().equals("Start")){
			Instructions.setVisible(false);
			Start.setVisible(false);
			Easy.setVisible(true);
			Med.setVisible(true);
			Hard.setVisible(true);
			
		}
		if(ae.getActionCommand().equals("Easy")){
			Easy.setVisible(false);
			Med.setVisible(false);
			Hard.setVisible(false);
			Letter.setVisible(true);
			Enter.setVisible(true);
			
			sel = Choice.nextInt(4);
			
			if(sel == 0){
				Word.setText("MOVIE");
			}
			if(sel == 1){
				Word.setText("BATMAN");
			}
			if(sel == 2){
				Word.setText("COMPUTER");
			}
			if(sel == 3){
				Word.setText("PROGRAM");
			}
			hit = Word.getText().length();
			hat = Spin(hit);
		
		}
		if(ae.getActionCommand().equals("Medium")){
			Easy.setVisible(false);
			Med.setVisible(false);
			Hard.setVisible(false);
			Letter.setVisible(true);
			Enter.setVisible(true);
			
			sel = Choice.nextInt(4);
			if(sel == 0){
				Word.setText("PIZZA");
			}
			if(sel == 1){
				Word.setText("COPPER");
			}
			if(sel == 2){
				Word.setText("DECAY");
			}
			if(sel == 3){
				Word.setText("TEMPER");
			}
			hit = Word.getText().length();
			hat = Spin(hit);
		}
		if(ae.getActionCommand().equals("Hard")){
			Easy.setVisible(false);
			Med.setVisible(false);
			Hard.setVisible(false);
			Letter.setVisible(true);
			Enter.setVisible(true);
			
			sel = Choice.nextInt(4);
			if(sel == 0){
				Word.setText("GRADUATE"); 
			}
			if(sel == 1){
				Word.setText("GRANDIOSE");
			}
			if(sel == 2){
				Word.setText("FLAMINGOES");
			}
			if(sel == 3){
				Word.setText("ZIRCONIA");
			}
			hit = Word.getText().length();
			hat = Spin(hit);
		}
		Hold = Word.getText();
		String rando = "";
	
		for(int i = 0; i < Hold.length(); i++){		
				rando = rando + "" + Hold.charAt(hat.get(i)); // randomizes the word from the Spin method
			}
			
		Enigma = rando;
		Mystery.setText(Enigma);
		Mystery.setVisible(true);
		
		
		// takes the input words, and checks with the normal word.
		if(ae.getActionCommand().equals("Enter")){
			Search = Letter.getText().toUpperCase().trim();
			find = Search.toCharArray();
			Strike = 0;
			
					if(Search.compareTo(Hold) == 0) // this tells it that you won
					{
						fire = 0;
					}
					else
					{
						for(int j = 0; j < Hold.length(); j++){
								if(find[j] == Hold.charAt(j)){
									Strike++;	//this counts if how many letters you got right		
							}
					}
					
				}
				
				
				Letter.setText("");
				Instructions.setText("You have: " + Strike +" Letters correct");
				Instructions.setVisible(true);
				
				}
		if(fire == 0) // win function
		{
			Instructions.setText("Game Over, The Word was: " + Hold + " You Win!");
			
			Instructions.setVisible(true);
			Word.setVisible(false);
			Mystery.setVisible(false);
			Letter.setVisible(false);
		
			Enter.setVisible(false);
		}
			
			}
		
	
		
	
	// runs the program
	public static void main(String arg[]) {
		 SwingUtilities.invokeLater(new Runnable() {
			 public void run() {
				 new CodeBreaker();
			 
			 }
		 });
	 }
}
	
	
	


