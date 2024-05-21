package com.senac.elevador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.TimerTask;
import java.util.Timer;

public class Janela extends JFrame {

	private JButton btnAbrir, btnFechar;
	private JButton[] btnAndar;
	private JLabel lblInicio;
	private int andarChamado, contador = 0, andarAtual = 0;
	private ActionListener ouvinte;
	private Timer tempo;

	public Janela() {
		inicio();
	}

	private void inicio() {
		setTitle("Bem-vindo ao Elevador KXPO!");
		setSize(800, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		criarPainel();
		setVisible(true);
	}

	private void criarPainel() {
		add(criarLabel()); // ok
		criarBtnAbrirFechar(); // ok
		criarBtnAndares();
	}

	private void criarBtnAndares() {
		ouvinte = (ActionEvent ae) -> {

			chamarElevador(ae.getActionCommand());

		};
		btnAndar = new JButton[5];
		int x = 45;
		for (int i = 0; i < btnAndar.length; i++) {
			btnAndar[i] = new JButton("" + (i + 1));
			// btnAndar[i] = new JButton(Integer.toString(i));
			btnAndar[i].setBounds(x, 260, 120, 60);
			btnAndar[i].addActionListener(ouvinte);
			x += 145;
			add(btnAndar[i]);
		}
	}

	private void chamarElevador(String andar) {
		this.andarChamado = Integer.parseInt(andar);
		int i = 0;
		while (i < btnAndar.length) {
			if (btnAndar[i].getText() == andar) {

				btnAndar[i].setBackground(Color.YELLOW);
				btnAbrir.setBackground(Color.RED);
				btnFechar.setBackground(new Color(238, 238, 238));

				andarAtual = andarChamado;
				break;
			}
			i++;
		}
		moverElevador();
	}

	private void criarBtnAbrirFechar() {
		btnAbrir = new JButton("ABERTO");
		btnFechar = new JButton("FECHADO");
		btnAbrir.setBounds(160, 135, 220, 60);
		btnFechar.setBounds(400, 135, 220, 60);
		add(btnAbrir);
		add(btnFechar);
	}

	private void moverElevador() {
		tempo = new Timer();
		tempo.schedule(new TimerTask() {
			@Override
			public void run() {
				if (contador < andarChamado) {
					contador++;
				} else if (contador > andarChamado) {
					contador--;
				}
				lblInicio.setText("Movimento do elevador > " + contador + " < ");
				if (contador == andarChamado) {
					tempo.cancel();
					atualizarCoresBotoes();
				}
			}

		}, 0, 1000);
	}

	private void atualizarCoresBotoes() {
		for (int i = 0; i < btnAndar.length; i++) {
			if (Integer.parseInt(btnAndar[i].getText()) == andarAtual) {
				btnAndar[i].setBackground(Color.GREEN);
			} else {
				btnAndar[i].setBackground(new Color(238, 238, 238));
			}
			btnAbrir.setBackground(new Color(238, 238, 238));
			btnFechar.setBackground(Color.RED);
		}

	}

	private Component criarLabel() {
		lblInicio = new JLabel("Elevador KXPO : escolha um andar.");
		lblInicio.setFont(new Font("Arial", Font.PLAIN, 38));
		lblInicio.setHorizontalAlignment(JLabel.CENTER);
		lblInicio.setBounds(0, 60, 800, 30);
		return lblInicio;
	}
}
