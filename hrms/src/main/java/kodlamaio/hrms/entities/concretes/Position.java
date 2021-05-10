package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Positions")
public class Position {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;

	public Position(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	
	public Position() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
