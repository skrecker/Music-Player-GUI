import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.io.*;

public class TagPanel extends JPanel{
	
	Tag[] tags = new Tag[11];
	TagButtonPanel tBP;
	
	BufferedImage tagIcon;
	
	boolean clear = true;

	int xPosition;
	int yPosition = 0;
	String tagNumber;

	public TagPanel(){
		super();
		try{
			tagIcon = ImageIO.read(new File("img/tag_icon.png"));
		}catch(IOException e){
		
		}
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(!clear){
			g.setColor(Color.BLACK);
			
		for(int i = 0; i<tags.length; i++){
			if(tags[i] != null){
				g.drawRect(tags[i].xPosition, 0, 8,8);
				
			    g.drawImage(tagIcon, tags[i].xPosition, 0, null);
				g.drawString(tags[i].value,tags[i].xPosition,0);
			}
		}
	
		}else{
			//draw a blank panel
		}

	}

	public void addTag(int time, int position){
		
		for(int i = 0; i<tags.length; i++){
			if(tags[i] == null){
				Tag tag = new Tag(i+1,time);
				tag.slidePosition = position;
				double temp = (double)position;
				temp = temp *.01;
				tag.xPosition = (int)(this.getWidth() * temp);
				tBP.buttonArray[i].setEnabled(true);
				Integer tempInt = new Integer(i);
				//tag.value = tempInt.toString();
				tag.value = "0";	
				tags[i] = tag;
				
				xPosition = time;
				break;
			}
	
		}

		drawTag();
	}

	public void setTagButtonPanel(TagButtonPanel tagButtonPanel){
		tBP = tagButtonPanel;
	}

	public void removeTag(int tagNumber){
		tags[tagNumber - 1] = null;
	}


	public void clearTags(){
		clear = true;
		for(int i = 0;i<10;i++){
			tags[i] = null;
		}
		tBP.disableButtons();
		this.repaint();
		
	}
	
	public void drawTag(){
		clear = false;	
		repaint();	
	}


}
