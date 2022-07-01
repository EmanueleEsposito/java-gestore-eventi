package jana60gestore_eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("Benvenuto!");
		boolean valido = true;

		do {
			System.out.println("L'evento è una conferenza? si/no");
			String sceltaUtente = scan.nextLine();
			switch (sceltaUtente) {
			case "si":
				// titolo
				System.out.println("Inserisci il titolo dell'evento: ");
				String titoloEvento = scan.nextLine();
				// data
				System.out.println("Quando vuoi organizzare questo evento?");
				System.out.println("giorno: ");
				int giornoEvento = scan.nextInt();

				System.out.println("mese: ");
				int meseEvento = scan.nextInt();

				System.out.println("anno: ");
				int annoEvento = scan.nextInt();
				LocalDate dataEvento = LocalDate.of(annoEvento, meseEvento, giornoEvento);
				// Argomento
				System.out.println("Inserisci l'argomento: ");
				String argomentoInput = scan.nextLine();
				// Oratore
				System.out.println("Chi è l'oratore?");
				System.out.println("Inserisci il nome: ");
				String nomeOratore = scan.nextLine();
				System.out.println("Inserisci il cognome: ");
				String cognomeOratore = scan.nextLine();
				System.out.println("Inserisci il titolo: ");
				String titoloOratore = scan.nextLine();
				Oratore nuovoOratore = new Oratore(nomeOratore, cognomeOratore, titoloOratore);
				Evento nuovoEventoConferenza = new Evento(titoloOratore, dataEvento, meseEvento, annoEvento);
			}

		} while (!valido);

		// titolo
		System.out.println("Inserisci il titolo dell'evento: ");
		String titoloEvento = scan.nextLine();
		// data
		System.out.println("Quando vuoi organizzare questo evento?");
		System.out.println("giorno: ");
		int giornoEvento = scan.nextInt();

		System.out.println("mese: ");
		int meseEvento = scan.nextInt();

		System.out.println("anno: ");
		int annoEvento = scan.nextInt();
		LocalDate dataEvento = LocalDate.of(annoEvento, meseEvento, giornoEvento);

		// posti totali
		System.out.println("Inserisci il numero di posti totali: ");
		int postiTotaliEvento = scan.nextInt();

		// posti prenotati
		System.out.println("Inserisci il numero di posti prenotati: ");
		int postiPrenotatiEvento = scan.nextInt();

		try {

			Evento nuovoEvento = new Evento(titoloEvento, dataEvento, postiTotaliEvento, postiPrenotatiEvento);
			System.out.println(nuovoEvento);
			System.out.println("Cosa vuoi fare ora?");
			boolean sceltaValida = false;
			do {
				System.out.print("Vuoi aggiungere una prenotazione? si/no ");
				String sceltaUtente = scan.nextLine();
				switch (sceltaUtente) {
				case "si":
					System.out.println("Inserisci quanti posti vuoi prenotare: ");
					int postiUtente = scan.nextInt();
					int postiDisponibili = nuovoEvento.getNumeroPostiTotali() - postiUtente;
					System.out.println("Il totale dei posti prenotati è: " + nuovoEvento.prenota(postiUtente));
					System.out.println("Il totale dei posti disponibili è: " + postiDisponibili);

					sceltaValida = false;
					break;
				case "no":
					System.out.println("Grazie per averci scelto e arrivederci");
					sceltaValida = true;
					break;
				}

			} while (!sceltaValida);
			boolean sceltaValida1 = false;
			do {
				System.out.println("Vuoi disdire? si/no");
				String sceltaUtente1 = scan.nextLine();
				switch (sceltaUtente1) {
				case "si":
					System.out.println("Inserisci quanti posti vuoi disdire: ");
					int postiDisdetti = scan.nextInt();
					System.out.println("Il totale dei posti disdetti è: " + postiDisdetti);
					int postiDisponibili = postiTotaliEvento - (postiPrenotatiEvento + postiDisdetti);
					System.out.println("Il totale dei posti disponibili è: " + postiDisponibili);
					sceltaValida1 = false;
					break;
				case "no":
					System.out.println("Grazie per averci scelto e arrivederci");
					sceltaValida1 = true;
					break;
				}
			} while (!sceltaValida1);
		} catch (IllegalArgumentException e1) {
			e1.getMessage();
		} catch (Exception e1) {
			e1.getMessage();
		}

		scan.close();
	}
}