package esercizi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Esercizio2 {

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

	// in prima battuta, sviluppiamo un eco
	public static int dialogo(PrintWriter pw, BufferedReader br) throws IOException {
		pw.println("digita il nome di un file (digita \"esci\" per uscire):");
		pw.flush();

		String stringaLetta = null;
		String fileName = null;
		FileReader fileR = null;
		stringaLetta = br.readLine();
		fileName = stringaLetta;
		fileR = new FileReader(new File(fileName));
		pw.println("File " + fileName + " aperto in lettura");
		
		BufferedReader fileBr = new BufferedReader(fileR);
		String lettaDaFile = fileBr.readLine();
		while (lettaDaFile != null) {
			pw.println(lettaDaFile);
			pw.flush();

			lettaDaFile = fileBr.readLine();
		}

		fileR.close();
		return 0;
	}

}
