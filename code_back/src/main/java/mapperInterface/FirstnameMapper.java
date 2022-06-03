package mapperInterface;

import java.util.List;

import vo.FirstnameVO;

public interface FirstnameMapper {
	List<FirstnameVO> givenick();
	int countUpdate(String nick_name);
}
