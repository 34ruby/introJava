package TestFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class pokemonShock extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Disco frame = new Disco();
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
	public pokemonShock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					while(true) {
						getContentPane().setBackground(Color.RED);
						Thread.sleep(10);
						getContentPane().setBackground(Color.BLUE);
						Thread.sleep(10);
						getContentPane().setBackground(Color.YELLOW);
						Thread.sleep(10);
						getContentPane().setBackground(Color.ORANGE);
						Thread.sleep(10);
						getContentPane().setBackground(Color.BLACK);
						Thread.sleep(10);
						getContentPane().setBackground(Color.GREEN);
						Thread.sleep(10);
						getContentPane().setBackground(Color.WHITE);
						Thread.sleep(10);
						getContentPane().setBackground(Color.PINK);
						Thread.sleep(10);
					}
				}
				catch(Exception e) {}
			}
		});
		t.start();
	}

}
