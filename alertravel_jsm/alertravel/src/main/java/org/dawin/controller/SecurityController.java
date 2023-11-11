package org.dawin.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.dawin.domain.ChangePasswordVO;
import org.dawin.domain.MemberVO;
import org.dawin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/security")
@Controller
public class SecurityController {
	
	@Autowired
	MemberService service;
	
	@GetMapping("/login")
	public void login() {
		log.info("=== login page 접속 중 ===");
	}
	
	@GetMapping("/signup")
	public void signup( @ModelAttribute("member") MemberVO member) {
		log.info("=== signup page 접속 중 ===");
	}
	
	@PostMapping("/signup")
	public String signup(
			@Valid
			@ModelAttribute("member") MemberVO member,
			Errors errors) throws IOException {
		
		if(!member.getPassword().equals(member.getPassword2())) {
			errors.rejectValue("password2", "비밀번호 불일치", "비밀번호 확인이 일치하지 않습니다.");
		}
		
		if(!errors.hasFieldErrors("username")) {
			if(service.get(member.getUsername()) != null) {
				errors.rejectValue("username", "아이디 중복", "이미 사용중인 아이디입니다.");
			}
		}
		
		if(errors.hasFieldErrors()) {
			return "security/signup";
		}
		
		service.register(member);
		
		return "redirect:/";
	}
	
	@GetMapping("/profile")
	public void profile() {
		
	}
	
	@GetMapping("/change_password")
	public void getChangePassword(ChangePasswordVO vo) {
		
	}
	
	@PostMapping("/change_password")
	public String postChangePassword(
			@Valid ChangePasswordVO vo, Errors errors) {
		
		// 비밀번호, 확인 일치 여부
		if(!vo.getNewPassword().equals(vo.getNewPassword2())) {
			// 에러 추가
			errors.rejectValue("newPassword2", "비밀번호가 일치하지 않습니다.", "비밀번호 확인이 일치하지 않습니다.");
		}
		
		if(!service.changePassword(vo)) {
			errors.rejectValue("orgPassword", "이전 비밀번호가 일치하지 않습니다.", "이전 비밀번호 확인이 일치하지 않습니다.");
		}
		
		if(errors.hasErrors()) {
			return "security/signup";
		}
		
		return "redirect:/security/profile";
	}
	
}
