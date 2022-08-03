package first.micronaut.app.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = Example.TABLE_NAME)
@Access(AccessType.FIELD)
public class Example extends AbstractEntity {

	public static final String TABLE_NAME = "example";
	public static final String TABLE_ID = TABLE_NAME + ID;
	private static final String TABLE_SEQ = TABLE_ID + SEQ;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_SEQ)
	@SequenceGenerator(name = TABLE_SEQ, sequenceName = TABLE_SEQ)
	private Long id;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "nom", nullable = false)
	private String nom;

	@Column(name = "prenom", nullable = false)
	private String prenom;

	public Example() {
	}

	public Example(LocalDate date, String nom, String prenom) {
		this();
		this.date = date;
		this.nom = nom;
		this.prenom = prenom;
	}

	@Override
	public Long getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getNom() {
		return nom;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

}

