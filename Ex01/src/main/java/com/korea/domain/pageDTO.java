package com.korea.domain;

import lombok.Data;

@Data
public class pageDTO {
	private int startPage;
	private int endPage;
	private boolean prev,next;
	
	private int total;
	private Criteria cri;
	
	public pageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		//페이징의 끝번호 : (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		//페이징의 시작번호
		this.startPage = this.endPage-9;
				
		
		//마지막페이지 번호 :(int) (Math.ceil(total * 1.0)/cri.getAmount());
		int realEnd = (int) (Math.ceil(total * 1.0)/cri.getAmount());
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage >1;
		this.next = this.endPage < realEnd;
	}
}
