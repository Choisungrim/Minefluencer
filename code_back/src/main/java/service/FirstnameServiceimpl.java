package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapperInterface.FirstnameMapper;
import vo.FirstnameVO;
@Service
public class FirstnameServiceimpl implements FirstnameService {
	
	@Autowired
	FirstnameMapper mapper;
	
	public List<FirstnameVO> givenick() {
		return mapper.givenick();
	}
	@Override
	public int countUpdate(String nick_name) {
		return mapper.countUpdate(nick_name);
	}
}
