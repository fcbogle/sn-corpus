package org.fcbogle.spring.manager;

import java.util.List;
import java.util.function.Predicate;

import org.fcbogle.spring.domain.ResearchItem;

public class ResearchPredicate {
	
	public static Predicate<ResearchItem> matchesId(String id) {
		return p -> p.getId().equals(id);
	}
	
	public static ResearchItem filterResearchItems(List<ResearchItem> researchItems, Predicate<ResearchItem> predicate) {
		return researchItems.stream()
				.filter(predicate)
				.findAny()
				.get();
	}

}
