package janela01;
	import javax.swing.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.*;
	import java.util.Timer;
	import java.util.TimerTask;

public class Telas extends JFrame {
	private int andar = 1;
	
	
	public Telas() {
		
		super("Simulador de Elevador");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(3,1));
		
		JButton openButton = new JButton("Abrir");
		JButton closeButton = new JButton("Fechar");
		JButton floor1Button = new JButton("1º Andar"); 
	    JButton floor2Button = new JButton("2º Andar"); 
	    JButton floor3Button = new JButton("3º Andar"); 
		
	    controlPanel.add(openButton); 
	    controlPanel.add(closeButton);
	    controlPanel.add(floor1Button); 
	    controlPanel.add(floor2Button); 
	    controlPanel.add(floor3Button); 

	    openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chamarElevador(andar);
            }
        });

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chamarElevador(andar);
            }
        });

        floor1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chamarElevador(1);
            }
        });

        floor2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chamarElevador(2);
            }
        });

        floor3Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chamarElevador(3);
            }
        });

        add(controlPanel, BorderLayout.CENTER);
    }

    public void chamarElevador(int andarChamado) {
        System.out.println("Chamando o elevador para o andar " + andarChamado);
        System.out.println("O elevador está no andar " + andar);
    }
    public void moverElevador(int destino) {
    	System.out.println("Movendo elevador para o andar " +destino);
    	Timer timer = new Timer();
    	int delay = 2000;
    	
    	int diff = Math.abs(destino - andar);
    	
    	for(int i= 1; i <diff; i++) {
    		final int andarIntermediario = andar +(destino > andar ? i : -i);
    		timer.schedule(new TimerTask() {
    			@Override
    			public void run() {
    				System.out.println("Passando pelo andar " + andarIntermediario);
    			}
    		}, delay *1);
    		
    		}
    		timer.schedule(new TimerTask() {
    			@Override
    			public void run() {
    				andar = destino;
    				System.out.println("Chegou no andar " + andar);
    			}
    		}, delay *diff);
    		
    		timer.cancel();
    	}
    }


	

