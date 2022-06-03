package vo;

public class FirstnameVO {
	
	private String nick_name;
	private int count;
	
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int counting) {
		this.count = counting;
	}
	@Override
	public String toString() {
		return "FirstnameVO [nick_name=" + nick_name + ", counting=" + count + "]";
	}
	
	
	
}
