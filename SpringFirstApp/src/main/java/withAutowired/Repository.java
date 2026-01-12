package withAutowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Repository {
    
	@Value("This is Sample from reopsitory")
	private String sample;
	
	@Value(" Snapshot 0.0.1")
	private String version;

	@Override
	public String toString() {
		return "Repository [sample=" + sample + ", version=" + version + "]";
	}
	
	
}
