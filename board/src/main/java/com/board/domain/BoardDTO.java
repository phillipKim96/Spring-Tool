package com.board.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 
public class BoardDTO {
	
	private Long idx; // 글 번호(pk)
	private String title; //글 제목
	private String content; //내용
	private String Writer; //작성자
	private int viewCnt;	//조회수
	private String noticeYn; //공지여부
	private String secretYn; //비밀여부
	private String deleteYn; //삭제여부
	private LocalDateTime insertTime; //등록일
	private LocalDateTime updateTime; //수정일
	private LocalDateTime deleteTime; //삭제일
	public BoardDTO() {}
	public BoardDTO(Long idx, String title, String content, String writer, int viewCnt, String noticeYn,
			String secretYn, String deleteYn, LocalDateTime insertTime, LocalDateTime updateTime,
			LocalDateTime deleteTime) {
		super();
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.Writer = writer;
		this.viewCnt = viewCnt;
		this.noticeYn = noticeYn;
		this.secretYn = secretYn;
		this.deleteYn = deleteYn;
		this.insertTime = insertTime;
		this.updateTime = updateTime;
		this.deleteTime = deleteTime;
	}
	public Long getIdx() {
		return idx;
	}
	public void setIdx(Long idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return Writer;
	}
	public void setWriter(String writer) {
		Writer = writer;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getNoticeYn() {
		return noticeYn;
	}
	public void setNoticeYn(String noticeYn) {
		this.noticeYn = noticeYn;
	}
	public String getSecretYn() {
		return secretYn;
	}
	public void setSecretYn(String secretYn) {
		this.secretYn = secretYn;
	}
	public String getDeleteYn() {
		return deleteYn;
	}
	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}
	public LocalDateTime getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(LocalDateTime insertTime) {
		this.insertTime = insertTime;
	}
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
	public LocalDateTime getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(LocalDateTime deleteTime) {
		this.deleteTime = deleteTime;
	}
	
	
}
