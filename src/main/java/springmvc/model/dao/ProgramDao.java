package springmvc.model.dao;

import java.util.List;
import springmvc.model.Programs;

public interface ProgramDao 


{
	
	Programs saveProgram(Programs program);

	Programs getProg (Integer program_id);
	
	List<Programs> getProg();
	
	void removeProgram(Programs program);
	
	
	
	
}
