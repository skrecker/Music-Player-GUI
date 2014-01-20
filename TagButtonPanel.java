import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TagButtonPanel extends JPanel{
	
	JButton[] buttonArray = new JButton[11];

	JButton tagButton1;
	JButton tagButton2;
	JButton tagButton3;
	JButton tagButton4;
	JButton tagButton5;
	JButton tagButton6;
	JButton tagButton7;
	JButton tagButton8;
	JButton tagButton9;
	JButton tagButton10;
	JButton removeButton;
	TagPanel tagPanel;
	JSlider jSlider;
	int currentButtonNumber;
	FlowLayout layout = new FlowLayout();
	ImageIcon disabledTag;
	ImageIcon enabledTag;

	public TagButtonPanel(){
		layout.setHgap(0);
		this.setLayout(layout);
		initComponents();
		setBackground(Color.LIGHT_GRAY);
		
	}

	public void initComponents(){
		Dimension buttonSize = new Dimension(30,30);
		Font font = UIManager.getFont("Button.font");
		int buttonStyle = font.getStyle();

		disabledTag = new ImageIcon("img/disabled_tag_background.png");
		enabledTag = new ImageIcon("img/enabled_tag_background.png");
		//Insets inset = new Insets(20,20,20,20); 
		
		Font buttonFont = new Font("buttonFont",buttonStyle, 8); 
	
		tagButton1= new JButton("1");
//		tagButton1.setIcon(disabledTag);
//		tagButton1.setOpaque(false);
//		tagButton1.setContentAreaFilled(false);
//		tagButton1.setBorderPainted(false);
//		tagButton1.setPreferredSize(buttonSize);
		tagButton1.setEnabled(false);
		tagButton1.setFont(buttonFont);
		buttonArray[0] = tagButton1;
		
		tagButton2 = new JButton("2");
//		tagButton2.setIcon(disabledTag);
//		tagButton2.setOpaque(false);
//		tagButton2.setContentAreaFilled(false);
//		tagButton2.setBorderPainted(false);
//		tagButton2.setPreferredSize(buttonSize);
		tagButton2.setEnabled(false);
		tagButton2.setFont(buttonFont);
		buttonArray[1] = tagButton2;

		tagButton3 = new JButton("3");
//		tagButton3.setIcon(disabledTag);
//		tagButton3.setOpaque(false);
//		tagButton3.setContentAreaFilled(false);
//		tagButton3.setBorderPainted(false);
	//	tagButton3.setPreferredSize(buttonSize);
		tagButton3.setEnabled(false);
		tagButton3.setFont(buttonFont);
		buttonArray[2] = tagButton3;

		tagButton4 = new JButton("4");
		//tagButton4.setPreferredSize(buttonSize);
		tagButton4.setEnabled(false);
		tagButton4.setFont(buttonFont);
		buttonArray[3] = tagButton4;

		tagButton5 = new JButton("5");
	//	tagButton5.setPreferredSize(buttonSize);
		tagButton5.setEnabled(false);
		tagButton5.setFont(buttonFont);
		buttonArray[4] = tagButton5;

		tagButton6 = new JButton("6");
		//tagButton6.setPreferredSize(buttonSize);
		tagButton6.setEnabled(false);
		tagButton6.setFont(buttonFont);
		buttonArray[5] = tagButton6;

		tagButton7 = new JButton("7");
		//tagButton7.setPreferredSize(buttonSize);
		tagButton7.setEnabled(false);
		tagButton7.setFont(buttonFont);
		buttonArray[6] = tagButton7;

		tagButton8 = new JButton("8");
		//tagButton8.setPreferredSize(buttonSize);
		tagButton8.setEnabled(false);
		tagButton8.setFont(buttonFont);
		buttonArray[7] = tagButton8;

		tagButton9 = new JButton("9");
		//tagButton9.setPreferredSize(buttonSize);
		tagButton9.setEnabled(false);
		tagButton9.setFont(buttonFont);
		buttonArray[8] = tagButton9;

		tagButton10 = new JButton("10");
		//tagButton10.setPreferredSize(buttonSize);
		tagButton10.setEnabled(false);
		tagButton10.setFont(buttonFont);
		buttonArray[9] = tagButton10;

		removeButton = new JButton();
		ImageIcon removeTagIcon = new ImageIcon("img/remove_tag_icon.png");
		removeButton.setIcon(removeTagIcon);
		removeButton.setBackground(Color.DARK_GRAY);
		//removeButton.setPreferredSize(buttonSize);
		removeButton.setFont(buttonFont);
		buttonArray[10] = removeButton;

		add(tagButton1);
		add(tagButton2);
		add(tagButton3);
		add(tagButton4);
		add(tagButton5);
		add(tagButton6);
		add(tagButton7);
		add(tagButton8);
		add(tagButton9);
		add(tagButton10);
		add(removeButton);

		
		tagButton1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer
				moveSlider(1);
				currentButtonNumber = 1;		
			}
		});
	
		tagButton2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
				moveSlider(2);		
				currentButtonNumber = 2;
			}
		});
		
		tagButton3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
				moveSlider(3);		
				currentButtonNumber = 3;
			}
		});
		
		tagButton4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
				moveSlider(4);		
				currentButtonNumber = 4;
			}
		});

		tagButton5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
				moveSlider(5);		
				currentButtonNumber = 5;
			}
		});
		tagButton6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
				moveSlider(6);		
				currentButtonNumber = 6;
			}
		});
		
		tagButton7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
				moveSlider(7);		
				currentButtonNumber = 7;
			}
		});

		tagButton8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
				moveSlider(8);		
				currentButtonNumber = 8;
			}
		});

		tagButton9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
				moveSlider(9);		
				currentButtonNumber = 9;
			}
		});

		tagButton10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
				moveSlider(10);		
				currentButtonNumber = 10;
			}
		});

		removeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tagPanel.clearTags();				
			}
		});
		
	}
	
	public void setTagPanel(TagPanel tP){
			this.tagPanel = tP;
	}
	
	public void setSlider(JSlider jS){
			this.jSlider = jS;
	}

	public void disableButtons(){
		tagButton1.setEnabled(false);
		tagButton2.setEnabled(false);
		tagButton3.setEnabled(false);
		tagButton4.setEnabled(false);
		tagButton5.setEnabled(false);
		tagButton6.setEnabled(false);
		tagButton7.setEnabled(false);
		tagButton8.setEnabled(false);
		tagButton9.setEnabled(false);
		tagButton10.setEnabled(false);
	}
	public void moveSlider(int buttonNumber){
		if(tagPanel.tags[buttonNumber-1] != null){
			jSlider.setValue(tagPanel.tags[buttonNumber-1].slidePosition);	
		}
	}

}
