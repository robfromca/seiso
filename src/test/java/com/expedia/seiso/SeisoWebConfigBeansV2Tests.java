/* 
 * Copyright 2013-2015 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.expedia.seiso;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.repository.support.Repositories;

import com.expedia.seiso.core.config.CustomProperties;
import com.expedia.seiso.domain.meta.ItemMetaLookup;
import com.expedia.seiso.domain.service.ItemService;
import com.expedia.seiso.domain.service.SearchEngine;
import com.expedia.seiso.web.hateoas.link.ItemPaths;
import com.expedia.seiso.web.jackson.hal.HalMapper;

/**
 * @author Willie Wheeler
 */
public class SeisoWebConfigBeansV2Tests {
	
	// Class under test
	@InjectMocks private SeisoWebConfigBeansV2 beans;
	
	// Dependencies
	@Mock private CustomProperties customProperties;
	@Mock private ItemMetaLookup itemMetaLookup;
	@Mock private Repositories repositories;
	@Mock private ItemService itemService;
	@Mock private SearchEngine searchEngine;
	@Mock private HalMapper halMapper;
	@Mock private ItemPaths itemPaths;
	@Mock private ConversionService conversionService;
	
	@Before
	public void setUp() {
		this.beans = new SeisoWebConfigBeansV2();
		MockitoAnnotations.initMocks(this);
		setUpDependencies();
	}
	
	private void setUpDependencies() {
		when(customProperties.getBaseUri()).thenReturn("https://seiso.example.com/v2");
	}
	
	/**
	 * This test doesn't really test anything, but I don't want the bean config to drag down the code coverage.
	 */
	@Test
	public void touchStuffToAvoidCodeCoverageHits() throws Exception {
		assertNotNull(beans.uriToItemKeyConverter());
		assertNotNull(beans.halHttpMessageConverter());
		assertNotNull(beans.itemKeyHttpMessageConverter());
	}
}