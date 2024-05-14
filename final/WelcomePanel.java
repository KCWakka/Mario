import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WelcomePanel extends JPanel implements ActionListener {

    private JTextField textField;
    private JTextField textField2;
    private JButton submitButton;
    private JButton clearButton;
    private JFrame enclosingFrame;
    private BufferedImage goomba;
    private JButton rickRollButton;

    public WelcomePanel(JFrame frame) {
        enclosingFrame = frame;
        try {
            goomba = ImageIO.read(new File("src/goomba.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        textField = new JTextField(20);
        textField2 = new JTextField(20);
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        rickRollButton = new JButton("RickRoll");
        add(textField);  // textField doesn't need a listener since nothing needs to happen when we type in text
        add(submitButton);
        add(textField2);
        add(clearButton);
        add(rickRollButton);
        submitButton.addActionListener(this);
        clearButton.addActionListener(this);
        rickRollButton.addActionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(Color.RED);
        g.drawString("Please enter your name:", 50, 12);
        g.drawString("P1: ", 27, 32);
        g.drawString("P2: ", 27, 50);
        g.drawImage(goomba, 200, 50, null);
        textField.setLocation(50, 18);
        textField2.setLocation(50, 40);
        submitButton.setLocation(50, 100);
        rickRollButton.setLocation(100,70);
        clearButton.setLocation(150, 100);
    }

    // ACTIONLISTENER INTERFACE METHODS
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == submitButton) {
                if (textField.getText().equals("") || textField.getText().equals("Invalid, choose a name")) {
                    textField.setText("Invalid, choose a name");
                } else {
                    String playerName = textField.getText();
                    String playerName2 = textField2.getText();
                    MainFrame f = new MainFrame(playerName, playerName2, false);
                    enclosingFrame.setVisible(false);
                }
            } else if (button == clearButton){
                textField.setText("");
                textField2.setText("");
            } else {
                MainFrame f = new MainFrame("Rich Astley","Rick Roll", true);
                enclosingFrame.setVisible(false);
            }
        }
    }
}
