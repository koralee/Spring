package com.globalin.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.globalin.view.board.DeleteBoardController;
import com.globalin.view.board.GetBoardController;
import com.globalin.view.board.GetBoardListController;
import com.globalin.view.board.InsertBoardController;
import com.globalin.view.board.UpdateBoardController;
import com.globalin.view.user.LoginController;
import com.globalin.view.user.LogoutController;

/*
 *  모든 컨트롤러 객체들을 저장하고 있다가 사용자의 요청이 들어오면 요청을 처리할
 *  특정한 컨트롤러를 검색하는 기능을 제공함.
 * 	Map 타입의 컬렉션을 멤버변수로 가지고 있음.
 * 
 */

public class HandlerMapping {

	private Map<String, Controller> mappings;
	
	public HandlerMapping() {

	mappings = new HashMap<String, Controller>();
	mappings.put("/login.do", new LoginController());
	mappings.put("/getBoardList.do", new GetBoardListController());
	mappings.put("/getBoard.do", new GetBoardController());
	mappings.put("/insertBoard.do",new InsertBoardController());
	mappings.put("/updateBoard.do",new UpdateBoardController());
	mappings.put("/deleteBoard.do",new DeleteBoardController());
	mappings.put("/logout.do",new LogoutController());
	
	}
	
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
	
}
