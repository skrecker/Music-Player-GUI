//this panel holds the rewind, play, fastForward, Shuffle and Repeat Buttons

import javax.swing.*;
import java.awt.*;

class ButtonPanel extends JPanel {
 JButton play; //play button
 JButton rewind; //rewind button
 JButton fastForward; //fast forward button
 JButton shuffle; //toggles shuffle
 JButton repeat; //toggles repeat
 JSlider volumeSlider; //controls volume
 JLabel volString;

 ButtonPanel() {
    //setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
   // this.setLayout(new GridLayout(2,3)); //layout for panel
    this.setLayout(new FlowLayout());
    Dimension size = new Dimension(190,110); //dimension of panel
    this.setPreferredSize(size); //set size of panel
    this.add(rewind = new JButton("<<"));
    this.add(play = new JButton(">")); 
    this.add(fastForward = new JButton(">>"));
    this.add(repeat = new JButton("R"));
    this.add(shuffle = new JButton("S"));
    volumeSlider = new JSlider(0,100);
    volumeSlider.setPreferredSize(new Dimension(180,45));
    this.add(volumeSlider);
    this.add(volString = new JLabel("Volume"));
    this.setBorder(BorderFactory.createEtchedBorder());
 }
}

/*
NEEDS LISTENERS FOR all of the buttons here 
NEEDS DIFF LAYOUT
NEEDS FIXED SIZE
*/


