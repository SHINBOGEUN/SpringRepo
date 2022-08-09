package com.korea.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.korea.domain.BoardDTO;
import com.korea.domain.Criteria;
import com.korea.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class BoardServiceImpl implements BoardService{
	private BoardMapper mapper;

	@Override
	public void register(BoardDTO dto) {
//		mapper.insert(dto);
		mapper.insertSelectKey(dto);
	}

	@Override
	public BoardDTO get(Long bno) {
		return mapper.readXML(bno);
	}

	@Override
	public boolean modify(BoardDTO dto) {
		int result = mapper.updateXML(dto);
		if(result > 1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean remove(Long bno) {
		int result = mapper.deleteXML(bno);
		if(result > 1) {
			return true;
		}else {
			return false;
		}
	}

//	@Override
//	public List<BoardDTO> getList() {
//		return mapper.getList();
//	}

	@Override
	public List<BoardDTO> getList(Criteria cri) {
		log.info("get List with criteria :" + cri);
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}
	
	
}
