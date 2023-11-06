package personal.data;

import java.sql.Timestamp;

public class PersonalDto {
	private int num;
	private String name;
	private String photo;
	private int price;
	private String content;
	private String size;
	private Timestamp addday;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Timestamp getAddday() {
		return addday;
	}
	public void setAddday(Timestamp addday) {
		this.addday = addday;
	}
}
