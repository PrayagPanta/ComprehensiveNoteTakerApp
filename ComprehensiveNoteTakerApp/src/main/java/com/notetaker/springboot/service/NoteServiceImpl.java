package com.notetaker.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.notetaker.springboot.model.Note;
import com.notetaker.springboot.repository.NoteRepository;


@Service
public class NoteServiceImpl implements NoteSerive {
    
	@Autowired
	private NoteRepository noteRepository;
	
	@Override
	public List<Note> getAllNotes(String userId) {
		return noteRepository.findByUserId(userId);
	}

	@Override
	public void saveNote(Note note) {
		// TODO Auto-generated method stub
         noteRepository.save(note);
	}
	
	@Override
	public void updateNote(long id,Note note1) {
		// TODO Auto-generated method stub
         Optional<Note> note = noteRepository.findById(id);
         if(note.isPresent())
         {
            Note note2= note.get();
            note2.setDescription(note1.getDescription());
            note2.setImgPath(note1.getImgPath());
            noteRepository.save(note2);
         }
         
	}

	@Override
	public void deleteNote(long id) {
		// TODO Auto-generated method stub
           noteRepository.deleteById(id);
	}

	@Override
	public Optional<Note> getNoteById(long id) {
		// TODO Auto-generated method stub
		return noteRepository.findById(id);
	}

/*	public Page<Note> fetchPagenatedNotes(String userId, Pageable pageable) {
		// TODO Auto-generated method stub
		return noteRepository.findNotesByUserId(userId, pageable);
	}*/

}
