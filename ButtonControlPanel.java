//this panel holds the rewind, play, fastForward, Shuffle and Repeat Buttons

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ButtonControlPanel extends JPanel {
 JButton play; //play button
 JButton rewind; //rewind button
 JButton fastForward; //fast forward button
 JButton shuffle; //toggles shuffle
 JButton repeat; //toggles repeat
 JSlider volumeSlider; //controls volume
 JLabel volString;
 JLabel muteLabel, volumeFullLabel;;
 ImageIcon playIcon, fastForwardIcon, rewindIcon, repeatIcon, shuffleIcon, pauseIcon, repeatingIcon, shufflingIcon;
 ImageIcon hoverPlayIcon, hoverFastForwardIcon, hoverRewindIcon, hoverRepeatIcon, hoverShuffleIcon, hoverPauseIcon, hoverRepeatingIcon, hoverShufflingIcon;
 ImageIcon volumeMuteIcon, volumeFullIcon;
 boolean isPaused = true;
 boolean isRepeating = false;
 boolean isShuffling = false;
private static ButtonControlPanel controlPanel;
	
 ButtonControlPanel() {
    //setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
   // this.setLayout(new GridLayout(2,3)); //layout for panel
    this.setLayout(new FlowLayout());
    Dimension size = new Dimension(190,150); //dimension of panel
    this.setPreferredSize(size); //set size of panel
	this.setBackground(Color.DARK_GRAY);
    
	rewindIcon = new ImageIcon("img/rewind_button.png");
	hoverRewindIcon = new ImageIcon("img/hover_rewind_button.png");

	playIcon = new ImageIcon("img/play_button.png");
	hoverPlayIcon = new ImageIcon("img/hover_play_button.png"); 

	pauseIcon = new ImageIcon("img/pause_button.png");
	hoverPauseIcon = new ImageIcon("img/hover_pause_button.png");
	
	fastForwardIcon = new ImageIcon("img/fast_forward_button.png");
	hoverFastForwardIcon = new ImageIcon("img/hover_fastforward_button.png");

	repeatIcon = new ImageIcon("img/repeat_button.png");
	hoverRepeatIcon = new ImageIcon("img/hover_repeat_button.png");
	repeatingIcon = new ImageIcon("img/repeating_icon.png");
	hoverRepeatingIcon = new ImageIcon("img/hover_repeating_icon.png");

	shuffleIcon = new ImageIcon("img/shuffle_button.png");
	hoverShuffleIcon = new ImageIcon("img/hover_shuffle_button.png");
	shufflingIcon = new ImageIcon("img/shuffling_icon.png");
	hoverShufflingIcon = new ImageIcon("img/hover_shuffling_icon.png");

	volumeMuteIcon = new ImageIcon("img/mute_image.png");
	volumeFullIcon = new ImageIcon("img/full_volume_image.png");

	this.add(rewind = new JButton());
	rewind.setIcon(rewindIcon);
	rewind.setOpaque(false);
	rewind.setContentAreaFilled(false);
	rewind.setBorderPainted(false);
	Dimension rewindSize = new Dimension(rewindIcon.getIconWidth(), rewindIcon.getIconHeight());
	rewind.setPreferredSize(rewindSize);

    this.add(play = new JButton());
	play.setIcon(playIcon);
	play.setOpaque(false);
	play.setContentAreaFilled(false);
	play.setBorderPainted(false);
	Dimension playSize = new Dimension(playIcon.getIconWidth(), playIcon.getIconHeight());
	play.setPreferredSize(playSize);

    this.add(fastForward = new JButton());
	fastForward.setIcon(fastForwardIcon);
	fastForward.setOpaque(false);
	fastForward.setContentAreaFilled(false);
	fastForward.setBorderPainted(false);
	fastForward.setPreferredSize(rewindSize);

    this.add(repeat = new JButton());
	repeat.setIcon(repeatIcon);
	repeat.setOpaque(false);
	repeat.setContentAreaFilled(false);
	repeat.setBorderPainted(false);
	
    this.add(shuffle = new JButton());
	shuffle.setIcon(shuffleIcon);
	shuffle.setOpaque(false);
	shuffle.setContentAreaFilled(false);
	shuffle.setBorderPainted(false);

    volumeSlider = new JSlider(0,100);
    volumeSlider.setPreferredSize(new Dimension(80,35));
	muteLabel = new JLabel(volumeMuteIcon);
	//muteLabel.setPreferredSize(new Dimension(volumeMuteIcon.getIconWidth(), volumeMuteIcon.getIconHeight()));
	volumeFullLabel = new JLabel(volumeFullIcon);
	//volumeFullLabel.setPreferredSize(new Dimension(volumeFullIcon.getIconWidth(), volumeFullIcon.getIconHeight()));

    JPanel p = new JPanel();
	p.add(muteLabel);
    p.add(volumeSlider);
	p.add(volumeFullLabel);
//  p.add(volString = new JLabel("Volume"));
    p.setLayout(new FlowLayout());
	p.setBackground(Color.DARK_GRAY);

    this.add(p);
    this.setBorder(BorderFactory.createEtchedBorder());

    play.setToolTipText("Play loaded song");
    rewind.setToolTipText("Play previous song, Hold to rewind");
    fastForward.setToolTipText("Play next song, Hold to Fast Forward");
    shuffle.setToolTipText("Shuffle loaded playlist");
    repeat.setToolTipText("Repeat current playlist");

	//Add Mouse Listeners to Buttons
	play.addMouseListener(new MouseListener(){
		public void mousePressed(MouseEvent e){
			if(isPaused){
				play.setIcon(playIcon);
				play.setToolTipText("Pause song");
				isPaused = false;
	//		        CenterConsole c = CenterConsole.getInstance();
	//		        c.setPlaySong();
			}else{
				play.setToolTipText("Play loaded song");
				play.setIcon(pauseIcon);
				isPaused = true;
			}
		}
		
		public void mouseReleased(MouseEvent e){
			if(isPaused){
				play.setIcon(hoverPlayIcon);
			}else{
				play.setIcon(hoverPauseIcon);
			}
		}

		public void mouseEntered(MouseEvent e){
			if(isPaused){
				play.setIcon(hoverPlayIcon);	
			}else{
				play.setIcon(hoverPauseIcon);
			}
		}

		public void mouseExited(MouseEvent e){
			if(isPaused){
				play.setIcon(playIcon);
			}else{
				play.setIcon(pauseIcon);
			}
		}

		public void mouseClicked(MouseEvent e){
			//add play functionality
		}

	});

	rewind.addMouseListener(new MouseListener(){
		public void mousePressed(MouseEvent e){
			CenterConsole c = CenterConsole.getInstance();
			c.setPreviousSong();
			rewind.setIcon(rewindIcon);
		}
		
		public void mouseReleased(MouseEvent e){
			rewind.setIcon(hoverRewindIcon);
		}

		public void mouseEntered(MouseEvent e){
			rewind.setIcon(hoverRewindIcon); //sets hovered image	
		}

		public void mouseExited(MouseEvent e){
			rewind.setIcon(rewindIcon); //sets non-hovered image
		}

		public void mouseClicked(MouseEvent e){
			//select previous song
		}

	});
	
	fastForward.addMouseListener(new MouseListener(){
		public void mousePressed(MouseEvent e){
			fastForward.setIcon(fastForwardIcon);
				
			CenterConsole c = CenterConsole.getInstance();
			c.setNextSong();
		}
			
		public void mouseReleased(MouseEvent e){
			fastForward.setIcon(hoverFastForwardIcon);
		}

		public void mouseEntered(MouseEvent e){
			fastForward.setIcon(hoverFastForwardIcon);	
		}

		public void mouseExited(MouseEvent e){
			fastForward.setIcon(fastForwardIcon);
		}

		public void mouseClicked(MouseEvent e){

		}
	});

	repeat.addMouseListener(new MouseListener(){
		public void mousePressed(MouseEvent e){
			if(isRepeating){
				repeat.setIcon(repeatingIcon);
				isRepeating = false;
			}else{
				repeat.setIcon(repeatIcon);
				isRepeating = true;
			}
				
			if(isShuffling){
				shuffle.setIcon(shuffleIcon);
				isShuffling = false;
			}
		}
		
		public void mouseReleased(MouseEvent e){
			if(isRepeating){
				repeat.setIcon(hoverRepeatingIcon);
			}else{
				repeat.setIcon(hoverRepeatIcon);
			}
		}

		public void mouseEntered(MouseEvent e){
			if(isRepeating){
				repeat.setIcon(hoverRepeatingIcon);
			}else{
				repeat.setIcon(hoverRepeatIcon);
			}
		}

		public void mouseExited(MouseEvent e){
			if(isRepeating){
				repeat.setIcon(repeatingIcon);
			}else{
				repeat.setIcon(repeatIcon);
			}
		}

		public void mouseClicked(MouseEvent e){

		}
	});

	shuffle.addMouseListener(new MouseListener(){
		public void mousePressed(MouseEvent e){
			if(isShuffling){
				shuffle.setIcon(shufflingIcon);
				isShuffling = false;
			}else{
				shuffle.setIcon(shuffleIcon);
				isShuffling = true;
			}
			if(isRepeating){
				repeat.setIcon(repeatIcon);
				isRepeating = false;
			}
				
		}
		
		public void mouseReleased(MouseEvent e){
			if(isShuffling){
				shuffle.setIcon(hoverShufflingIcon);
			}else{
				shuffle.setIcon(hoverShuffleIcon);
			}
		}

		public void mouseEntered(MouseEvent e){
			if(isShuffling){
				shuffle.setIcon(hoverShufflingIcon);
			}else{
				shuffle.setIcon(hoverShuffleIcon);
			}
		}

		public void mouseExited(MouseEvent e){
			if(isShuffling){
				shuffle.setIcon(shufflingIcon);
			}else{
				shuffle.setIcon(shuffleIcon);
			}
		}

		public void mouseClicked(MouseEvent e){

		}
	});
  }

	public static ButtonControlPanel create(){
		if(controlPanel == null){
			controlPanel =  new ButtonControlPanel();
		}
		return controlPanel;
	}

	public static ButtonControlPanel getInstance(){
		return controlPanel;
	}	
 
}

/*
NEEDS LISTENERS FOR all of the buttons here
NEEDS DIFF LAYOUT
NEEDS FIXED SIZE
*/
