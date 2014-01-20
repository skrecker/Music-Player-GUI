import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Music implements ActionListener {

 JFrame frm;
 CenterConsole infoDisplay; //holds the center display w/ info's
 ButtonControlPanel btnPanel; //holds play,rwd,ff buttons
 SharePanel sharePanel; //holds share related stuff
 JTextField search; //search textbox
 JButton collapse; //switches interface from full to compact
 JPanel topPanel;
 JPanel topRightPanel; //holds sharepanel and collapse btn
 BottomPanel bottomPanel;
 GridBagLayout gbag = new GridBagLayout();
 GridBagConstraints gbc = new GridBagConstraints();
 SearchPanel searchPanel;
 ImageIcon collapseIcon;
 ImageIcon expandIcon;
 String[] quickSearchArray;

  Music() {
//	window.setIconImage(Toolkit.getDefaultToolkit().getImage("img/collapse_icon.png"));
    frm = new JFrame("Music Player");
    //frm.setLayout(gbag);
    frm.setLayout(new VerticalLayout());
	frm.setBackground(Color.DARK_GRAY);
    frm.setSize(890,920);
	frm.getContentPane().setBackground(Color.DARK_GRAY); 
   //frm.setMinimumSize();
   // frm.setResizable(false);
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    topPanel = new JPanel();

    btnPanel = ButtonControlPanel.create();
    infoDisplay = CenterConsole.create();
    sharePanel = new SharePanel();
	
	collapseIcon = new ImageIcon("img/collapse_icon.png");
	expandIcon = new ImageIcon("img/expand_icon.png");    

	collapse = new JButton(collapseIcon);
    //collapse = new JButton("↑");
	//collapse.setIcon(collapseIcon);
	collapse.setActionCommand("collapse");
    collapse.setToolTipText("Switch to compact mode.");
    topRightPanel = new JPanel();
    JPanel p = new JPanel();
    bottomPanel = BottomPanel.create();


//TOP PANEL STUFF HERE --->
    topPanel.setLayout(new FlowLayout());
	topPanel.setBackground(Color.DARK_GRAY);

    infoDisplay.setBackground(Color.LIGHT_GRAY);

    collapse.setPreferredSize(new Dimension(60, 30));
    collapse.addActionListener(this);
    topPanel.add(btnPanel);
    topPanel.add(infoDisplay);

    topRightPanel.setLayout(new VerticalLayout());
    topRightPanel.add(sharePanel);

    p.setLayout(new FlowLayout());
	p.setBackground(Color.DARK_GRAY);
    p.add(collapse);
    topRightPanel.add(p);
    topPanel.add(topRightPanel);
	topRightPanel.setBackground(Color.DARK_GRAY);

    //gbc.gridx =0;
    //gbc.gridy =0;
    //gbag.setConstraints(topPanel, gbc);
    frm.add(topPanel);

//SEARCH PANEL STUFF HERE --->
		searchPanel = new SearchPanel();
		frm.add(searchPanel);


//BOTTOM PANEL STUFF HERE --->
    //gbc.gridx =0;
    //gbc.gridy = 1;
    //gbag.setConstraints(bottomPanel, gbc);
    frm.add(bottomPanel);
    frm.pack();

    frm.setVisible(true);
  //  TagPopupFrame f = new TagPopupFrame();
   // f.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("collapse")) {
      frm.remove(bottomPanel);
      searchPanel.setCollapseSearchVisible(true);
      frm.pack();
      collapse.setActionCommand("expand");
      collapse.setToolTipText("Switch to full mode.");
	  collapse.setIcon(expandIcon);
	
    }
    else if (e.getActionCommand().equals("expand")) {
      gbc.gridx =0;
      gbc.gridy = 1;
      gbag.setConstraints(bottomPanel, gbc);
      frm.add(bottomPanel);
      searchPanel.setCollapseSearchVisible(false);
      collapse.setToolTipText("Switch to compact mode.");
      frm.pack();
      collapse.setActionCommand("collapse");
	  collapse.setIcon(collapseIcon);
    }
  }
}

//Do we want to use a liquid layout?
