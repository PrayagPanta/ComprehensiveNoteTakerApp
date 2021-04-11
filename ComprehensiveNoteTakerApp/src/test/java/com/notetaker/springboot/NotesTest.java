package com.notetaker.springboot;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.notetaker.springboot.model.Note;
import com.notetaker.springboot.repository.NoteRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)

public class NotesTest {
   @Autowired 
   private NoteRepository repo;
   //Simple CRUD Test
   //C Test
   @Test
   public void testCreateNote()
   {
	   Note note = new Note();
	   note.setDescription("Test Note");
	   note.setImgPath(null);
	   note.setUserId("test@gmail.com");
	   Note savedNote=repo.save(note);
	   Assertions.assertNotNull(savedNote);
   }
   //R Test
   @Test
   public void findNoteById() {
	    Long id = Long.valueOf(19);
	    Optional<Note> note=repo.findById(id);
	    Assertions.assertTrue(note.get().getId().equals(id));
   }
    //U Test
   @Test
   public void updateNote() {
	    Note note = new Note();
	    note.setDescription("Test Note");
		note.setImgPath(null);
		note.setUserId("test@gmail.com");
		Note note2=repo.save(note);
		note2.setDescription("Updated Note");
		repo.save(note2);
		Assertions.assertTrue(repo.findById(note.getId()).get().getDescription().equals("Updated Note"));
   }
   //D Test
   @Test
   public void deleteNote()
   {
	   Note note = new Note();
	   note.setDescription("Test Note");
	   note.setImgPath(null);
	   note.setUserId("test@gmail.com");
	   repo.save(note);
	   Long id = note.getId();
	   repo.deleteById(id);
	   Assertions.assertFalse(repo.findById(id).isPresent());
   }
}
