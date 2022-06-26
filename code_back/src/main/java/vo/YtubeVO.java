package vo;

public class YtubeVO {
	private int seq;
	private String name;
	private String subscribe;
	private String introduce;
	private String image;
	private String youtube_addr;
	private String insta_addr;
	private String default_addr;
	private String job;
	private String adname;
	private int good;
	
	public String getYoutube_addr() {
		return youtube_addr;
	}

	public void setYoutube_addr(String youtube_addr) {
		this.youtube_addr = youtube_addr;
	}

	public String getInsta_addr() {
		return insta_addr;
	}

	public void setInsta_addr(String insta_addr) {
		this.insta_addr = insta_addr;
	}

	public String getDefault_addr() {
		return default_addr;
	}

	public void setDefault_addr(String default_addr) {
		this.default_addr = default_addr;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getAdname() {
		return adname;
	}

	public void setAdname(String adname) {
		this.adname = adname;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	@Override
	public String toString() {
		return "YtubeVO [seq=" + seq + ", name=" + name + ", subscribe=" + subscribe + ", introduce=" + introduce
				+ ", image=" + image + ", youtube_addr=" + youtube_addr + ", insta_addr=" + insta_addr
				+ ", default_addr=" + default_addr + ", job=" + job + ", adname=" + adname + ", good=" + good + "]";
	}

	
	
	
	
	
}
