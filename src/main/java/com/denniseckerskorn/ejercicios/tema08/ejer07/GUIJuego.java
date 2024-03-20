package com.denniseckerskorn.ejercicios.tema08.ejer07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIJuego {
    private JuegoPPT juego;
    private JLabel scoreLabelPlayer;
    private JLabel scoreLabelCPU;
    private JLabel scoreEven;
    private int roundsPlayed;

    public GUIJuego() {
        juego = new JuegoPPT(5);
        roundsPlayed = 0;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int width = 800;
        int height = 600;

        int x = (int) (dimension.getWidth() / 2f) - Math.round(width / 2f);
        int y = (int) (dimension.getHeight() / 2f) - Math.round((height / 2f));

        //Ajustes Ventana
        JFrame frame = new JFrame("Piedra - Papel - Tijeras");
        frame.setBounds(x, y, width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Panel del titulo:
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("Piedra, Papel y Tijeras");
        titlePanel.add(titleLabel);

        //Panel central:
        JPanel centerPanel = new JPanel(new BorderLayout());

        //Panel de Jugador 1:
        JPanel player1Panel = new JPanel(new GridLayout(4, 1, 5, 5));
        player1Panel.add(new JLabel("Jugador"));

        JPanel buttonPanel1 = new JPanel(new GridLayout(3, 1, 5, 5));
        JButton piedraButton = new JButton("Piedra");
        piedraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playRound(JuegoPPT.PPT.PIEDRA);
            }
        });
        buttonPanel1.add(piedraButton);

        JButton papelButton = new JButton("Papel");
        papelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playRound(JuegoPPT.PPT.PAPEL);
            }
        });
        buttonPanel1.add(papelButton);

        JButton tijeraButton = new JButton("Tijera");
        tijeraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playRound(JuegoPPT.PPT.TIJERA);
            }
        });
        buttonPanel1.add(tijeraButton);
        player1Panel.add(buttonPanel1);

        //Panel de CPU:
        JPanel player2Panel = new JPanel(new GridLayout(4, 1, 5, 5));
        player2Panel.add(new JLabel("CPU"));

        //Panel de puntuación:
        JPanel scorePanel = new JPanel(new FlowLayout());
        scoreLabelPlayer = new JLabel("Score Player: " + juego.getScorePlayer());
        scorePanel.add(scoreLabelPlayer);

        scoreLabelCPU = new JLabel("Score CPU: " + juego.getScoreCPU());
        scorePanel.add(scoreLabelCPU);

        scoreEven = new JLabel("Score It's a Tie: " + juego.getScoreEven());
        scorePanel.add(scoreEven); //Falta posicionar correctamente e implemtar que pasa si hay una partida de solo scoreEven

        //Panel para el boton de Jugar:
        JPanel playPanel = new JPanel();
        JButton buttonPlay = new JButton("Jugar");
        buttonPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        playPanel.add(buttonPlay);

        //Se especifica en que lado está cada panel de Jugador:
        centerPanel.add(player1Panel, BorderLayout.WEST);
        centerPanel.add(player2Panel, BorderLayout.EAST);
        centerPanel.add(scorePanel, BorderLayout.CENTER);
        centerPanel.add(playPanel, BorderLayout.SOUTH);


        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void startGame() {
        roundsPlayed = 0;
        juego.resetGame();
        updateScores();
    }

    private void playRound(JuegoPPT.PPT playerChoice) {
        juego.playRound(playerChoice);
        roundsPlayed++;
        updateScores();
        if (roundsPlayed == juego.getRounds()) {
            determineWinner();
            JOptionPane.showMessageDialog(null, "El juego ha terminado. Haz click en Jugar para comenzar un nuevo juego. ");
        }
    }

    private void updateScores() {
        scoreLabelPlayer.setText("Score Player: " + juego.getScorePlayer());
        scoreLabelCPU.setText("Score CPU: " + juego.getScoreCPU());
        scoreEven.setText("Score It's a Tie: " + juego.getScoreEven());
    }

    private void determineWinner() {
        int playerScore = juego.getScorePlayer();
        int cpuScore = juego.getScoreCPU();
        //int evenScore = juego.getScoreEven();
        //int totalRounds = juego.getRounds();

        if (playerScore > cpuScore) {
            JOptionPane.showMessageDialog(null, "Felicidades! Has ganado el juego");
        } else if (playerScore < cpuScore) {
            JOptionPane.showMessageDialog(null, "La CPU ha ganado el juego!");
        } else {
            JOptionPane.showMessageDialog(null, "El juego ha terminado en empate!");
        }
    }
}
