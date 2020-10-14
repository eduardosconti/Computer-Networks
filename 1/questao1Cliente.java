package tcp;

import java.io.DataOutputStream;
import java.net.*;
import java.util.Scanner;

public class questao1Cliente {

	public static void main(String[] args) {
		
		while (true) {
		int porta = 8877;
		String endereco = "localhost";
		
		System.out.println("Digite uma mensagem: ");
		Scanner in = new Scanner(System.in);
		String mensagem = in.nextLine();
		
		
			try {
				Socket socket = new Socket(endereco, porta);
				DataOutputStream saida= new DataOutputStream(socket.getOutputStream());
				saida.write(mensagem.getBytes());
				
				System.out.println("Mensagem enviada.");
				socket.close();
				
			} catch (ConnectException e) {
				System.out.println("N�o foi poss�vel chegar ao destinat�rio");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
