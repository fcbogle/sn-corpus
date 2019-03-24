package org.fcbogle.spring.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResearchItem {
	
	private String id;
	private String title;
	private String paperAbstract;
	private List<String> entities;
	private String s2Url;
	private String s2PdfUrl;
	private List<String> pdfUrls;
	private List<Author> authors;
	private List<String> inCitations;
	private List<String> outCitations;
	private int year;
	private String venue;
	private String journalName;
	private String journalVolume;
	private String journalPages;
	private List<String> sources;
	private String doi;
	private String doiUrl;
	private String pmid;
	
	public ResearchItem() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPaperAbstract() {
		return paperAbstract;
	}

	public void setPaperAbstract(String paperAbstract) {
		this.paperAbstract = paperAbstract;
	}

	public List<String> getEntities() {
		return entities;
	}

	public void setEntities(List<String> entities) {
		this.entities = entities;
	}

	public String getS2Url() {
		return s2Url;
	}

	public void setS2Url(String s2Url) {
		this.s2Url = s2Url;
	}

	public String getS2PdfUrl() {
		return s2PdfUrl;
	}

	public void setS2PdfUrl(String s2PdfUrl) {
		this.s2PdfUrl = s2PdfUrl;
	}

	public List<String> getPdfUrls() {
		return pdfUrls;
	}

	public void setPdfUrls(List<String> pdfUrls) {
		this.pdfUrls = pdfUrls;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<String> getInCitations() {
		return inCitations;
	}

	public void setInCitations(List<String> inCitations) {
		this.inCitations = inCitations;
	}

	public List<String> getOutCitations() {
		return outCitations;
	}

	public void setOutCitations(List<String> outCitations) {
		this.outCitations = outCitations;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getJournalName() {
		return journalName;
	}

	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}

	public String getJournalVolume() {
		return journalVolume;
	}

	public void setJournalVolume(String journalVolume) {
		this.journalVolume = journalVolume;
	}

	public String getJournalPages() {
		return journalPages;
	}

	public void setJournalPages(String journalPages) {
		this.journalPages = journalPages;
	}

	public List<String> getSources() {
		return sources;
	}

	public void setSources(List<String> sources) {
		this.sources = sources;
	}

	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}

	public String getDoiUrl() {
		return doiUrl;
	}

	public void setDoiUrl(String doiUrl) {
		this.doiUrl = doiUrl;
	}

	public String getPmid() {
		return pmid;
	}

	public void setPmid(String pmid) {
		this.pmid = pmid;
	}

	@Override
	public String toString() {
		return "ResearchPaper [id=" + id + ", title=" + title + ", paperAbstract=" + paperAbstract + ", entities="
				+ entities + ", s2Url=" + s2Url + ", s2PdfUrl=" + s2PdfUrl + ", pdfUrls=" + pdfUrls + ", authors="
				+ authors + ", inCitations=" + inCitations + ", outCitations=" + outCitations + ", year=" + year
				+ ", venue=" + venue + ", journalName=" + journalName + ", journalVolume=" + journalVolume
				+ ", journalPages=" + journalPages + ", sources=" + sources + ", doi=" + doi + ", doiUrl=" + doiUrl
				+ ", pmid=" + pmid + "]";
	}
	

}
