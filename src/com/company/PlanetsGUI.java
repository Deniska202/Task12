package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class PlanetsGUI implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JMenuBar menuBar;
    private JMenu planets;
    private ArrayList<JMenuItem> planetNames;
    private JMenuItem planetItem;
    private JLabel title;
    private JLabel forceLabel;

    public PlanetsGUI() {

        frame = new JFrame();
        panel = new JPanel();

        frame = new JFrame();
        panel = new JPanel();
        menuBar = new JMenuBar();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(menuBar);
        frame.add(panel);

        planets = new JMenu("Земля");
        menuBar.add(planets);
        planetNames = new ArrayList<>();
        for (Planet p : Planet.values()) {
            planetItem = new JMenuItem(p.getName());
            planetItem.addActionListener(this);
            planets.add(planetItem);
            planetNames.add(planetItem);
        }

        title = new JLabel("гравитационная сила на планете Земля:");
        title.setBounds(280, 165, 320, 50);
        panel.add(title);

        forceLabel = new JLabel(Double.toString(Planet.EARTH.getGravForce()).substring(0, 4));
        forceLabel.setBounds(380, 180, 100, 50);
        panel.add(forceLabel);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JMenuItem planetItem : planetNames) {
            if (e.getSource() == planetItem) {
                Planet currPlanet = Planet.fromName(planetItem.getText());
                if (currPlanet != null) {
                    title.setText("гравитационная сила на планете " + currPlanet.getName());
                    forceLabel.setText(Double.toString(currPlanet.getGravForce()).substring(0, 4));
                }
            }
        }
    }

    public static void main(String[] args) {
        new PlanetsGUI();
    }
}