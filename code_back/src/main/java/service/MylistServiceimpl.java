package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapperInterface.MylistMapper;
import vo.MylistVO;
import vo.YtubeVO;

@Service
public class MylistServiceimpl implements MylistService {
		@Autowired
		MylistMapper mapper;
		
		@Override
		public List<YtubeVO> selectList(String id) {
			return mapper.selectList(id);
		}
		
	}

