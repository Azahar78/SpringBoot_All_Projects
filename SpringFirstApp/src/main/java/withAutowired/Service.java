package withAutowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service {

	@Autowired
	private Repository repo;

	@Override
	public String toString() {
		return "Service [repositor=" + repo + "]";
	}
	
	
	
	
}
