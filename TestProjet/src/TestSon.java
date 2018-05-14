import java.applet.Applet;
import java.io.File;
import java.net.URL;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class TestSon {
	
		public static void main(String[] args) throws Exception {
			
			String musicFile = "Duck.mp3";     // For example

			Media sound = new Media(new File(musicFile).toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(sound);
			mediaPlayer.play();
			
			
			
			/*URL url = TestSon.class.getResource("Musique_Nathan_Tanina_Theo.wav");
			java.applet.AudioClip clip = Applet.newAudioClip(url);
			java.applet.AudioClip clip2 = Applet.newAudioClip(url);
			clip.play();
			Thread.sleep(1000);
			clip2.loop();
			Thread.sleep(20000);
			clip2.stop();
			
			System.out.println("end");*/

	}	
		
		
		
		
		
	
	/*public static void main(String args) {
		File son = new File("Duck.mp3");
		AudioClip clip = null;

		clip.play();
		
		AudioClip s = new AudioClip("Duck.mp3");
		s.play();
		
		
		
		Media sound = new Media(new File("TestProjet/src/Duck.mp3").toURI().toString());
		MediaPlayer player = new MediaPlayer(sound);
		player.play();
		
		URL resource = getClass().getResource("Duck.mp3");
		Media media = new Media(resource.toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
	    mediaPlayer.play();
	    
	    
	}
	
	public static synchronized void playSound(final String url) {
		  new Thread(new Runnable() {
		  // The wrapper thread is unnecessary, unless it blocks on the
		  // Clip finishing; see comments.
		    public void run() {
		      try {
		        Clip clip = AudioSystem.getClip();
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
		          Main.class.getResourceAsStream("/path/to/sounds/" + url));
		        clip.open(inputStream);
		        clip.start(); 
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		    }
		  }).start();
		}*/
	


 
	
}
