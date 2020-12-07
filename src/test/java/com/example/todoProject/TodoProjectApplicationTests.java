package com.example.todoProject;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TodoProjectApplicationTests {

	@Autowired
	MockMvc mvc;

	@Autowired
	ObjectMapper mapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetToDoItems() throws Exception {
		mvc.perform(
				MockMvcRequestBuilders.get("/todos")
		)
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(containsString("Clean up")))
				.andExpect(MockMvcResultMatchers.content().string(containsString("Finish ToDo app")));
	}

	@Test
	public void testGetToDoItem() throws Exception {
		mvc.perform(
				MockMvcRequestBuilders.get("/todos/1")
		)
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(containsString("Clean up")))
				.andExpect(MockMvcResultMatchers.content().string(not(containsString("Finish ToDo app"))));
	}

	@Test
	public void testAddToDoItem() throws Exception {
		mvc.perform(
				MockMvcRequestBuilders.get("/todos")
		)
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(not(containsString("New ToDo"))));

		mvc.perform(
				MockMvcRequestBuilders.post("/todos")
						.content(mapper.writeValueAsString(new ToDoItem("New ToDo", "New", "New ToDo item")))
						.contentType(MediaType.APPLICATION_JSON_UTF8)
		)
				.andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.content().string(containsString("New ToDo")));

		mvc.perform(
				MockMvcRequestBuilders.get("/todos")
		)
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(containsString("New ToDo")));
	}








/*
	@Test
	public void testEditToDoItem() throws Exception {
		mvc.perform(
				MockMvcRequestBuilders.get("/todos/2")
		)
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(containsString("Finish ToDo app")))
				.andExpect(MockMvcResultMatchers.content().string(containsString("\"done\":false")));

		ToDoItem toDoItem = new ToDoItem("Finish ToDo app", "Development", "Finish Todo App REST API");
		toDoItem.setDone(true);

		mvc.perform(
				MockMvcRequestBuilders.put("/todos/2")
						.content(mapper.writeValueAsString(toDoItem))
						.contentType(MediaType.APPLICATION_JSON_UTF8)
		)
				.andExpect(status().isNoContent());

		mvc.perform(
				MockMvcRequestBuilders.get("/todos/2")
		)
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(containsString("Finish ToDo app")))
				.andExpect(MockMvcResultMatchers.content().string(containsString("\"done\":true")));
	}

	@Test
	public void testEditNotExistingToDoItem() throws Exception {
		ToDoItem toDoItem = new ToDoItem("Finish ToDo app", "Development", "Finish Todo App REST API");
		toDoItem.setDone(true);

		mvc.perform(
				MockMvcRequestBuilders.put("/todos/12345")
						.content(mapper.writeValueAsString(toDoItem))
						.contentType(MediaType.APPLICATION_JSON_UTF8)
		)
				.andExpect(status().isNotFound());
	}
*/
	@Test
	public void testDeleteToDoItem() throws Exception {
		mvc.perform(
				MockMvcRequestBuilders.get("/todos/4")
		)
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(containsString("Buy milk")));

		mvc.perform(
				MockMvcRequestBuilders.delete("/todos/4")
		)
				.andExpect(status().isNoContent());

		mvc.perform(
				MockMvcRequestBuilders.get("/todos")
		)
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(not(containsString("Buy milk"))));
	}


	@Test
	public void testDeleteNotExistingToDoItem() throws Exception {
		mvc.perform(
				MockMvcRequestBuilders.delete("/todos/12345")
		)
				.andExpect(status().isNotFound());
	}


}
