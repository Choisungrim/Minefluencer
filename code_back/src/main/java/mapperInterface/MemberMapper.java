package mapperInterface;


import java.util.List;

import vo.MemberVO;

public interface MemberMapper {
	MemberVO selectOne(MemberVO vo);
	List<MemberVO> imgOne (String string);
	int insert(MemberVO vo);
}