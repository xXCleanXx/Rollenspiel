package com.roleplay.gui;

import com.roleplay.messages.Messages;
import com.roleplay.tiles.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class CharacterPanel extends Tile {

    private JPanel characterPanel;
    private JLabel charcterPicture;

    CharacterPanel(JPanel contentPane) {
        characterPanel = new JPanel(new BorderLayout());
        characterPanel.add(pageStart(), BorderLayout.PAGE_START);
        characterPanel.add(lineStart(), BorderLayout.LINE_START);
        characterPanel.add(lineEnd(), BorderLayout.CENTER);
        characterPanel.add(pageEnd(contentPane), BorderLayout.PAGE_END);

    }

    private JPanel pageStart() {
        JPanel pageStart = new JPanel();
        pageStart.add(new Label(Messages.getString("charcterMenu")));
        pageStart.add(new Label((Messages.getString("player")) + Messages.getString("chooseCharakter")));
        return pageStart;
    }

    private JPanel pageEnd(JPanel contentPane) {
        JPanel lineEnd = new JPanel(new GridLayout(3, 1));

        JButton btn_menue = new JButton(Messages.getString("startMenu"));
        btn_menue.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("MAIN_PANEL"));
        });
        lineEnd.add(btn_menue);

        JButton btn_artefact = new JButton(Messages.getString("artefact"));
        btn_artefact.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("ARTEFACT_PANEL"));
        });
        lineEnd.add(btn_artefact);
        return lineEnd;
    }

    private JPanel lineStart() {
        JPanel lineStart = new JPanel(new GridLayout(3, 1));

        JButton btn_Fighter = new JButton(Messages.getString("fighter"));
        btn_Fighter.addActionListener(e -> {
            charcterPicture.setIcon(new ImageIcon(loadImage("src/com/roleplay/resources/images/gras.png")));
        });
        lineStart.add(btn_Fighter);

        JButton btn_wizard = new JButton(Messages.getString("wizard"));
        btn_wizard.addActionListener(e -> {
            charcterPicture.setIcon(new ImageIcon(loadImage("src/com/roleplay/resources/images/gras.png")));
        });
        lineStart.add(btn_wizard);

        JButton btn_thief = new JButton(Messages.getString("thief"));
        btn_thief.addActionListener(e -> {
            charcterPicture.setIcon(new ImageIcon(loadImage("src/com/roleplay/resources/images/gras.png")));
        });
        lineStart.add(btn_thief);
        return lineStart;
    }

    private JPanel lineEnd() {
        JPanel lineEnd = new JPanel(new GridLayout(3, 1));

        charcterPicture = new JLabel();
        lineEnd.add(charcterPicture);

        JTextField playerName = new JTextField();
        playerName.addActionListener(e -> {
            System.out.print(playerName.getText());
        });
        lineEnd.add(playerName);

        return lineEnd;
    }


    public JPanel getCharacterPanel() {
        return characterPanel;
    }
}
