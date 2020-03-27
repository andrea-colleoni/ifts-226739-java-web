package esercizi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Es2ConSpiegazione {

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
		pw.println("Scrivi il nome del file da leggere:");
		pw.flush();
		
		String fileName = br.readLine();
		BufferedReader fileR = new BufferedReader(new FileReader(new File(fileName)));

		String stringaLetta = null;
		do {
			stringaLetta = fileR.readLine();
			System.out.println("Su file c'è scritto => " + stringaLetta);

			pw.println(stringaLetta);
			pw.flush();
		} while (stringaLetta != null);
		
		fileR.close();

		return 0;
	}

}
