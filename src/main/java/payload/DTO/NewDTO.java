package payload.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewDTO implements Serializable {
	private List<String> video;
	private List<String> music;
	private List<String> cover;
	private List<String> originalWatermarkedVideo;
	private List<String> dynamicCover;
	private List<String> author;
	private List<String> region;
	private List<String> avatarThumb;
	private List<String> customVerify;

}