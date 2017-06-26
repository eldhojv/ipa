package org.amplexus.speechdemo;

//import javax.sound.sampled.AudioFileFormat.Type;
import javax.sound.sampled.*;

import java.io.File;

import net.sourceforge.javaflacencoder.FLACFileWriter;

import com.darkprograms.speech.microphone.Microphone;
import com.darkprograms.speech.recognizer.Recognizer;
import com.darkprograms.speech.recognizer.GoogleResponse;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HelloWorld {

	private static final String FILENAME = "G:\\IPA\\Gresponse.txt"; // response
																		// recorded
																		// to a
																		// file
	Microphone mic = new Microphone(FLACFileWriter.FLAC);
	File file = new File("G:\\IPA workspace\\token\\files\\testfile2.flac");
	String response = "";

	/*
	 * public static void main (String[]args) {
	 * 
	 * // Mixer.Info[] infoArray = AudioSystem.getMixerInfo(); // for(Mixer.Info
	 * info : infoArray) { // System.out.println("info: " + info.toString()); //
	 * } AudioFileFormat.Type[] typeArray = AudioSystem.getAudioFileTypes();
	 * for(AudioFileFormat.Type type : typeArray) { System.out.println("type: "
	 * + type.toString()); }
	 * 
	 * 
	 * try { mic.captureAudioToFile (file); } catch (Exception ex) {
	 * 
	 * System.out.println ("ERROR: Microphone is not availible.");
	 * ex.printStackTrace (); }
	 * 
	 * 
	 * try { System.out.println ("Recording..."); Thread.sleep (5000); //5 sec
	 * delay mic.close (); } catch (InterruptedException ex) {
	 * ex.printStackTrace (); }
	 * 
	 * mic.close (); System.out.println ("Recording stopped.");
	 * 
	 * Recognizer recognizer = new Recognizer (Recognizer.Languages.ENGLISH_US,
	 * System.getProperty("AIzV0"));
	 * 
	 * try { int maxNumOfResponses = 4; System.out.println("Sample rate is: " +
	 * (int) mic.getAudioFormat().getSampleRate()); GoogleResponse response =
	 * recognizer.getRecognizedDataForFlac (file, maxNumOfResponses, (int)
	 * mic.getAudioFormat().getSampleRate ()); System.out.println
	 * ("Google Response: " + response.getResponse ()); System.out.println
	 * ("Google is " + Double.parseDouble (response.getConfidence ()) * 100 +
	 * "% confident in" + " the reply"); System.out.println
	 * ("Other Possible responses are: "); for (String
	 * s:response.getOtherPossibleResponses ()) { System.out.println ("\t" + s);
	 * } //try ending edited
	 * 
	 * 
	 * 
	 * 
	 * // writing responses to a file try (BufferedWriter bw = new
	 * BufferedWriter(new FileWriter(FILENAME))) { String Gcontent; Gcontent =
	 * new String( response.getResponse ()); bw.write(Gcontent); // no need to
	 * close it. //bw.close(); System.out.println("wrote to file");
	 * 
	 * } catch (IOException e) {
	 * 
	 * e.printStackTrace(); } } // end of writing responses to a file catch
	 * (Exception ex) {
	 * 
	 * System.out.println ("ERROR: Google cannot be contacted");
	 * ex.printStackTrace (); }
	 * 
	 * 
	 * 
	 * file.deleteOnExit (); }
	 */

	public void startRecording() {
		AudioFileFormat.Type[] typeArray = AudioSystem.getAudioFileTypes();
		for (AudioFileFormat.Type type : typeArray) {
			System.out.println("type: " + type.toString());
		}

		Microphone mic = new Microphone(FLACFileWriter.FLAC);
		File file = new File("G:\\IPA workspace\\token\\files\\testfile2.flac");
		try {
			mic.captureAudioToFile(file);
		} catch (Exception ex) {

			System.out.println("ERROR: Microphone is not availible.");
			ex.printStackTrace();
		}
		System.out.println("Recording...");
	}

	public boolean processRecording() {
		mic.close();
		System.out.println("Recording stopped.");

		Recognizer recognizer = new Recognizer(Recognizer.Languages.ENGLISH_US,
				System.getProperty("AIzaSyCaKNrAO9InUj2uK7seY7RtAQBYymfLzV0"));

		try {
			int maxNumOfResponses = 4;
			System.out.println("Sample rate is: "
					+ (int) mic.getAudioFormat().getSampleRate());
			GoogleResponse response = recognizer.getRecognizedDataForFlac(file,
					maxNumOfResponses, (int) mic.getAudioFormat()
							.getSampleRate());
			if (response == null)
				return false;

			System.out.println("Google Response: " + response.getResponse());
			setResponse(response.getResponse());
			System.out.println("Google is "
					+ Double.parseDouble(response.getConfidence()) * 100
					+ "% confident in" + " the reply");
			System.out.println("Other Possible responses are: ");
			for (String s : response.getOtherPossibleResponses()) {
				System.out.println("\t" + s);
			}
			// try ending edited

			// writing responses to a file
			try (BufferedWriter bw = new BufferedWriter(
					new FileWriter(FILENAME))) {
				String Gcontent;
				Gcontent = new String(response.getResponse());
				bw.write(Gcontent);
				// no need to close it.
				// bw.close();
				System.out.println("wrote to file");

			} catch (IOException e) {

				e.printStackTrace();
				return false;
			}
		}
		// end of writing responses to a file
		catch (Exception ex) {

			System.out.println("ERROR: Google cannot be contacted");
			ex.printStackTrace();
			return false;
		}

		file.deleteOnExit();
		return true;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}