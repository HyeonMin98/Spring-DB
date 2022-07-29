package vo;

import org.springframework.web.multipart.MultipartFile;

public class PhotoVO {
	// 제목 : <input name="title"><br>
	// 사진 : <input type ="file" name = "photo"><br>

	private String title;
	private MultipartFile photo;
	private String filename; // upload된 파일의 이름

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
