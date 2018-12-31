import java.awt.BorderLayout;
import java.util.stream.IntStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {
		final Deck deck = Deck.newShuffleSingleDeck();
		final int numCardsToDeal = 52;
		IntStream.range(0, numCardsToDeal).forEach(value -> System.out.println(deck.deal()));

		
		/*
		JFrame window = new JFrame("Universal Card App");
		window.setSize(400, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		JPanel content = new JPanel(new BorderLayout());
		
		//JLabel cardLabel = new Jlabel ();*/
	}

}
