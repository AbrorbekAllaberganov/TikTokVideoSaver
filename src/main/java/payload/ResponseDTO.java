package payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDTO implements Serializable {
	private List<String> description;
	private List<String> NoWatermarkDownloadUrl;
	private List<String> MusicUrl;

}