package com.notetaker.springboot.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.notetaker.springboot.model.Note;
import com.notetaker.springboot.service.NoteSerive;
import com.notetaker.springboot.util.FileUploadUtil;

@Controller
public class NoteController {
    @Autowired
    private NoteSerive noteService;
    
    @GetMapping("/newNote")
    public String showNewNoteForm(Model model)
    {
    	Note note = new Note();
    	model.addAttribute("note",note);
    	return "new_note";
    }
    
    @PostMapping("/saveNote")
    public String saveNote(@AuthenticationPrincipal User user,@ModelAttribute("note") Note note, @RequestParam("image") MultipartFile multipartFile) throws IOException
    {
    	 note.setUserId(user.getUsername());
    	 String uploadDir = "user-photos";
    	 if(multipartFile.isEmpty()==false)
         { 
    	 String fileName= new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+StringUtils.cleanPath(multipartFile.getOriginalFilename());
         note.setImgPath(fileName);  
    	 FileUploadUtil.saveFile(uploadDir,fileName, multipartFile);
         }
    	 noteService.saveNote(note);
         return "redirect:/";
    }
    
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value="id")Long id,Model model)
    {
    	Note note = noteService.getNoteById(id).get();
    	model.addAttribute("note",note);
    	return "update_note";
    }
    
    @GetMapping("/deleteNote/{id}")
	public String deleteNote(@PathVariable (value = "id") Long id) {
		noteService.deleteNote(id);
		return "redirect:/";
	}
    
}
