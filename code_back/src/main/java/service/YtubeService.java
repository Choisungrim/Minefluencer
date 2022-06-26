package service;

import java.util.List;

import vo.MemberVO;
import vo.YtubeVO;

public interface YtubeService {
	
	List<YtubeVO> imgOne(String string);
	public int insert(YtubeVO vo);
	List<YtubeVO> selectList();
	List<YtubeVO> category(String interest);
}
