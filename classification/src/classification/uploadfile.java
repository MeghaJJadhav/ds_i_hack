package classification;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class uploadfile extends JFrame {

	private JPanel contentPane;
	public File file_path;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					uploadfile frame = new uploadfile();
				
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public uploadfile() {
		
		
		setTitle("upload file");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(213, 10, 10, 10);
		contentPane.add(panel);
		
		JButton btn = new JButton("upload file");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btn) {
					JFileChooser fileupload = new JFileChooser();
					fileupload.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					//fileupload.showOpenDialoag(null);
					int res = fileupload.showOpenDialog(null);
					
					if(res == JFileChooser.APPROVE_OPTION) {
						file_path = fileupload.getSelectedFile();
						ocr ocrObject = new ocr();
						ocrObject.fileSelected(file_path);
						//System.out.println(file_path);
					}
				}
				
				
			}
		});
		btn.setBounds(293, 140, 150, 23);
		contentPane.add(btn);
	}
}
