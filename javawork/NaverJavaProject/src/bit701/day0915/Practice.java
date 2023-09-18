package bit701.day0915;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Practice extends JFrame{
	JButton[] btn=new JButton[5];
	String[] buttonTitle= {"연에인","음식","동물","차","쇼핑"};
	String initImage="D:\\naver0829\\image\\Moon1.png";
	Image image;
	MyCanvas myCanvas=new MyCanvas();

	public Practice(String title) {
		// TODO Auto-generated constructor stub
		super(title);//JFrame의 문자열을 받는 생성자 호출
		this.setLocation(300, 100);//프레임의 시작 위치
		this.setSize(500, 600);//프레임의 너비, 높이
		//this.getContentPane().setBackground(Color.green);//Color 상수를 이용해서 변경
		//this.getContentPane().setBackground(new Color(200,255,180));//0~255의 RGB

		//디자인이나 이벤트를 구현 할 메서드 호출
		this.setDesign();

		this.setVisible(true);//true: 프레임을 보이게 하기, false: 프레임 숨기기

		//윈도우 이벤트 발생 - 익명 내부 클래스 형태로 이벤트 구현
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { //x 버튼 클릭시 호출되는 메서드
				// TODO Auto-generated method stub
				//JOptionPane.showMessageDialog(SwingGibon.this, "프레임을 종료합니다");
				//실제 종료
				System.exit(0);//정상 종료
				super.windowClosing(e);
			}
		});
	}

	//캔버스 내부 클래스
	class MyCanvas extends Canvas
	{
		//처음 시작 시 자동 호출, 그리고 프레임 크기 변경 시에도 자동 호출 된다
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			//System.out.println(image.getWidth(this));
			if(image.getWidth(this)>=300)
				g.drawImage(image, 60, 10, 370, 450, this);
			else //300 미만 너비를 가진 이미지는 원래 사이즈 대로 출력
				g.drawImage(image, 60, 10, this);
		}
	}

	//배열 버튼 이벤트를 위한 내부 클래스
	class MyButton implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for(int i=0;i<btn.length;i++)
			{
				int x=(int)(Math.random()*8)+1;
				int y=(int)(Math.random()*34)+1;
				String z=".jpg";

				if(y==24) 
					z=".gif";

				String imageCeleb="D:\\naver0829\\image\\연예인사진\\20.jpg";
				String imageFood="D:\\naver0829\\image\\음식사진\\8.jpg";
				String imageAnimal="D:\\naver0829\\image\\이쁜동물이미지\\C"+x+".png";
				String imageCar="D:\\naver0829\\image\\mycar\\mycar2.png";
				String imageShop="D:\\naver0829\\image\\shop\\"+y+z;

				//사진을 Image로 변환
				Image image1=new ImageIcon(imageCeleb).getImage();
				Image image2=new ImageIcon(imageFood).getImage();
				Image image3=new ImageIcon(imageAnimal).getImage();
				Image image4=new ImageIcon(imageCar).getImage();
				Image image5=new ImageIcon(imageShop).getImage();

				Image[] buttonImage= {image1,image2,image3,image4,image5};

				if(e.getSource()==btn[i])
				{
					image=new ImageIcon(buttonImage[i]).getImage();
				}
			}
			myCanvas.repaint();	
		}
	}

	private void setDesign() {
		// TODO Auto-generated method stub
		JPanel p=new JPanel();
		for(int i=0;i<btn.length;i++)
		{
			btn[i]=new JButton(buttonTitle[i]);

			//버튼 이벤트 발생
			btn[i].addActionListener(new MyButton());
		}

		for(int i=0;i<btn.length;i++)
		{
			p.add(btn[i]);
		}

		this.add("North", p);

		//레이아웃 변경
		image = new ImageIcon(initImage).getImage();
		this.add("Center", myCanvas);	
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practice s=new Practice("사진 고르기");
	}
}