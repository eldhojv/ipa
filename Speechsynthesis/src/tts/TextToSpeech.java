package tts;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;


public class TextToSpeech {
	private static final String VOICENAME = "kevin16";
	public void processSpeech(String text) {
		  Voice voice;
		  VoiceManager vm = VoiceManager.getInstance();
		  voice = vm.getVoice(VOICENAME);
		  voice.allocate(); 
		  try
		  {
		   voice.speak(text);
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
	}
}