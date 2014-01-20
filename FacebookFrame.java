import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class FacebookFrame extends JFrame implements ActionListener{
    JPanel loginPanel;
    JLabel fblogo;
    ImageIcon pic = new ImageIcon("img/fblogo.png");
    JTextField user;
    JPasswordField pass;
    JButton login;
    JButton cancel;

  FacebookFrame(){
    this.setLayout(new VerticalLayout());
    JPanel panel = new JPanel();  
    panel.setLayout(new FlowLayout());
    this.setSize(330,150);
    fblogo = new JLabel("");
    fblogo.setIcon(pic);
    panel.add(fblogo);

    loginPanel = new JPanel();
    loginPanel.setLayout(new GridLayout(0,1));
    loginPanel.add(new JLabel("Facebook Username:"));
    user = new JTextField(15);
    loginPanel.add(user);
    loginPanel.add(new JLabel("Password:"));
    pass = new JPasswordField(15);
    loginPanel.add(pass);

    JPanel btns = new JPanel();
    btns.setLayout(new FlowLayout());
    btns.add(login = new JButton("Login"));
    btns.add(cancel= new JButton("Cancel"));
    cancel.addActionListener(this);


    panel.add(loginPanel);
    this.add(panel);
    this.add(btns);
    panel.setBorder(BorderFactory.createEtchedBorder());
    this.pack();
    this.setResizable(false);
    this.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
     if (e.getActionCommand().equals("Cancel"))
	     this.setVisible(false);
  }
}
