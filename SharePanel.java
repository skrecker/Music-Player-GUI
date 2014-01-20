//this panel holds share-related components

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SharePanel extends JPanel implements ActionListener {
  JButton shareIt;
  JCheckBox autoShare;
  JLabel likesIcon;
  JLabel likesHere;
  JPanel likes;
  JTextField search;
  GridBagLayout gbag = new GridBagLayout();
  GridBagConstraints gbc = new GridBagConstraints();
  FacebookFrame fb;

  SharePanel() {
   //setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
   //this.setLayout(new GridLayout(3,1)); //layout for panel
   this.setLayout(gbag); //layout for panel
   this.setBackground(Color.DARK_GRAY);
   Dimension size = new Dimension(150,100);
   this.setPreferredSize(size);
   shareIt = new JButton("Share");
   gbc.gridx =0;
   gbc.gridy =0;
   gbc.anchor = GridBagConstraints.NORTHWEST;
   gbag.setConstraints(shareIt, gbc);
   this.add(shareIt);
   shareIt.setToolTipText("Share this song!");
   shareIt.addActionListener(this);

   autoShare = new JCheckBox("Auto-Share");
   gbc.gridx =0;
   gbc.gridy =1;
   gbc.anchor = GridBagConstraints.WEST;
   gbag.setConstraints(autoShare, gbc);
   this.add(autoShare);
    autoShare.setToolTipText("Auto-share every song played");

   //here i compacted the "likes" stuff into a jpanel to fit it in same cell
   ImageIcon likeThumb = new ImageIcon("img/like.gif");
   likes = new JPanel();
   likes.setBackground(Color.DARK_GRAY);
	
   likes.setLayout(new FlowLayout());
   likes.add(likesIcon = new JLabel(likeThumb));
   likes.add(likesHere = new JLabel("9 Likes"));
   gbc.gridx =0;
   gbc.gridy =2;
   gbag.setConstraints(likes, gbc);
   this.add(likes);

   search = new JTextField(8);
   search.setText("Search..");
/*   search.addMouseListener(new MouseListener(){
	   public void mouseClicked(MouseEvent e){
	     search.setText("");
	   }
   });*/
   gbc.gridx =0;
   gbc.gridy=3;
   gbag.setConstraints(search, gbc);
   search.setActionCommand("search");
    this.setBorder(BorderFactory.createEtchedBorder());
   //this.add(search);
  }
  public void actionPerformed(ActionEvent e){
         if (e.getActionCommand().equals("Share")){
            fb = new FacebookFrame();
         }
  }
}
