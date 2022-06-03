package service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapperInterface.YtubeMapper;
import vo.MemberVO;
import vo.YtubeVO;

@Service
public class YtubeServiceimpl implements YtubeService{
	@Autowired
	YtubeMapper mapper;
	
	@Override
	public int insert(YtubeVO vo) {
		return mapper.insert(vo);
	}
	@Override
	public List<YtubeVO> selectList() {
		return mapper.selectList();
	}
	
	@Override
	public List<YtubeVO> imgOne(String string) {
		return mapper.imgOne(string);
	}
}
