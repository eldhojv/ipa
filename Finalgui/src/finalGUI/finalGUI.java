package finalGUI;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import org.amplexus.speechdemo.HelloWorld;

import performaction.Action;
import tts.TextToSpeech;
import fileFind.TfIdfMain;

public class finalGUI {
	int flag=0;
	HelloWorld hw = new HelloWorld();
	JTextArea googleResponse = new JTextArea(5,2);
	JTextArea ipaResponse = new JTextArea(5,2);
	TfIdfMain reponseProcessor = new TfIdfMain();
	Action act = new Action();
	TextToSpeech speechProcessor = new TextToSpeech();

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					finalGUI window = new finalGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public finalGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Intelligent Personal  Asssistant and Knowledge Navigator");
		frame.setBackground(UIManager.getColor("Button.disabledForeground"));
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBounds(100, 400, 860, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBackground(UIManager.getColor("Button.darkShadow"));
		Image img = new ImageIcon("G:/IPA workspace/ipaicon.png").getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(1, 1, 490, 470);
		frame.getContentPane().add(label);
		
		final JButton btnNewButton = new JButton("");
		Image img1 = new ImageIcon("G:/IPA workspace/rec.png").getImage();
		btnNewButton.setIcon(new ImageIcon(img1));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setEnabled(false);
				startRecording();
			}
			
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setForeground(SystemColor.controlShadow);
		btnNewButton.setBounds(470, 15, 150, 100);
		frame.getContentPane().add(btnNewButton);
		
		final JButton btnStop = new JButton("");
		btnStop.setForeground(Color.GRAY);
		btnStop.setBackground(Color.GRAY);
		Image img11 = new ImageIcon("G:/IPA workspace/stoprec.png").getImage();
		btnStop.setIcon(new ImageIcon(img11));
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setEnabled(true);
				stopRecording();
			}
			
		});
		btnStop.setBounds(650, 15, 140, 100);
		frame.getContentPane().add(btnStop);
		
		googleResponse.setBounds(470, 130, 348, 153);
		
	    googleResponse.setEditable(false);
		frame.getContentPane().add(googleResponse);
		
		ipaResponse.setBounds(470, 295, 348, 153);
		ipaResponse.setEditable(false);
		frame.getContentPane().add(ipaResponse);
		
	}
	
	private void startRecording() {
		hw.startRecording();
	}
	
	
	private void stopRecording() {
		boolean isSuccess = hw.processRecording();
		if(isSuccess) {
			String gRes=hw.getResponse();
			googleResponse.setText(gRes);
			
			try {
				if (gRes.toLowerCase().contains("Where")||gRes.toLowerCase().contains("which")||gRes.toLowerCase().contains("when")||gRes.toLowerCase().contains("what")||gRes.toLowerCase().contains("who")||gRes.toLowerCase().contains("why")||gRes.toLowerCase().contains("how"))
			    {
					reponseProcessor.processResponse(gRes); //change to processResponse
					flag=1;
			    }
				//reponseProcessor.processResponse(gRes); //change to processResponse
				
				else
				{
				act.processAction(gRes);
				flag=2;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(flag==1)
			{
			ipaResponse.setText(reponseProcessor.getIparesponse());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			speechProcessor.processSpeech(reponseProcessor.getIparesponse());
			}
			else if(flag==2)
			{
			ipaResponse.setText(act.getActResponse());	
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			speechProcessor.processSpeech(act.getActResponse());
			}
			
			
		}
		else {
			JOptionPane.showMessageDialog(frame, "Please try again as there are some problems connecting to internet");
		}
	}

	
	
}
