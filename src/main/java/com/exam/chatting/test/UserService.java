package com.exam.chatting.test;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	/*
	 * 
	 * //로그인 -> 세션저장까지
		public String loginCheck(UserVO userVo,HttpSession session,String checkbox, HttpServletResponse res) {
		
		
		String name = userDao.loginCheck(userVo); // 만약 계정이 있다면 유저네임 반환
		
			
		if(name != null) {//계정이 존재한다면? 세션 등록		
			
			SessionListener.getInstance().printloginUsers();
			
			if(SessionListener.getInstance().isUsing(userVo.getEmail())) { //해당 아이디가 이미 로그인 중이라면? 로그인중인곳의 세션을 회수
                System.out.println("중복 로그인이 시도되었습니다. 세션을 만료 시킨 후 로그인을 진행하겠습니다.");
                SessionListener.getInstance().removeSession(userVo.getEmail());//세션리쓰너에서 해당 아이디를쓰고있는 사람의 세션을 수거              
            }
			
				
			session.setAttribute("session", userVo.getEmail()); //사용자의 이메일 즉 아이디 세션에 저장
			session.setAttribute("name", name); //사용자의 유저네임 세션에 저장			
	
			SessionListener.getInstance().setSession(session, userVo.getEmail()); //로그인중인 정보를 담고있는 테이블 해당 이메일을 추가
								
			Cookie cookie = new Cookie("rememberId", userVo.getEmail()); //쿠키 생성
				
			if(checkbox!=null) { //아이디 기억하기 체크박스에 체크가 되어있었다면? -> 쿠키생성
				cookie.setMaxAge(60*60*24);
				res.addCookie(cookie); //해당 쿠키생성
			}else {
				cookie.setMaxAge(0);
				res.addCookie(cookie);
			}
									
		}
		
		return name;
	}
	
	
	//로그아웃
	public void logOut(HttpSession session, String id) {
		
		if(session.getAttribute("session") != null) { //세션이 있다면 
			session.invalidate(); //세션 말소	
		}
			
	}
	  
	  */

}
