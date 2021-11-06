package Client_Server;
import java.net.*; 

import java.io.*; 

import java.awt.image.*; 

import javax.imageio.*; 

import javax.swing.*; 

public class Server 

{ 

      public static void main(String args[]) throws Exception 

    { 

     ServerSocket server=null; 

     Socket socket; 

     server=new ServerSocket(4015); 

     System.out.println("Server Waiting for image"); 

     socket=server.accept();

	 System.out.println("Client connected."); 

     InputStream in = socket.getInputStream(); 

     DataInputStream dis = new DataInputStream(in); 

     int len = dis.readInt(); 

     System.out.println("Image Size: " + len/1024 + "KB"); byte[] data = new byte[len]; 

     dis.readFully(data); 

     dis.close(); 

     in.close(); 

     InputStream ian = new ByteArrayInputStream(data); 

     BufferedImage bImage = ImageIO.read(ian); //creating a buffered image object

     JFrame f = new JFrame("Server"); //create a window

     ImageIcon icon = new ImageIcon(bImage); //set as image

     JLabel l = new JLabel(); //creating a label

      l.setIcon(icon); //setting img as icon

      f.add(l); //add label to the frame

      f.pack(); //ready to display

      f.setVisible(true); 

  } 

} 