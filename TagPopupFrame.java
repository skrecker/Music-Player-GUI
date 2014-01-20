import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


//    .setToolTipText("asdf");

class TagPopupFrame extends JFrame implements ActionListener{
    JPanel loginPanel;
    JTextArea note;
    JButton login;
    JButton cancel;
    CenterConsole c = CenterConsole.getInstance();

  TagPopupFrame(){
    this.setLayout(new VerticalLayout());
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());
    this.setSize(330,150);

    JLabel text = new JLabel("Add a note?");
    panel.add(text);

    loginPanel = new JPanel();
    loginPanel.setLayout(new GridLayout(0,1));
    note = new JTextArea(5,30);
    loginPanel.add(note);

    JPanel btns = new JPanel();
    btns.setLayout(new FlowLayout());
    btns.add(login = new JButton("Add Note."));
    btns.add(cancel= new JButton("No Note, Just Tag."));

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
     if (e.getActionCommand().equals("No Note, Just Tag.")){
	     this.setVisible(false);
      }

      if (e.getActionCommand().equals("Add Note.")){
           String s = note.getText();
           c.getNote(s);
      }



  }
}
