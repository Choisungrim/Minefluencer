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
	
	public int update(HashMap<String,String> aa) {
		return mapper.update(aa);
	}
	
	@Override
	public int idCheck(String id) {	
		return mapper.idCheck(id);
	}
	
	@Override
	public List<MemberVO> imgOne(String string) {
		return mapper.imgOne(string);
	}
	@Override
	public MemberVO selectOne(MemberVO vo) {
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

