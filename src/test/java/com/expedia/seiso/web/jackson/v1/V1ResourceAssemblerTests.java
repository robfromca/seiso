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
package com.expedia.seiso.web.jackson.v1;

import static org.junit.Assert.assertNotNull;
import lombok.val;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.expedia.seiso.web.hateoas.Resource;
import com.expedia.seiso.web.hateoas.PagedResources;
import com.expedia.seiso.web.jackson.orig.OrigResourceAssembler;

/**
 * @author Willie Wheeler
 */
public class V1ResourceAssemblerTests {
	
	// Class under test
	@InjectMocks private OrigResourceAssembler assembler;
	
	// Test data
	@Mock private PagedResources mapDtoPage;
	@Mock private Resource mapDto;
	
	@Before
	public void init() {
		this.assembler = new OrigResourceAssembler();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void toV1DtoPage() {
		val result = assembler.toOrigPagedResources(mapDtoPage);
		assertNotNull(result);
	}
	
	@Test(expected = NullPointerException.class)
	public void toV1DtoPage_nullMapDtoPage() {
		assembler.toOrigPagedResources(null);
	}
	
	@Test
	public void toV1Dto() {
		val result = assembler.toOrigResource(mapDto);
		assertNotNull(result);
	}
	
	@Test(expected = NullPointerException.class)
	public void toV1Dto_nullMapDto() {
		assembler.toOrigResource(null);
	}
}
