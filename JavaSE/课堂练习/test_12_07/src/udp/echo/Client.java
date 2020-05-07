package udp.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

    //客户端

    public static void main(String[] args) throws IOException {
        DatagramSocket udpClientSocket = new DatagramSocket();//客户端无需绑定端口号
        String message = "好的";
        byte[] sendBuffer = message.getBytes("UTF-8");//转为字节形式

        // 127.0.0.1（对方ip地址）
        byte[] serverIP = new byte[4];
        serverIP[0] = (byte)192;    // (byte)127
        serverIP[1] = (byte)168;    // 0
        serverIP[2] = (byte)0;      // 0
        serverIP[3] = (byte)196;    // 1
        InetAddress serverAddress = InetAddress.getByAddress(serverIP);//对方的ip地址
        DatagramPacket sendPacket = new DatagramPacket(
                sendBuffer,
                sendBuffer.length,
                serverAddress,//对方的ip地址
                9898 //对方的端口号
        );
        udpClientSocket.send(sendPacket);//发送报文

        // 接受对方回应的消息
        byte[] receiveBuffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(
                receiveBuffer, receiveBuffer.length);
        udpClientSocket.receive(receivePacket);
        String responseMessage = new String(
                receivePacket.getData(),
                0,
                receivePacket.getLength(),
                "UTF-8"
        );
        System.out.println(responseMessage);

        udpClientSocket.close();
    }
}
