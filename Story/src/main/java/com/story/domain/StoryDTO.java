package com.story.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

//DTO = Data Transfer Object 데이터 교환 

@Getter
@Setter
public class StoryDTO {
	
	private Long num; //글 번호
	private String title; //글 제목
	private String contents;//내용
	private String id; //작성자
	private int count; //조회수
	private String notiYn; //공지여부
	private String secretYn; //비밀여부
	private String deleteYn; //삭제여부 
	private LocalDateTime insertTime; //등록일
	private LocalDateTime update_time; //수정일
	private LocalDateTime delete_time; //삭제일
	
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getNotiYn() {
		return notiYn;
	}
	public void setNotiYn(String notiYn) {
		this.notiYn = notiYn;
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
	public LocalDateTime getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(LocalDateTime update_time) {
		this.update_time = update_time;
	}
	public LocalDateTime getDelete_time() {
		return delete_time;
	}
	public void setDelete_time(LocalDateTime delete_time) {
		this.delete_time = delete_time;
	}
	

	
}
