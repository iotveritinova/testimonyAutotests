package tripDemo.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DoggieFileData{

	@SerializedName("photoUrls")
	private List<String> photoUrls;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("category")
	private Category category;

	@SerializedName("tags")
	private List<TagsItem> tags;

	@SerializedName("status")
	private String status;

	public List<String> getPhotoUrls(){
		return photoUrls;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public Category getCategory(){
		return category;
	}

	public List<TagsItem> getTags(){
		return tags;
	}

	public String getStatus(){
		return status;
	}
}