package tcp;

import java.io.*;
import java.net.*;
import java.util.Calendar;

public class questao1Servidor {

	public static void main(String[] args) {
		
		while(true)	{
			while(true) {
				int porta = 8877;
				long t = System.currentTimeMillis();
				long end = t+10000;
				
					try {
						ServerSocket tmpsocket = new ServerSocket(porta);
						System.out.println("Aguardando cliente");
						Socket socket = tmpsocket.accept();
						
						while(t<end) {
							t = System.currentTimeMillis();
							InputStreamReader entrada = new InputStreamReader(socket.getInputStream());
							BufferedReader le = new BufferedReader(entrada);
							String resposta = le.readLine();
							if (resposta.equals("null")) {
								continue;
							} else {
								if (t<end) {
									System.out.println("Cliente: " + resposta);
								} else {
									break;
								}
							}
						}
						System.out.println("Tempo excedido");
						break;
					} catch (BindException e) {
					} catch (Exception e) {
					}
						
			} 
			
		}
	}

}
