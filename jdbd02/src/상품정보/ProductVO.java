package 상품정보;

public class ProductVO {
	String id;
	String name;
	String content;
	int price;
	String company;
	String img;
	
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	@Override
	public String toString() {
		return "ProductVO [id=" + id + ", name=" + name + ", content=" + content + ", price=" + price + ", company="
				+ company + ", img=" + img + "]";
	}
	
	
}
