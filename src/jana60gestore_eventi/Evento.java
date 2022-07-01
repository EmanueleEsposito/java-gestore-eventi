package jana60gestore_eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	// Attributi
	private String titolo;
	private LocalDate data;
	private int numeroPostiTotali;
	private int numeroPostiPrenotati;

	// Costruttore
	public Evento(String titolo, LocalDate data, int numeroPostiTotali, int numeroPostiPrenotati)
			throws IllegalArgumentException, Exception {
		super();

		// Sollevo eccezione nel caso data sia già passata
		validaData(data);

		// Sollevo eccezione nel caso numero di posti totali sia minore di 0
		if (numeroPostiTotali < 0) {
			throw new Exception("Il numero di posti totali non può essere minore di 0");
		}

		this.titolo = titolo;
		this.data = data;
		this.numeroPostiTotali = numeroPostiTotali;
		this.numeroPostiPrenotati = 0;

		// Getter e setter

	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getNumeroPostiTotali() {
		return numeroPostiTotali;
	}

	public int getNumeroPostiPrenotati() {
		return numeroPostiPrenotati;
	}

	// Metodo per validare la data
	private void validaData(LocalDate data) throws IllegalArgumentException {
		if (data.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("Data non può essere già passata");
		}
	}

	// Metodo prenota
	public int prenota() throws IllegalArgumentException, Exception {
		validaData(data);
		if (numeroPostiPrenotati == numeroPostiTotali) {
			throw new Exception("Ci dispiace ma l'evento non ha più posti disponibili");
		}
		return numeroPostiPrenotati + 1;

	}

	// Metodo disdici
	public int disdici() throws IllegalArgumentException, Exception {
		validaData(data);
		if (numeroPostiPrenotati == 0) {
			throw new Exception("Non puoi disdirre perchè non ci sono ancora prenotazioni");
		}

		return numeroPostiPrenotati - 1;

	}

	// Formatter data
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	// Override metodo toString()
	@Override
	public String toString() {

		return data.format(formatter) + "-" + titolo;
	}

}
