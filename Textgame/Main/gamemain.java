import javax.swing.JOptionPane;
import javax.swing.JDialog;
import java.util.Random;

public class gamemain {


	public static void main(String[] args) {
		boolean end = false;
		boolean run = true;
		boolean sword;
		String trYagain;
		String ani;
		String fMove;
		int count = 1;

		do{
			String name = JOptionPane.showInputDialog("Hello there what is your name?");
			JDialog.setDefaultLookAndFeelDecorated(true);
			int resPonse = JOptionPane.showConfirmDialog(null,"hello there" +" "+ name +" " +"would you like to play a game?");

			if (resPonse == JOptionPane.YES_OPTION){
				end = false;
				sword = false;
				JOptionPane.showMessageDialog(null, "Your mission is to defeat ManBearPig he will be in one of 4 rooms so choose wisely");
				fMove = JOptionPane.showInputDialog(" Which room would you like? Dungeon, Cave, Candy Mountain, Plain room or Village?");

				while (!end){
					Random rgen = new Random();
					int fmove = rgen.nextInt(5) + 1;

					switch(fmove){
					case 1:
						JOptionPane.showMessageDialog(null, "Phew no ManBearPig but also there are no objects so a wasted trip:(");
						fMove = JOptionPane.showInputDialog("Next move");
						end = false;
						break;
					case 2:
						String opt =  JOptionPane.showInputDialog("Dang missed him but there seems to be a shiny object in the corner, Pick it up?");
						if ("yes".equalsIgnoreCase(opt)){
							fMove = JOptionPane.showInputDialog(null, "Congratulations! you got the sword, which room would you like to try next?");
							end = false;
							sword = true;

						}else{
							JOptionPane.showMessageDialog(null, "AHHH ManBearPig found you and you didnt pick up the sword so he tore you in half!");
							end = true;
						}

						break;
					case 3:
						ani = JOptionPane.showInputDialog(null, "Hmmmm no ManBearPig but there seems to be a cute fluffy animal, Should we kill it?");
						if ("yes".equalsIgnoreCase(ani) && sword){
							fMove = JOptionPane.showInputDialog("Wow thats pretty dark"+ " "+ name+" "+ "next room to try?");
							end = false;
							break;
						}
						else if ("yes".equalsIgnoreCase(ani) && !sword){
							fMove = JOptionPane.showInputDialog("Wow"+ " " + name+ " "+ "i'm happy you dont have a sword an innocent gets to live, next room?" );
							end = false;
							break;
						}
						else if ("no".equalsIgnoreCase(ani)){
							fMove = JOptionPane.showInputDialog("You have the moral fortitude of ghandi, which room next?");
							end = false;
							break;
						}

					case 4:
						if (sword){
							JOptionPane.showMessageDialog(null, "You Win!!");

						}else{
							JOptionPane.showMessageDialog(null,"UGGHHHH Man Bear Pig ate your face!!");

						}
						end = true;
						break;
					case 5:
						String bomb = JOptionPane.showInputDialog(null, "Hmmmm there is a chest....open it?");
						if("yes".equalsIgnoreCase(bomb)){
							JOptionPane.showMessageDialog(null,"Oh no you activated a bomb!");


							for ( count = 5; count >= 1; --count){
								String choiCe = JOptionPane.showInputDialog(null, "choose a number between 1 and 10 to diffuse");
								if("5".equalsIgnoreCase(choiCe)){
									fMove = JOptionPane.showInputDialog("Phew you are safe...Whwat room next.");
									end = false;
									break;
								}else if (count == 1){
									JOptionPane.showMessageDialog(null, "ugh you blew up!!");
									end = true;
									break;
								}

							}
						}else
						{
							fMove =  JOptionPane.showInputDialog(null, "Alright what room now?");
							break;
						}
					default:
						break;
					}

				}
				trYagain = JOptionPane.showInputDialog("would you like to play again?");
				if ("no".equalsIgnoreCase(trYagain)){
					run = false;
				}
				if ("yes".equalsIgnoreCase(trYagain)){
					run = true;
					end = false;
				}
			}else if (resPonse == JOptionPane.NO_OPTION  ) {;
			end = true;
			run = false;
			break;
			}else if (resPonse == JOptionPane.CLOSED_OPTION){
				end = true;
				run = false;
				break;
			}



		}while(run);
		JOptionPane.showMessageDialog(null, "Thanks for playing!!");
	}

}