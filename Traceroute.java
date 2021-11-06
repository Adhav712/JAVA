import java.io.*; 

import java.net.*; 

import java.lang.*; 

class Traceroute 

{ 

    public static void main(String args[]){ 

    BufferedReader in; 

    try{ 

            Runtime r   =   Runtime.getRuntime(); //getRuntime() method returns the runtime object associated with the current Java application. 

            Process p   =   r.exec("tracert www.google.com"); 

            in  =   new BufferedReader(new InputStreamReader(p.getInputStream())); 

            String line; 

            if(p==null) 

                System.out.println("could not connect"); 

            while((line=in.readLine())!=null){ 

                System.out.println(line); 

                //in.close(); 

            } 

        }catch(IOException e){ 

        System.out.println(e.toString()); 

        } 

    } 

} 