/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.restservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CitiesControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void noParamGetCitiesListShouldReturnDefaultMessage() throws Exception {

		this.mockMvc.perform(get("/cities/citiesList"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}

	@Test
	public void noParamGetWeatherByCityShouldReturnDefaultMessage() throws Exception {

		this.mockMvc.perform(get("/cities/weatherByCity"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("{\n" +
						"  \"idCity\": 1,\n" +
						"  \"cityName\": \"Москва\",\n" +
						"  \"weather\": [\n" +
						"    {\n" +
						"      \"fall\": \"Облачно\",\n" +
						"      \"temp\": 18,\n" +
						"      \"wind\": 2,\n" +
						"      \"wet\": 30\n" +
						"    }\n" +
						"  ]\n" +
						"}"));
	}

	@Test
	public void paramGetWeatherByCityShouldReturnTailoredMessage() throws Exception {

		this.mockMvc.perform(get("/cities/weatherByCity").param("name", "Чита"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("{\n" +
						"  \"idCity\": 4,\n" +
						"  \"cityName\": \"Чита\",\n" +
						"  \"weather\": [\n" +
						"    {\n" +
						"      \"fall\": \"Осадки в виде дождя\",\n" +
						"      \"temp\": 17,\n" +
						"      \"wind\": 4,\n" +
						"      \"wet\": 69\n" +
						"    }\n" +
						"  ]\n" +
						"}"));
	}

	@Test
	public void noParamGetCitiesByIDShouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/cities/citiesByIDs"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("[\n" +
						"  \"Москва\"\n" +
						"]"));
	}

	@Test
	public void paramGetCitiesByIDShouldReturnTailoredMessage() throws Exception {
		this.mockMvc.perform(get("/cities/citiesByIDs").param("id", "1"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("[\n" +
						"  \"Москва\"\n" +
						"]"));
	}

	@Test
	public void paramListGetCitiesByIDShouldReturnTailoredMessage() throws Exception {
		this.mockMvc.perform(get("/cities/citiesByIDs").param("id", "4,5,6,7"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("[\n" +
						"  \"Чита\",\n" +
						"  \"Владивосток\",\n" +
						"  \"Омск\",\n" +
						"  \"Ярославль\"\n" +
						"]"));
	}


}
