package com.exam.chatting.test;

import org.springframework.stereotype.Controller;

@Controller
public class DuplicationLoginController {
	
	
	/*
	 * 
	 * @GetMapping("/login")
		public String loginPage(String errorCode,Model model,HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies.length!=0) {
			
			for(Cookie cookie : cookies) {
				//System.out.println(cookie.getName()+" : "+cookie.getValue());
				if(cookie.getName().equals("rememberId")) {
					model.addAttribute("rememberId",cookie.getValue());
					model.addAttribute("checkbox","checked");
				}
			}
		}
		
		
		model.addAttribute("errorCode",errorCode);
		return "user/login";
	}
	
	@PostMapping("/login_ok")
	public String login_ok(UserVO userVo, String checkbox,HttpSession session,RedirectAttributes rttr,HttpServletResponse res) {
		
		String name = userService.loginCheck(userVo, session, checkbox, res); //유저 정보있는지 확인 있으면 세션등록까지
		
		if(name != null) { // 계정이 있다면?	
			
			return "redirect:/"; //메인페이지로 이동
			
		}else { //해당 계정이 없거나 로그인 중이라면?
			rttr.addAttribute("errorCode",1);
			return "redirect:/login"; //에러코드를 담아 다시 로그인 페이지로 보냄
		}	
	}
	
	@GetMapping("/logOut")
	public String logOut(HttpServletRequest request,HttpSession session) {
		
		String id = this.userService.getSession(request, "session");
		userService.logOut(session, id); //세션 말소
	
		
		return "redirect:/";
	}
	 */
	

	
}
