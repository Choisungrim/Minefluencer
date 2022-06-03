package mapperInterface;

import java.util.List;

import vo.MemberVO;
import vo.YtubeVO;

public interface YtubeMapper {

	int insert (YtubeVO vo);
	List<YtubeVO> selectList();
	List<YtubeVO> imgOne (String string);
}
