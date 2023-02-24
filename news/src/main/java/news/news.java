package news;

import java.util.Date;

public class news {
	
private  int id;
public String title;
public String content;
public String author;
public String type;
public Date  time;

public int getId() {
		return id;
	}
public void setId(int id) {
		this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public Date getTime() {
	return time;
}
public void setTime(Date time) {
	this.time = time;
}

}
