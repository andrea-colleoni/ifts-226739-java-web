package esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Es3ConSoluzione {
	static int esito = 0;
	static List<PrintWriter> outputStreamConnessi;

	public static void main(String[] args) {
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(9000);
			outputStreamConnessi = new ArrayList<>();
			System.out.println("Server in ascolto sulla porta 9000");

			while (esito >= 0) {
				Socket socket = serverSocket.accept();
				new Thread(() -> {
					try {
						System.out.println("Un client si è connesso!");
	
						PrintWriter pw = new PrintWriter(socket.getOutputStream());
						BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	
						outputStreamConnessi.add(pw);
						
						esito = dialogo(pw, br);
						System.out.println("Il client si è disconnesso");
						
						outputStreamConnessi.remove(pw);
	
						br.close();
						pw.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}).start();
			}

			System.out.println("Il server è stato chiuso");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int dialogo(PrintWriter pw, BufferedReader br) throws IOException {
		pw.println("Scrivi il tuo nickname:");
		pw.flush();
		
		String nickName = br.readLine();
		
		pw.println("Benvenuto "  + nickName + "!\n\r(digita \"esci\" per uscire)");
		pw.flush();

		for(PrintWriter clientW : outputStreamConnessi) {
			if (clientW != pw) {
				clientW.println("[" + nickName + "]: è entrato nella chat");
				clientW.flush();
			}
		}
		
		String stringaLetta = null;
		do {
			stringaLetta = br.readLine();
			System.out.println("Il client ha scritto => " + stringaLetta);

			for(PrintWriter clientW : outputStreamConnessi) {
				if (clientW != pw) {
					clientW.println("[" + nickName + "]: " + stringaLetta);
					clientW.flush();
				}
			}
		} while (!stringaLetta.contentEquals("esci") && !stringaLetta.contentEquals("quit"));

		for(PrintWriter clientW : outputStreamConnessi) {
			if (clientW != pw) {
				clientW.println("[" + nickName + "]: ha abbandonato la chat");
				clientW.flush();
			}
		}
		
		return 0;
	}

}
