package com.globalin.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.globalin.biz.user.UserVO;
import com.globalin.biz.user.impl.UserDAO;
import com.globalin.view.controller.Controller;

public class LoginController implements Controller {

   @Override
   public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

      // 1단계 - 사용자가 입력한 정보를 추출
      String id = request.getParameter("id");
      String passwd = request.getParameter("password");

      // 2단계 - DB연동 처리
      UserVO vo = new UserVO();
      vo.setId(id);
      vo.setPasswd(passwd);

      UserDAO userDAO = new UserDAO();
      UserVO user = userDAO.getUser(vo);

      // 3단계 - 화면 네비게이션
      if (user != null) {
         return "getBoardList.do";
      } else {
         return "login";
      }

   }

}