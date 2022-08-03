package first.micronaut.app.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractEntity {

	/**
	 * Suffixe pour les contraintes d'unicité
	 */
	public static final String UK = "_UK";

	/**
	 * Suffixe pour les identifiants
	 */
	public static final String ID = "_ID";

	/**
	 * Suffixe pour les séquences
	 */
	public static final String SEQ = "_SEQ";

	public abstract Long getId();

	/***
	 * On update, the field annotated with @Version will be incremented and added to the WHERE clause.
	 * If the WHERE clause fails to match a record (because the same entity has already been updated by another thread),
	 * then the persistence provider will throw an OptimisticLockException.
	 */
	@Version
	protected Long version;

	@Column(name = "last_update")
	protected LocalDateTime lastUpdate;

	@PrePersist
	public void beforeCreation() {
		//version = 1L;
		this.lastUpdate = LocalDateTime.now();
	}

	@PreUpdate
	public void beforeUpdate() {
		this.lastUpdate = LocalDateTime.now();
	}
}
