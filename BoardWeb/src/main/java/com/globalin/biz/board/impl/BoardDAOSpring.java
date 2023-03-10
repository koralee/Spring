package com.globalin.biz.board.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.globalin.biz.board.BoardVO;

// Spring-jdbc를 활용하는
// 첫 번째 방법 : JdbcDaoSupport 클래스를 상속받아 활용

// 두 번째 방법 : Bean을 만들어서 의존성을 주입하여 구현(=Bean으로 등록)



// DAO(Data Access Object)
@Repository("boardDAO")
//public class BoardDAOSpring extends JdbcDaoSupport{
	public class BoardDAOSpring {
	
	
	// SQL 명령어들
	private final String BOARD_INSERT="insert into board(seq, title, writer, content) values((select nvl(max(seq),0)+1 from board), ?, ?, ?)";
//	private final String BOARD_INSERT="insert into board(seq, title, writer, content) values(?, ?, ?, ?)";
	private final String BOARD_UPDATE="update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE="delete from board where seq=?";
	private final String BOARD_GET="select * from board where seq=?";
	private final String BOARD_LIST="select * from board order by seq desc";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/*
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	*/
	
	
	// CRUD 메소드 구현
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("====> JDBC로 insertBoard() 기능 처리.");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	//	jdbcTemplate.update(BOARD_INSERT,vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent());

	}
	
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		
		System.out.println("====> JDBC로 updateBoard() 기능 처리.");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		
		System.out.println("====> JDBC로 deleteBoard() 기능 처리.");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	
	}
	
	
	// 글 상세조회
	public BoardVO getBoard(BoardVO vo) {
		
		System.out.println("====> Spring JDBC로 getBoard() 기능 처리.");
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	
	// 글 목록조회
	public List<BoardVO> getBoardList() {
		
		System.out.println("====> Spring JDBC로 getBoardList() 기능 처리.");
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());	
		
	}
}
