package mapperInterface;

import java.util.List;
import vo.YtubeVO;

public interface YtubeMapper {

	int insert (YtubeVO vo);
	List<YtubeVO> selectList();
	List<YtubeVO> category(String interest);
	List<YtubeVO> imgOne (String string);
}
