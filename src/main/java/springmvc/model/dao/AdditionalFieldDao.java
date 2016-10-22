package springmvc.model.dao;

import springmvc.model.Additionalfield;
import springmvc.model.Programs;

public interface AdditionalFieldDao 

{

	Additionalfield getAdditionalfield(Integer Addfield);
	
	Additionalfield saveAddfield(Additionalfield Addfield);
	
	void  removeAddfield(Additionalfield Addfield);
	
}
