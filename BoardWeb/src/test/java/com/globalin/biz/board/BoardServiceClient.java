package com.globalin.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class BoardServiceClient {

	public static void main(String[] args) {
		
		
		AbstractApplicationContext container =
				new GenericXmlApplicationContext("applicationContext.xml");
		// 스프링 컨테이너로 객체를 관리한다!는 의미!
		
		BoardService boardService = (BoardService)container.getBean("boardService");
		
		// 글 등록
		BoardVO vo = new BoardVO();
		//vo.setSeq(0); //exception 확인용
		vo.setTitle("임시 제목");
		vo.setWriter("홍길동");
		vo.setContent("임시 내용들입니다. ......");
		boardService.insertBoard(vo);
		
		// 글 목록 검색
		List<BoardVO> boardList =boardService.getBoardList();
		
		for(BoardVO board : boardList) {
			System.out.println("----> "+board.toString());
		}
		
		container.close();
	}

}
