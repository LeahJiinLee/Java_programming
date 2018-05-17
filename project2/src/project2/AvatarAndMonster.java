package project2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GameThread extends Thread{
	private JLabel runner;
	private JLabel follower;
	private JLabel result;
	private JLabel monster_point;
	private final int follower_move = 5;
	
	
	public GameThread(JLabel runner, JLabel follower,  JLabel result, JLabel point) {
		this.runner= runner;
		this. follower = follower;
		
		this.result= result;
		this.monster_point = point;
	}
	public void run( ) {
		int x = follower.getX();
		int y= follower.getY();
		while (true) {
			result.setVisible(false);
			if (x>runner.getX()) {
				x=x- follower_move;
			}
			else 
				x+=follower_move;
			if (y>runner.getY())
				y-=follower_move;
			else 
				y+=follower_move;
			
			if (x==runner.getX() && y==runner.getY())
				{
			       result.setVisible(true);
				}
			
			follower.setLocation(x,y);
			monster_point.setText(Integer.toString(x)+","+Integer.toString(y));
			follower.getParent().repaint();
			
			
			try {
				
				sleep(200);
			}
			catch (InterruptedException e ) {return;}
		}
	}
}
public class AvatarAndMonster extends JFrame{

	private GameThread th;
	//private GamePanel panel= new GamePanel();
	private JLabel avatar;
	private JLabel monster;
	private JLabel result;
	private JLabel avatar_p;
	private JLabel monster_p;
	public AvatarAndMonster() {
		setTitle("지인 아바타와 몬스터 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new GamePanel());
		setSize(900,700);
		setVisible(true);
		th= new GameThread(avatar,monster,result,monster_p);
		th.start();
	}
	
	class GamePanel extends JPanel {
		
		private final int avatar_move=10;
		//int avatar_x, avatar_y;
		private ImageIcon icon = new ImageIcon("house.jpg");
		private Image background = icon.getImage();
		private ImageIcon ms= new ImageIcon("monster.png");
		private ImageIcon av = new ImageIcon("runner.png");
		private Image av_p = av.getImage();
		private Image ms_p = ms.getImage();
		
		public GamePanel() {
			setLayout(null);
			result= new JLabel("잡혔습니다");
			result.setForeground(new Color(0x00F15F5F));
			result.setFont(new Font("PLAIN", Font.BOLD, 30));
		    result.setSize(200,200);
		    result.setLocation(650,80);
		    add(result);
		    result.setVisible(false);
			avatar = new JLabel("a");
			avatar.setSize(15,15);
			avatar.setLocation(10,20);
			add(avatar);
			monster = new JLabel ("M");
			monster.setSize(30,30);
			monster.setLocation(200,300);
			add(monster);
			avatar_p= new JLabel("10,20");
			avatar_p.setFont(new Font("PLAIN", Font.BOLD, 13));
			avatar_p.setForeground(new Color(0x00F2CB61));
			avatar_p.setSize(50,80);
			
			avatar_p.setLocation(600,550 );
			add(avatar_p);
			monster_p = new JLabel("200,300");
			monster_p.setFont(new Font("PLAIN", Font.BOLD, 13));
			monster_p.setForeground(new Color(0x00E5D85C));
			monster_p.setSize(50,80);
			
			monster_p.setLocation(310,550);
			add(monster_p);
			MyKeyListener keyListener = new MyKeyListener();
			addKeyListener(keyListener);
			addMouseListener (new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					setFocusable(true);
					requestFocus();
				}
			});
			
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background,0,0,getWidth(),getHeight(),this);
			g.setColor(new Color(0x00B2CCFF));
			g.fillRoundRect(70, 30, this.getWidth()-120, 100, 40, 60);
			g.setColor(Color.BLACK);
			g.setFont(new Font("PLAIN", Font.BOLD, 40));
			g.drawString("WELCOME TO MONSTER AND AVATAR", 70, 100);
			
			g.drawImage(av_p, 500,this.getHeight()-100, 50,50,this);
			g.drawImage(ms_p, 240,this.getHeight()-100, 50,50,this);
			
		}
		class MyKeyListener extends KeyAdapter {
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch(keyCode) {
				case KeyEvent.VK_UP :
					avatar.setLocation(avatar.getX(), avatar.getY()-avatar_move);
					avatar_p.setText(Integer.toString(avatar.getX() )+","+ Integer.toString(avatar.getY()));
					break;
				case KeyEvent.VK_DOWN:
					avatar.setLocation(avatar.getX(), avatar.getY()+avatar_move);
					avatar_p.setText(Integer.toString(avatar.getX() )+","+ Integer.toString(avatar.getY()));
					break;
				case KeyEvent.VK_RIGHT:
					avatar.setLocation(avatar.getX()+avatar_move, avatar.getY());
					avatar_p.setText(Integer.toString(avatar.getX() )+","+ Integer.toString(avatar.getY()));
					break;
				case KeyEvent.VK_LEFT:
					avatar.setLocation(avatar.getX()-avatar_move, avatar.getY());
					avatar_p.setText(Integer.toString(avatar.getX() )+","+ Integer.toString(avatar.getY()));
					break;
				}
				avatar.getParent().repaint(); 
			}
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AvatarAndMonster();
	}

}
