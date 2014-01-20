//this panel is the center panel that contains the info of the current track playing.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

class CenterConsole extends JPanel {
  JLabel artistLabel; //artist
  JLabel titleLabel; //song name
  JLabel albumLabel; //album title
  JButton setTagButton; //button to set tag
  JLabel timeNowLabel; //shows current time in track
  JLabel totTimeLabel; //shows total time in track
  JSlider trackTimeSlider; //shows current time position in song
  //trackTime can maybe be a JSlider

  TagButtonPanel tagButtonPanel; //holds buttons for tags
  TagPanel tagPanel; //holds the visual tags
  Track currentTrack;


  private CenterConsole() {

    setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
    setLayout(new GridBagLayout()); //set layout
    initComponents(); //initialize components
    //set size
    Dimension size = new Dimension(400,150); //dimension of panel
    this.setPreferredSize(size); //set size of panel
	this.setBackground(Color.DARK_GRAY);
  }
  private static CenterConsole centerconsole;
  	

	public void initComponents(){
		artistLabel = new JLabel("Analogtronics");
		artistLabel.setForeground(Color.BLACK);

		titleLabel = new JLabel("Time Leak");
		titleLabel.setForeground(Color.BLACK);
		
		albumLabel = new JLabel("Union");
		albumLabel.setForeground(Color.BLACK);

		setTagButton = new JButton("Tag");

		timeNowLabel = new JLabel("0:00");
		
		timeNowLabel.setForeground(Color.BLACK);

		totTimeLabel = new JLabel("      2:30");
		totTimeLabel.setForeground(Color.BLACK);
		
		trackTimeSlider = new JSlider(0,100); //initializes JProgressBar to 0 until a track is linked up
		trackTimeSlider.setValue(0);
		tagButtonPanel = new TagButtonPanel();
		tagPanel = new TagPanel();
		tagPanel.setPreferredSize(new Dimension(trackTimeSlider.getWidth()-5,150));
		tagPanel.setBackground(Color.LIGHT_GRAY);
		tagButtonPanel.setTagPanel(tagPanel);
		tagButtonPanel.setSlider(trackTimeSlider);
		tagPanel.setTagButtonPanel(tagButtonPanel);
		Dimension dim = new Dimension(500,150);
		tagPanel.setPreferredSize(dim);
		GridBagConstraints c = new GridBagConstraints();

	//add artistLabel
		c.gridx = 3;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;

		this.add(artistLabel,c);

	//add titleArtist
		c.gridx = 3;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(titleLabel,c);

	//add albumLabel
		c.gridx = 3;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(albumLabel,c);

	//add setTagButton
		c.gridx = 4;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(setTagButton,c);


	//add timeNowLabel
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = .2;
		this.add(timeNowLabel,c);

	//add trackTimeSlider
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.weightx = .6;
		c.anchor = GridBagConstraints.LINE_END;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(trackTimeSlider,c);

	//add totTimeLabel
		c.gridx = 4;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.LINE_END;
		c.weightx = .2;
		this.add(totTimeLabel,c);

	//add tagPanel
		c.gridx = 1;
		c.gridy = 4;
		c.gridheight = 1;
		c.weightx = .9;
		c.gridwidth = 3;
		//Insets padding = new Insets(0,15,0,15);
		//c.insets = padding;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(tagPanel,c);

	//add tagButtonPanel
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 5;
		c.gridheight = 1;
		c.weightx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(tagButtonPanel,c);

	//adds listeners to CenterConsole

		setTagButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//tag the current point in the tracki
				tagPanel.addTag(trackTimeSlider.getValue(), trackTimeSlider.getValue());
                                TagPopupFrame f = new TagPopupFrame();
                                f.setVisible(true);
			}
		});

		trackTimeSlider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				//updates timeNowLabel as track progresses
				//timeNowLabel.setText(trackTimeSlider.toValue().toString());
				//timeNowLabel = trackTimeSlider.getValue();

			}
		});


	}

	public void changeCenterInfo(Track t){
		currentTrack = t;

		titleLabel.setText(t.title);

		if(t.artist != null){
			artistLabel.setText(t.artist);
		}else{
			artistLabel.setText("");
		}

		if(t.album != null){
			albumLabel.setText(t.album);
		}else{
			albumLabel.setText("");
		}

		trackTimeSlider.setValue(t.totalTime);
		//set totTimeLabel with the length of the track
	}

        public static CenterConsole create() {
                   if (centerconsole == null) {
                       centerconsole = new CenterConsole();
                   }
                 return centerconsole;

        }

  public static CenterConsole getInstance() {
    return centerconsole;
  }

   public void getNote(String n){
          String note = n;
   }

   public void setPlaySong() {
	 trackTimeSlider.setValue(0);
     BottomPanel b = BottomPanel.getInstance();
     String[] info = b.getSongToPlay();
     titleLabel.setText(info[0]);
     artistLabel.setText(info[1]);
     albumLabel.setText(info[2]);
		//tagPanel.clearTags();	
   }

	public void setNextSong(){

	 trackTimeSlider.setValue(0);
     BottomPanel b = BottomPanel.getInstance();
     String[] info = b.getNextSongToPlay();
     titleLabel.setText(info[0]);
     artistLabel.setText(info[1]);
     albumLabel.setText(info[2]);

	}
	
	public void setPreviousSong(){

	 trackTimeSlider.setValue(0);
     BottomPanel b = BottomPanel.getInstance();
     String[] info = b.getPreviousSongToPlay();
     titleLabel.setText(info[0]);
     artistLabel.setText(info[1]);
     albumLabel.setText(info[2]);
	}
}
