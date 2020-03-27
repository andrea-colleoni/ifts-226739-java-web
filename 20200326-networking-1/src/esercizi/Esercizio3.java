package esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Esercizio3 {
	
	static int esito = 0;
	static List<PrintWriter> clientWriters;

	// !! modificato per verifica funzionamento GIT
	public static void main(String[] args) {
		ServerSocket serverSocket;
		try {
			// mi metto in ascolto sulla porta 9000
			serverSocket = new ServerSocket(9000);
			clientWriters = new ArrayList<>();
			
			System.out.println("Server in ascolto sulla porta 9000");

			// per ogni client accettiamo una cnx e fabbrichiamo un socket

			while (esito >= 0) {
				Socket socket = serverSocket.accept();
				new Thread(() -> {
					try {
						System.out.println("Un client si è connesso!");

						PrintWriter pw = new PrintWriter(socket.getOutputStream());
						clientWriters.add(pw);
						BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

						esito = dialogo(pw, br);
						System.out.println("Il client si è disconnesso");

						br.close();
						pw.close();
						
						clientWriters.remove(pw);
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

	// in prima battuta, sviluppiamo un eco
	public static int dialogo(PrintWriter pw, BufferedReader br) throws IOException {
		pw.println("digita il tuo nickname (digita \"esci\" per uscire):");
		pw.flush();

		String stringaLetta = null;
		String nickName = null;
		do {
			stringaLetta = br.readLine();
			if (nickName == null) {
				nickName = stringaLetta;
				pw.println( "Benvenuto " + nickName + " (digita \"esci\" per uscire):");
				pw.flush();
				for(PrintWriter bCast : clientWriters) {
					if (bCast != pw) {
						bCast.println("*"  + nickName + "* e' entrato nella chat!");
						bCast.flush();
					}
				}
			} else {
				for(PrintWriter bCast : clientWriters) {
					if (bCast != pw) {
						bCast.println("[" + nickName +"]:  " + stringaLetta);
						bCast.flush();
					}
				}				
				System.out.println("[" + nickName +"]:  " + stringaLetta);
			}
		} while (!stringaLetta.contentEquals("esci") && !stringaLetta.contentEquals("quit"));
		// stringaLetta.contentEquals("esci") => è true quando stringaLetta è uguale a
		// esci
		// il ! nega il valore di verità della condizione

		return (stringaLetta.contentEquals("quit") ? -1 : 0);
	}

}
