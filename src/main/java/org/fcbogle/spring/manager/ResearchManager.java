package org.fcbogle.spring.manager;

import java.util.List;

import org.fcbogle.spring.domain.ResearchItem;

public interface ResearchManager {
	
	public List<ResearchItem> getAllResearchItems();
	public ResearchItem getSingleItem(String id);
	public ResearchItem findUniqueItem(String id);


}
