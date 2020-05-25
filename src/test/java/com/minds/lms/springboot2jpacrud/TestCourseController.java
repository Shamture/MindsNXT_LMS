/*package com.minds.lms.springboot2jpacrud;

import org.junit.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import com.minds.lms.springboot2jpacrud.model.Course;
import com.minds.lms.springboot2jpacrud.repository.CourseRepository;

public class TestCourseController
{

	
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	public void getCourseById() throws Exception
	{
		
		Course courses=new Course();
		Mockito.when(courseRepository.findById(Mockito.anyInt())).thenReturn(courses);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/course/{id}").accept(
				MediaType.APPLICATION_JSON);
		MvcResult  result =mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
		String expected = "{id:Course1,name:Spring,description:10Steps}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

		
	}
	
	

*/