package janela01;

import javax.swing.SwingUtilities;

public class telaTeste {


	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
	        Telas elevatorFrame = new Telas();
	        elevatorFrame.setVisible(true); 
	    });
	}
	}

