import java.awt.*;
import javax.swing.*;


public class App extends JFrame
{
	
	static JTabbedPane tp;
	static JPanel panel, addressPanel, bodyPanel;
	static int width, height;
	static JButton back, forward, reload, search;
	static JTextField addressField;
	
	
	
	App()
	{
		
		Toolkit toolkit= Toolkit.getDefaultToolkit();
		Dimension screenSize= toolkit.getScreenSize();
		width= (int) screenSize.getWidth();
		height= (int) screenSize.getHeight();
		
		
		//tabbedpane and panels setup
		tp= new JTabbedPane();
		add(tp);
		
		
		panel= new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		tp.add(panel);
		
		
		//addressPanel setup
		addressPanel= new JPanel();
		addressPanel.setBackground(Color.YELLOW);
		addressPanel.setPreferredSize(new Dimension(width, 70));
		addressPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
		panel.add(addressPanel);
		
		back= new JButton("<-");
		back.setPreferredSize(new Dimension(50,40));
		addressPanel.add(back);		
		
		forward= new JButton("->");
		forward.setPreferredSize(new Dimension(50,40));
		addressPanel.add(forward);
		
		reload= new JButton("R");
		reload.setPreferredSize(new Dimension(50,40));
		addressPanel.add(reload);
		
		addressField= new JTextField();
		addressField.setPreferredSize(new Dimension(3*width/4, 40));
		addressPanel.add(addressField);
		
		search= new JButton("Q");
		search.setPreferredSize(new Dimension(50,40));
		addressPanel.add(search);
		
		
		
		//body panel setup
		bodyPanel= new JPanel();
		bodyPanel.setBackground(Color.GREEN);
		panel.add(bodyPanel);
		
		
		
		
		//frame setup
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width,height);
	}
}
