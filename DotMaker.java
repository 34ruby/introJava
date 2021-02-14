import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyButton extends JButton {

	public MyButton(String string) {
		// TODO Auto-generated constructor stub
	}
	
}


public class Dot extends JFrame implements ActionListener {
	
	MyButton[] buttons;
	MyButton colorChange, reset;
	JPanel[] previewDot;
	JPanel colorPreview;
	int colorR = 255;
	int colorG = 255;
	int colorB = 255;
	
	public Dot() {
		
		super("Pixel Image Maker - by 34ruby");
		
		// 버튼 영역
		colorChange = new MyButton("색상변경");
		reset = new MyButton("초기화");
		colorPreview = new JPanel();
		
		// 버튼 패널
		JPanel settingPanel = new JPanel(new FlowLayout());
		settingPanel.add(colorChange);
		settingPanel.add(colorPreview);
		settingPanel.add(reset);
		settingPanel.setBackground(Color.yellow);
		settingPanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2.0f)));
		
		
		// colorChange, reset = button / colorPreview = panel 버튼에 들어감
		colorChange.addActionListener(this);
		reset.addActionListener(this);
		colorChange.setBackground(new Color(255,255,255));
		reset.setBackground(new Color(255, 255, 255));
		colorPreview.setBackground(new Color(colorR, colorG, colorB));
		colorPreview.setPreferredSize(new Dimension(80,26));
		colorPreview.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2.0f)));

		// 미리보기 임시 패널
		JPanel previewPanel = new JPanel();
		previewPanel.setOpaque(true);
		previewPanel.setLayout(new GridLayout(20,20,0,0));
		previewPanel.setPreferredSize(new Dimension(200,200));
		
		
		// 미리보기 패널에 들어감
		previewDot = new JPanel[400];
		
		for (int i = 0; i < 400; i++) {
			previewDot[i] = new JPanel();
			previewDot[i].setPreferredSize(new Dimension(10,10));
			previewDot[i].setBackground(new Color(255, 255, 255));
		}
		for (int i = 0; i < 400; i++) {
			previewPanel.add(previewDot[i]);
		}
		previewPanel.setBackground(Color.yellow);
		previewPanel.setOpaque(true);
		
		
		// 미리보기 패널 
		JPanel goPanel = new JPanel();
		goPanel.setPreferredSize(new Dimension(200,200));
		goPanel.add(previewPanel);
		
		// 작업영역 패널
		JPanel drawingPanel = new JPanel();
		drawingPanel.setLayout(new GridLayout(20,20,0,0));
		
		
		// 작업 영역
		buttons = new MyButton[400];
		
		for (int i = 0; i < 400; i++) {
		
			buttons[i] = new MyButton("");
			buttons[i].setPreferredSize(new Dimension(20,20));
			buttons[i].setBackground(new Color(colorR, colorG, colorB));
		
		}
		for (int i = 0; i < 400; i ++) {
			drawingPanel.add(buttons[i]);

		}
		for (int i = 0; i <400; i++) {
			buttons[i].addActionListener(this);
	
		}
		add(drawingPanel, BorderLayout.CENTER);


		//미리보기 패널, 버튼패널, 작업영역 패널 묶는 패널
		JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
		mainPanel.add(BorderLayout.CENTER, settingPanel);
		mainPanel.add(BorderLayout.NORTH, drawingPanel);
		mainPanel.add(BorderLayout.SOUTH, goPanel);
		
		// 묶은 패널을 프레임에 넣음
		setLayout(new FlowLayout(FlowLayout.CENTER, 20,20));
		setPreferredSize(new Dimension(450,750));
		add(mainPanel);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		//색깔바꾸기
		if (e.getSource() == colorChange) {
			Color selectColor = JColorChooser.showDialog(this, "색상변경", Color.white);
		    if(selectColor != null) {

		       } else { 
		    	   selectColor = new Color(colorR, colorG, colorB);
		       }
		       colorR = selectColor.getRed();
		       colorG = selectColor.getGreen();
		       colorB = selectColor.getBlue();
		       
		    colorPreview.setBackground(new Color(colorR, colorG, colorB));
		}
		//초기화
		if (e.getSource() == reset) {
			for (int i = 0; i < 400; i++) {
				buttons[i].setBackground(new Color(255, 255, 255));
				previewDot[i].setBackground(new Color(255, 255, 255));
			}
		} 
		// 그림입력
		for (int i = 0; i < buttons.length; i++) {
			if (e.getSource() == buttons[i]) {
				buttons[i].setBackground(new Color(colorR, colorG, colorB));
				previewDot[i].setBackground(new Color(colorR, colorG, colorB));
			}
		}

	}	

	
	public static void main(String[] args) {
		new Dot();

	}

}
