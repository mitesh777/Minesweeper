package Board;
import javax.swing.*;  
public class BoardUI {
	public BoardUI(){
		//please
		//System.out.println("Enter number of");
		JFrame f=new JFrame();//creating instance of JFrame  
		int width = 30;int height = 30;
        for(int i=0;i<8;i++) {
        	JTextField t1;  
   		 	t1 = new JTextField(i);  
   		 	t1.setBounds(10+i*width,10, width,height);  
   		 	f.add(t1);
        }
		//JButton b=new JButton("click");//creating instance of JButton  
		//b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
		          
		//f.add(b);//adding button in JFrame  
		
		f.setSize(400,500);//400 width and 500 height  
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible  	
		
	}
}
