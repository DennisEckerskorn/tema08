package com.denniseckerskorn.ejercicios.tema08.ejer05;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio05 {
    private AdivinarNumero juego;
    private JLabel labelNumIntentos;

    public Ejercicio05() {
        juego = new AdivinarNumero(5);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int width = 1024;
        int height = 768;
        int x = (int) (dimension.getWidth() / 2f) - Math.round(width / 2f);
        int y = (int) (dimension.getHeight() / 2f) - Math.round(height / 2f);


        //Ventana:
        JFrame frame = new JFrame("Juego Adivinar Numero");
        frame.setSize(width, height);
        frame.setBounds(x, y, width, height);


        //Contenedor dentro de la ventana:
        Container container = frame.getContentPane();
        container.setLayout(null);


        JLabel title = new JLabel("++++++ ADIVINAR EL NUMERO ++++++");
        title.setBounds(320, 200, 400, 50);
        title.setFont(new Font("Courier", Font.BOLD, 20));
        container.add(title);


        //JLabel para el número de intentos:
        labelNumIntentos = new JLabel();
        actualizarLabelNumIntentos();
        labelNumIntentos.setBounds(384, 410, 300, 50);
        //Estilo de texto del JLabel
        labelNumIntentos.setFont(new Font("Courier", Font.BOLD, 15));
        //Se añade el JLabel al container de la ventana.
        container.add(labelNumIntentos);


        //JTextField para el ingreso del número a adivinar:
        JTextField fieldUserInput = new JTextField();
        fieldUserInput.setBounds(384, 465, 200, 50);
        container.add(fieldUserInput);


        //Botón para jugar:
        JButton buttonPlay = new JButton("JUGAR");
        buttonPlay.setBounds(384, 512, 200, 50);
        buttonPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = fieldUserInput.getText();
                if (!userInput.isEmpty() && userInput.matches("\\d+")) {
                    int numJugada = Integer.parseInt(userInput);
                    Mensaje mensaje = juego.jugada(numJugada);
                    juego.decrementarIntentos();
                    JOptionPane.showMessageDialog(null, mensaje.getMensaje());
                    actualizarLabelNumIntentos();
                    if (juego.getIntentosRestantes() == 0) {
                        JOptionPane.showMessageDialog(null, Mensaje.NUMERO_INTENTOS.getMensaje());
                        fieldUserInput.setEnabled(false);
                        buttonPlay.setEnabled(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, Mensaje.INTENTO_INVALIDO.getMensaje());
                }
            }
        });
        container.add(buttonPlay);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void actualizarLabelNumIntentos() {
        labelNumIntentos.setText("Te quedan " + juego.getIntentosRestantes() + " intentos: ");
    }
}
