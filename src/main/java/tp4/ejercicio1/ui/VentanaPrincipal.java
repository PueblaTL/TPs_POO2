package tp4.ejercicio1.ui;

import tp4.ejercicio1.model.Concurso;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private JTextField nombre;
    private JTextField telefono;
    private JTextField region;
    private JTextField email;
    private Concurso concurso;

    public VentanaPrincipal(Concurso concurso) {
        this.concurso = concurso;
    }

    public void AgregarParticipante() {
        setupUIComponents();
    }

    private void setupUIComponents() {
        setTitle("Add Participant");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.nombre = new JTextField(10);
        this.telefono = new JTextField(10);
        this.region = new JTextField(10);
        this.nombre.setText("");
        this.telefono.setText("");
        this.region.setText("China");
        this.email = new JTextField(15);
        this.email.setText("");
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout());
        contentPane.add(new JLabel("Nombre: "));
        contentPane.add(nombre);
        contentPane.add(new JLabel("Telefono: "));
        contentPane.add(telefono);
        contentPane.add(new JLabel("Region: "));
        contentPane.add(region);
        contentPane.add(new JLabel("Email: "));
        contentPane.add(email);

        JButton botonCargar = new JButton("Cargar");
        botonCargar.addActionListener(e -> {
            try {
                concurso.registrarParticipante(
                        nombre.getText(),
                        telefono.getText(),
                        region.getText(),
                        email.getText()
                );
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this, e1.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        contentPane.add(botonCargar);
        setContentPane(contentPane);
        contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pack();
        setVisible(true);
    }


}