package service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapperInterface.MemberMapper;
import vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberMapper mapper;
	
	@Override
	public List<MemberVO> imgOne(String string) {
		// TODO Auto-generated method stub
		return mapper.imgOne(string);
	}
	@Override
	public MemberVO selectOne(MemberVO vo) {
		// TODO Auto-generated method stub
		return mapper.selectOne(vo);
	}
	@Override
	public int insert(MemberVO vo) {
		return mapper.insert(vo);
	}
	@Override
	public MemberVO getAll(HashMap<String,Object> map) {
		return mapper.getAll(map);
	}

}

