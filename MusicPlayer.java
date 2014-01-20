import javax.sound.sampled.*;
import java.io.*;
import sun.audio.*;
import java.io.FileInputStream;

public class MusicPlayer{
	static Mixer.Info[] mixerInfo;
	static Mixer mixer;
	static Line.Info[] lineInfo;
	TargetDataLine targetLine;
	SourceDataLine sourceLine;

	public MusicPlayer(){
	//	setMixer();
	}

//Sets the first available audio Mixer
	public void setMixer(){
/*		try{
			mixerInfo = AudioSystem.getMixerInfo();
			mixer = AudioSystem.getMixer(mixerInfo[0]);
			mixerInfo.toString();
		}catch(IllegalArgumentException e){
			e.printStackTrace();
		}
*/
	}
/*
	public void setTargetDataLine(){
		DataLine.Info info = new DataLine.Info(TargetDataLine.class,format);
		if(!AudioSystem.isLineSupported(info)){

		}
		
		try{
			line = (TargetDataLine) AudioSystem.getLine(info);
			line.open(format);

		}catch(LineUnavailableException ex){

		}
	
	}		

	public void setSourceDataLine(){
		DataLine.Info info = new DataLine.Info(SourceDataLine.class,format);
		if(!AudioSystem.isLineSupported(info)){

		}
		
		try{
			line = (SourceDataLine) AudioSystem.getLine(info);
			line.open(format);

		}catch(LineUnavailableException ex){

		}
	
	}
*/
	
/*Comments

Steps to getting sound to play

-Getting a line of a Desired time
	

-Obtain a clip
-Contruct a DataLine.Info object with Clip.class
	-Pass the DataLine.Info as an argument to the getLine() method of AudioSystem or Mixer
-Reserve Clip for programs exclusive use
	-void open(AudioInputStream stream)
	-void open(AudioFormat format, byte[] data, int offset, int bufferSize)

-Clip's setFramePosition() to start the audio at a certain point, otherwise it will start at the beginning
	-start() will be called to start audio or continue playing after stop() method
	-stop() will ve called when the audio needs to be paused or stopped

-A clip's volume can be controlled with DataLine's method 
*/

}
