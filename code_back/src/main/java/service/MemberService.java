package service;

import vo.MemberVO;

import java.util.*;

public interface MemberService {

		MemberVO selectOne(MemberVO vo);
		List<MemberVO> imgOne(String string);
		int insert(MemberVO vo);
		public MemberVO getAll(HashMap<String,Object> map);
}
