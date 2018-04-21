
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuans
 */
class ServerThread extends Thread{
    Socket socket=null;
    String name=null;
    public ServerThread(Socket socket){
        this.socket=socket;
        name=socket.getInetAddress().getHostName();
        System.out.println("Client from "+name+" connected!");
    }
    static void copy(InputStream in, OutputStream out) throws IOException {
        byte[] buf = new byte[8192];
        int len = 0;
        while ((len = in.read(buf)) != -1) {
            out.write(buf, 0, len);
        }
    }
    public void run(){
        try {
            InputStream in=new FileInputStream("mail_send.png");
            OutputStream out= socket.getOutputStream();
            copy(in,out);
            System.out.println("Sended file to client");
            in.close();
            out.close();
            socket.close();
            return;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss=new ServerSocket(9999);
            System.out.println("Waiting for client...");
            Socket sk=ss.accept();
            Thread t=new ServerThread(sk);
            t.start();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
// public class SocketFileExample {
//  static void server() throws IOException {
//    ServerSocket ss = new ServerSocket(3434);
//    Socket socket = ss.accept();
//    InputStream in = new FileInputStream("send.jpg");
//    OutputStream out = socket.getOutputStream();
//   copy(in, out);
//   out.close();
//  static void client() throws IOException {
//    Socket socket = new Socket("localhost", 3434);
//    InputStream in = socket.getInputStream();
//    OutputStream out = new FileOutputStream("recv.jpg");
//   copy(in, out);
//   out.close();
