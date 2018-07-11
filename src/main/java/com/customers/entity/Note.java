package com.customers.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Note implements Serializable {

	private static final long serialVersionUID = 7L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_note")
	private Long noteId;

	@Column(name = "note")
	private String note;

	public Note() {
		super();
	}

	public Note(Long noteId, String note) {
		super();
		this.noteId = noteId;
		this.note = note;
	}

	public Long getNoteId() {
		return noteId;
	}

	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
