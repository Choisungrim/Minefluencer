package service;

import java.util.List;

import vo.MylistVO;
import vo.YtubeVO;

public interface MylistService {

		List<YtubeVO> selectList(String id);

}
