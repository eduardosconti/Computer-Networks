package tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

public class questao2Cliente {

	public static void main(String[] args) {
		int porta = 8877;
		while (true) {
		String endereco = "localhost";
		System.out.println("Digite uma mensagem: ");
		Scanner in = new Scanner(System.in);
		String mensagem = in.nextLine();
		
			try {
				Socket socket = new Socket(endereco, porta);
				socket.setReuseAddress(true);
				DataOutputStream saida= new DataOutputStream(socket.getOutputStream());
				saida.write(mensagem.getBytes());
				System.out.println("Mensagem enviada.");
				socket.close();
				ServerSocket tmpsocket = new ServerSocket(porta);
				tmpsocket.setReuseAddress(true);
				System.out.println("Aguardando servidor");
				Socket socket2 = tmpsocket.accept();		
				socket2.setReuseAddress(true);
				InputStreamReader entrada = new InputStreamReader(socket2.getInputStream());
				BufferedReader le = new BufferedReader(entrada);
				String resposta = le.readLine();
				while (resposta!="null") {
				}
				System.out.println("Servidor: " + resposta);
				socket2.close();
				
			} catch (ConnectException e) {
				System.out.println("Não foi possível chegar ao destinatário");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}

