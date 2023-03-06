package com.globalin.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalin.biz.board.BoardService;
import com.globalin.biz.board.BoardVO;
import com.globalin.biz.common.Log4jAdvice;
import com.globalin.biz.common.LogAdvice;

@Service("boardService")
public class BoardServiceimpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	//private LogAdvice log;
	private Log4jAdvice log;
	
	public BoardServiceimpl() {
		//log = new LogAdvice();
		log = new Log4jAdvice();
			
	}
	
	@Override
	public void insertBoard(BoardVO vo) {
		//log.printLog();
		log.printLogging();
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		//log.printLog();
		log.printLogging();
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		//log.printLog();
		log.printLogging();
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		//log.printLog();
		log.printLogging();
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {
		//log.printLog();
		log.printLogging();
		return boardDAO.getBoardList();
	}

}
