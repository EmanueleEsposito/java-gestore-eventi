package jana60gestore_eventi;

import java.time.LocalDate;

public class Conferenza extends Evento {

	// Attributi
	private String argomento;
	private String oratore;

	// Costruttore
	public Conferenza(String titolo, LocalDate data, int numeroPostiTotali, int numeroPostiPrenotati, String argomento,
			String oratore) throws IllegalArgumentException, Exception {
		super(titolo, data, numeroPostiTotali, numeroPostiPrenotati);
		this.argomento = argomento;
		this.oratore = oratore;

	}
}
