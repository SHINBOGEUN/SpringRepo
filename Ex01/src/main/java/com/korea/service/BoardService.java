package com.korea.service;

import java.util.List;

import com.korea.domain.BoardDTO;
import com.korea.domain.Criteria;

public interface BoardService {
	
	public void register(BoardDTO dto);
	public BoardDTO get(Long bno);
	public boolean modify(BoardDTO dto);
	public boolean remove(Long bno);
	
//	public List<BoardDTO> getList();
	
	public List<BoardDTO> getList(Criteria cri);
	
	public int getTotal(Criteria cri);
}
