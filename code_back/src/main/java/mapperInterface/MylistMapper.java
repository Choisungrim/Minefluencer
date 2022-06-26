package mapperInterface;

import java.util.List;

import vo.MylistVO;
import vo.YtubeVO;

public interface MylistMapper {
	List<YtubeVO> selectList(String id);
}
