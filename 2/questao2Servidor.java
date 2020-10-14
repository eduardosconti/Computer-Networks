package tcp;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class questao2Servidor {

	public static void main(String[] args) {
		int porta = 8877;
		
	while(true)	{
		String endereco = "localhost";
		Scanner in = new Scanner(System.in);
				
		try {
			ServerSocket tmpsocket = new ServerSocket(porta);
			tmpsocket.setReuseAddress(true);
			System.out.println("Aguardando cliente");
			Socket socket = tmpsocket.accept();
			socket.setReuseAddress(true);
			InputStreamReader entrada = new InputStreamReader(socket.getInputStream());
			BufferedReader le = new BufferedReader(entrada);
			String resposta = le.readLine();
			while(resposta=="null") {
				
			}
			System.out.println("Cliente: " + resposta);
			socket.close();
			String mensagem = in.nextLine();
			Socket socket2 = new Socket(endereco, porta);			
			socket2.setReuseAddress(true);
			DataOutputStream saida= new DataOutputStream(socket2.getOutputStream());
			saida.write(mensagem.getBytes());
			System.out.println("Mensagem enviada.");
			socket2.close();
			
			} catch (BindException e) {
			} catch (Exception e) {
			}						
			} 
			
		}
	}

