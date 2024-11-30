package models;

import java.util.List;

import models.content.Content;

public class Playlist {
	private int ID;
	private String name;
	private List<Content> contents;
	
	public Playlist(int iD, String name, List<Content> contents) {
		super();
		ID = iD;
		this.name = name;
		this.contents = contents;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Content> getContents() {
		return contents;
	}

	public void setContents(List<Content> contents) {
		this.contents = contents;
	}
	
	public void addContent(Content contentToBeAdded) {
		contents.add(contentToBeAdded);
	}
	
	
}
