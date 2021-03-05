package shapedraw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MoreShapes extends JFrame {
	
	public MoreShapes() {
		setSize(600, 150);
		setTitle("안녕!!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new MyPanel();
		add(panel);
		setVisible(true);
	}
	// 프레임 구현 !
	
	public static void main(String[] args) {
		new MoreShapes();
	}
	// ㄲㄲㄲㄲㄲㄲ

}

class MyPanel extends JPanel {
	ArrayList<Shape> shapeArray = new ArrayList<Shape>();
	// Shape 객체를 저장하는 ArrayList 배열
	
	public MyPanel() {
		Shape s;
		// s라는 이름의 Shape 타입의 참조 변수 정의
		
		s = new Rectangle2D.Float(10,10,80,80);
		shapeArray.add(s);
		//도형은 x좌표, y좌표, 가로길이, 세로길이 순
		
		s = new RoundRectangle2D.Float(110, 10, 80, 80, 30, 60);
		shapeArray.add(s);
		// 맨 뒤 두개는 둥근 정도를 나타냄
		// 5번째가 가로의 둥근 정도, 마지막이 세로의 둥근 정도... 변형을 통해 색다른 모양 구현 가능.
		
		s = new Ellipse2D.Float(210, 10, 80, 80);
		shapeArray.add(s);
		// 타원
		
		s = new Arc2D.Float(310, 10, 80, 80, 90, 90, Arc2D.OPEN);
		shapeArray.add(s);
		// 호, 마지막 두개는 각도로 치면 90도에서 시작하여 +90도 (사분면이 기준이다) 이동
		// Arc2D.OPEN은 열린 호를 그리기 위함
		
		s = new Arc2D.Float(410, 10, 80, 80, 0, 180, Arc2D.CHORD);
		shapeArray.add(s);
		// CHORD은 닫힌 호를 그리기 위함. 이 그림에서는 0도에 해당하는 점과 180를 이동한 곳에 해당하는 점을 잇는다.
		
		s = new Arc2D.Float(510, 10, 80, 80, 45, 90, Arc2D.PIE);
		shapeArray.add(s);
		// PIE는 CHORD과는 달리, 구현되지 않은 가상의 원의 중심을 기준으로 파이 조각 모양을 만들어준다.
		// 이걸 Chord로 구현한다면, 45도에 해당하는 점과 90도를 이동한 135도에 해당하는 점을 바로 이어버린다.
		
	}
	
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
//		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//안티엘리어싱 : 도형이 매끄러워 짐 지우면 확실히 작업물의 픽셀이 두드러진다.
		g2.setColor(Color.GREEN);
		g2.setStroke(new BasicStroke(5));
		for (Shape s : shapeArray) {
			g2.draw(s);
		}
//		shapeArray 배열에 있는 변수 s의 자료를 불러오고 차례로 그린다.
			
	}

}

