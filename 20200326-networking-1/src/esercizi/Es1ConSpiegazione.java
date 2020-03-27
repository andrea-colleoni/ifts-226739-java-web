package esercizi;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Es1ConSpiegazione {

	static int esito = 0;

	// !! modificato per verifica funzionamento GIT
	public static void main(String[] args) {
		ServerSocket serverSocket;
		try {
			// mi metto in ascolto sulla porta 9000
			serverSocket = new ServerSocket(9000);
			System.out.println("Server in ascolto sulla porta 9000");

			// per ogni client accettiamo una cnx e fabbrichiamo un socket
			
			while (esito >= 0) {
				Socket socket = serverSocket.accept();
				new Thread(() -> {
					try {
						System.out.println("Un client si è connesso!");
	
						PrintWriter pw = new PrintWriter(socket.getOutputStream());
						BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	
						esito = dialogo(pw, br);
						System.out.println("Il client si è disconnesso");
	
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
		pw.println("Scrivi il nome di un file dove salvare cio' che scriverai:");
		pw.flush();
		
		String fileName = br.readLine();
		PrintWriter fileW = new PrintWriter(new File(fileName));
		
		pw.println("Scrivi qualcosa, e io lo ripetero' (digita \"esci\" per uscire):");
		pw.flush();

		String stringaLetta = null;
		do {
			stringaLetta = br.readLine();
			System.out.println("Il client ha scritto => " + stringaLetta);

			pw.println("Alle " + new Date().toString() + " hai scritto => " + stringaLetta);
			pw.flush();
			
			fileW.println(stringaLetta);
		} while (!stringaLetta.contentEquals("esci") && !stringaLetta.contentEquals("quit"));

		fileW.close();

		return (stringaLetta.contentEquals("quit") ? -1 : 0);
	}


}
