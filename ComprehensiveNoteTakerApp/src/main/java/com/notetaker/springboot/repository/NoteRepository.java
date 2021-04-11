package com.notetaker.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.notetaker.springboot.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
  List<Note> findByUserId(String userId);
  Optional<Note> findById(Long id);
  
 /* @Query("Select n from note n where n.userId=:userId")
  Page<Note> findNotesByUserId(@Param("userId") String userId,Pageable pageable);*/
  
}
