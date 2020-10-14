package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class questao3Servidor {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		DatagramSocket serverSocket = new DatagramSocket(8888);

		
		while(true) {
			byte[] receberDados = new byte[1024];
			byte[] enviarDados;
			InetAddress ipCliente;
			int porta;
			DatagramPacket receberPacote = new DatagramPacket(receberDados, receberDados.length);
			serverSocket.receive(receberPacote);
			byte[] a = receberPacote.getData();
			String str = new String(a, StandardCharsets.UTF_8);
			System.out.println(str);
			ipCliente = receberPacote.getAddress();
			porta = receberPacote.getPort();

			while (!str.contains("Tchau")) {
				enviarDados = (str.getBytes());
				DatagramPacket enviarPacotes = new DatagramPacket(enviarDados, enviarDados.length, ipCliente, porta);
				serverSocket.send(enviarPacotes);
				break;
			}
			
			enviarDados = ("Adeus".getBytes());
			DatagramPacket enviarPacotes = new DatagramPacket(enviarDados, enviarDados.length, ipCliente, porta);
			serverSocket.send(enviarPacotes);
			
		}
		
		
	}

}
