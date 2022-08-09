package com.korea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.korea.domain.Criteria;
import com.korea.domain.ReplyDTO;

public interface ReplyMapper {
	//등록
	public int insert(ReplyDTO dto);
	//조회
	public ReplyDTO read(Long rno);
	//수정
	public int update(ReplyDTO dto);
	//삭제
	public int delete(Long rno);
	//페이징 처리
	public List<ReplyDTO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno);
	
	//댓글 개수 가져오기
	public int getCountByBno(Long bno);
}
