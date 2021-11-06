package Client_Server;

import javax.imageio.*; 

import java.io.*; 

import java.net.*;

import java.awt.image.BufferedImage; 

import java.io.ByteArrayOutputStream; 

import java.io.File; 

import java.io.IOException; 

import javax.imageio.ImageIO; 

public class Client 

{ 

    public static void main(String args[]) throws Exception 

   { 

   Socket soc = null; 

    BufferedImage img = null; 

    soc=new Socket("localhost",4015); 

    System.out.println("Client is running. "); 

    try 

   { 

     System.out.println("Reading image from disk. "); 

     img = ImageIO.read(new File("C:\\Users\\kathiravan\\Desktop\\profile.jpg")); //reading img

     ByteArrayOutputStream baos = new ByteArrayOutputStream(); //create obj to read img as bytes

     ImageIO.write(img, "jpg", baos); //read the img as bytes

     baos.flush(); 

     byte[] bytes = baos.toByteArray(); //converted to bytearray

     baos.close(); 

     System.out.println("Sending image to server. "); 

     OutputStream out = soc.getOutputStream(); //for sending img to server

     DataOutputStream dos = new DataOutputStream(out); 

     dos.writeInt(bytes.length); //sent the length of img

     dos.write(bytes, 0, bytes.length); //sent the img

     System.out.println("Image sent to server. "); 

     dos.close(); 

     out.close(); 

    } 

     catch (Exception e) 

    { 

     System.out.println("Exception: " + e.getMessage()); 

     soc.close(); 

    } 

    soc.close(); 

  } 

} 