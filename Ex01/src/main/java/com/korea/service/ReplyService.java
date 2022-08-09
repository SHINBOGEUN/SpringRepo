package com.korea.service;

import java.util.List;

import com.korea.domain.Criteria;
import com.korea.domain.ReplyDTO;
import com.korea.domain.ReplyPageDTO;

public interface ReplyService {
	//등록
	public int register(ReplyDTO dto);
	//조회
	public ReplyDTO get(Long rno);
	//수정
	public int modify(ReplyDTO dto);
	//삭제
	public int remove(Long rno);
	//페이징
	public List<ReplyDTO> getList(Criteria cri, Long bno);
	
	//댓글 수 처리
	public ReplyPageDTO getListPage(Criteria cri, Long bno);
}
