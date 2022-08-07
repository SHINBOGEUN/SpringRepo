package com.korea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.korea.domain.Criteria;
import com.korea.domain.ReplyDTO;

public interface ReplyMapper {

	public int insert(ReplyDTO dto);
	
	public ReplyDTO read(Long rno);
	
	public int update(ReplyDTO dto);
	
	public int delete(Long rno);
	
	public List<ReplyDTO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno);
}
