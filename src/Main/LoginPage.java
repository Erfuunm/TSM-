package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton button = new JButton("login");
    JButton resetbutton = new JButton("Reset");

    JTextField userIDField = new JTextField();
    JPasswordField userPassField = new JPasswordField();
    JLabel userIDlabel = new JLabel("UserID:");
    JLabel userPasslabel = new JLabel("UserPass:");
    JLabel message = new JLabel();
    HashMap<String, String> logininfo = new HashMap<String, String>();

    LoginPage(HashMap<String, String> logininfoOriginal) {

        logininfo = logininfoOriginal;

//        ImageIcon background = new ImageIcon("marketin.png");
//        frame.setBackground(background);

        userIDlabel.setBounds(50, 100, 75, 25);
        userPasslabel.setBounds(50, 150, 75, 25);
        message.setBounds(125, 250, 250, 35);
        message.setFont(new Font(null, Font.ITALIC, 25));
        userIDField.setBounds(125, 100, 200, 25);
        userPassField.setBounds(125, 150, 200, 25);

        button.setBounds(125, 200, 100, 25);
        button.setFocusable(false);
        button.addActionListener(this);

        resetbutton.setBounds(225, 200, 100, 25);
        button.setFocusable(false);
        resetbutton.addActionListener(this);


        frame.add(button);
        frame.add(resetbutton);
        frame.add(userIDField);
        frame.add(userPassField);
        frame.add(userIDlabel);
        frame.add(userPasslabel);
        frame.add(message);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 320);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == resetbutton) {
            userIDField.setText("");
            userPassField.setText("");
        }
        if (e.getSource() == button) {

            String userID = userIDField.getText();
            String Passwoard = String.valueOf(userPassField.getPassword());
            if (logininfo.containsKey(userID)) {
                if (logininfo.get(userID).equals(Passwoard)) {
                    System.out.println("Login");
                    menufp m = new menufp();
                    // Game game = new Game();
                    frame.dispose();
                }
            }
        }


    }
}

