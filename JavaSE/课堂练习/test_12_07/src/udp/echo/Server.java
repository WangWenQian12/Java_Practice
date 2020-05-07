package udp.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {

    //服务器端

    public static void main(String[] args) throws IOException {
        // 1. 新建一个 DatagramSocket
        DatagramSocket udpServerSocket = new DatagramSocket(9898);//在本机起一个端口，端口号为9898，可通过此端口接收消息

        while (true) {//不断接收消息
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(
                    receiveBuffer,
                    receiveBuffer.length);

            udpServerSocket.receive(receivePacket);//接收消息

            InetAddress clientAddress = receivePacket.getAddress();//对方的地址
            System.out.printf("我从 %s:%d  收到了消息%n",
                    clientAddress.getHostAddress(),//返回ip地址
                    receivePacket.getPort());//返回的端口号
            System.out.printf("我一共收到了 %d 字节的数据%n", receivePacket.getLength());

            //将数据包中的全部内容由字节转为字符
            String message = new String(
                    receivePacket.getData(),
                    0,
                    receivePacket.getLength(),
                    "UTF-8");
            System.out.println(message);

            //给客户端回消息（回的消息和接收到的消息一样）
            byte[] sendBuffer = message.getBytes("UTF-8");
            DatagramPacket sendPacket = new DatagramPacket(
                    sendBuffer,
                    sendBuffer.length,
                    clientAddress,
                    receivePacket.getPort()
            );

            udpServerSocket.send(sendPacket);
        }

        //udpServerSocket.close();
    }
}
