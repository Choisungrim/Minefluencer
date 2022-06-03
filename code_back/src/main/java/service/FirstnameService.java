package service;

import java.util.List;

import vo.FirstnameVO;

public interface FirstnameService {
	List<FirstnameVO> givenick();
	int countUpdate(String nick_name);
}
