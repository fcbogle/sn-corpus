package org.fcbogle.spring.domain;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Entities {

	private List<ResearchItem> researchPapers;

	public Entities() {
	}

	public List<ResearchItem> getResearchPapers() {
		return researchPapers;
	}

	public void setResearchPapers(List<ResearchItem> researchPapers) {
		this.researchPapers = researchPapers;
	}

	@Override
	public String toString() {
		return "Entities [researchPapers=" + researchPapers + "]";
	}

}
