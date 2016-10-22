package springmvc.model.dao;

import java.util.List;

import springmvc.model.Degree;

public interface DegreeDao 


{
   Degree saveDegree(Degree degree);
   
   Degree getDegree(Integer deg);
   
   List<Degree> getDegree();
   
	
	
	
}
