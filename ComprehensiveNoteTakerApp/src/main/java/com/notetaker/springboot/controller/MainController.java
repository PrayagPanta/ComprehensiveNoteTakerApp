package com.notetaker.springboot.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.notetaker.springboot.model.Note;
import com.notetaker.springboot.service.NoteSerive;

@Controller
public class MainController {
	@Autowired
	private NoteSerive noteService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home(@AuthenticationPrincipal User user,Model model) {
		List<Note> notes= noteService.getAllNotes(user.getUsername());
	/*	System.out.println("The list contains "+ " ");
		for(int i=0;i<notes.size();i++){
		    System.out.println(notes.get(i).getId());
		    System.out.println(notes.get(i).getUserId());
		    System.out.println(notes.get(i).getDescription());
		    System.out.println(notes.get(i).getImgPath());
		} */
		model.addAttribute("listNotes",notes);
		return "index";
	}
	//Pagination 
/*	@GetMapping("/showPage/{page}")
	public String showPage(@PathVariable("page") Integer page,Model model,@AuthenticationPrincipal User user)
	{
		Pageable pageable=PageRequest.of(page,2); 
		Page<Note> notes = noteService.fetchPagenatedNotes(user.getUsername(), pageable);
		model.addAttribute("notes",notes);
		model.addAttribute("currentPage",page);
		model.addAttribute("totalPages",notes.getTotalElements());
		return "index2";
	}*/
}
