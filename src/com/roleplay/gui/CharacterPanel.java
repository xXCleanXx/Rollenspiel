package com.roleplay.gui;

import com.roleplay.tools.Image;
import com.roleplay.tools.Messages;

import javax.swing.*;
import java.awt.*;

public class CharacterPanel {

    private JPanel characterPanel;
    private JLabel charcterPicture;

    private int player = 0;
    private JLabel title;
    private JLabel subTitle;
    private JButton btn_menu;
    private JButton btn_artefact;
    private JButton btn_wizard;
    private JButton btn_Fighter;
    private JButton btn_thief;
    private JTextField textField1;

    CharacterPanel(JPanel contentPane) {
        lineStart();
        lineEnd();
        pageEnd(contentPane);
    }

    private void pageEnd(JPanel contentPane) {

        btn_menu.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("MAIN_PANEL"));
        });

        btn_artefact.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("ARTEFACT_PANEL"));
        });

    }

    private void lineStart() {
        btn_Fighter.setSize(new Dimension(200, 200));
        btn_Fighter.setMaximumSize(btn_Fighter.getSize());
        btn_Fighter.addActionListener(e -> charcterPicture.setIcon(new ImageIcon(Image.loadImage("src/com/roleplay/resources/images/player.png"))));

        btn_wizard.setSize(new Dimension(100, 100));
        btn_wizard.addActionListener(e -> charcterPicture.setIcon(new ImageIcon(Image.loadImage("src/com/roleplay/resources/images/player.png"))));

        btn_thief.setSize(new Dimension(100, 100));
        btn_thief.addActionListener(e -> charcterPicture.setIcon(new ImageIcon(Image.loadImage("src/com/roleplay/resources/images/player.png"))));
    }

    private void lineEnd() {
        JTextField playerName = new JTextField();
        playerName.addActionListener(e -> System.out.print(playerName.getText()));

        JButton nextFinish = new JButton(Messages.getString("next"));
        nextFinish.addActionListener(e -> {

        });
    }


    public JPanel getCharacterPanel() {
        return characterPanel;
    }
}
