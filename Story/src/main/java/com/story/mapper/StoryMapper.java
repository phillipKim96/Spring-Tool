package com.story.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.story.domain.StoryDTO;

//Mapper = mapping >> 파일에 기재된 SQL을 호출하기 위한 인터페이스

@Mapper
public interface StoryMapper {
	
	public int insertStory(StoryDTO params);
	public StoryDTO selectBoardDetail(Long num);
}
