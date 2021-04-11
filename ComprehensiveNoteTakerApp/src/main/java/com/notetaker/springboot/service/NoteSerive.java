package com.notetaker.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.notetaker.springboot.model.Note;


public interface NoteSerive {
  List<Note> getAllNotes(String string);
  void saveNote(Note note);
  void deleteNote(long id);
  void updateNote(long id, Note note);
  Optional<Note> getNoteById(long id);
  /*Page<Note> fetchPagenatedNotes(String userId,Pageable pageable);*/
}
