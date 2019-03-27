package org.fcbogle.spring.manager;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.fcbogle.spring.domain.ResearchItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ResearchManagerImpl implements ResearchManager {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	@Cacheable("allItems")
	public List<ResearchItem> getAllResearchItems() {
		logger.info("ResearchManagerImpl: getAllResearchItems operation invoked");
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		List<ResearchItem> allResearchItems = new ArrayList<ResearchItem>();
		
		try {
			Resource resource = this.resourceLoader.getResource("classpath:/static/sample-S2-records");
			InputStream input = new FileInputStream(resource.getFile());	
			JsonFactory jf = new JsonFactory();
			JsonParser jp = jf.createParser(input);
			jp.setCodec(objectMapper);
			jp.nextToken();
			while (jp.hasCurrentToken()) {
				ResearchItem ri = jp.readValueAs(ResearchItem.class);
				allResearchItems.add(ri);
				jp.nextToken();
				//logger.info("Research name: " + ri.getTitle());
				//logger.info("Research Item count: " + allResearchItems.size());
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		return allResearchItems;
	}
	
	@Override
	public ResearchItem getSingleItem(String id) {
		List<ResearchItem> allItems = this.getAllResearchItems();
		for(ResearchItem ri : allItems) {
			if (ri.getId().equals(id)) {
				logger.info("ResearchManagerImpl getSingleItem() success: " + id);
				return ri;
			}
		}
		return null;
	}
	
	public ResearchItem findUniqueItem(String id) {
		logger.info("ResearchManagerImpl findUniqueItem() success: " + id);
		ResearchItem found = ResearchPredicate.filterResearchItems(this.getAllResearchItems(), ResearchPredicate.matchesId(id));
		return found;
	}
	
	

}
