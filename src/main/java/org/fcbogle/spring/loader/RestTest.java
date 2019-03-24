package org.fcbogle.spring.loader;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.fcbogle.spring.domain.ResearchItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class RestTest {
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PostConstruct
	public void init() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		List<ResearchItem> allResearchItems = new ArrayList<ResearchItem>();
		
		try {
			Resource resource = this.resourceLoader.getResource("classpath:/static/sample-S2-records");
			InputStream input = new FileInputStream(resource.getFile());
			//List<ResearchPaper> researchPapers = objectMapper.readValue(input, new TypeReference<List<ResearchPaper>>(){});
			
			JsonFactory jf = new JsonFactory();
			JsonParser jp = jf.createParser(input);
			jp.setCodec(objectMapper);
			jp.nextToken();
			while (jp.hasCurrentToken()) {
				ResearchItem ri = jp.readValueAs(ResearchItem.class);
				allResearchItems.add(ri);
				jp.nextToken();
				logger.info("Research name: " + ri.getTitle() + " Research id: " + ri.getId());
				logger.info("Research Item count: " + allResearchItems.size());
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}

	}

}
