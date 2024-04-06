package com.example.notification.integration;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.notification.model.ServiceNotificationRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class NotificationServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void shouldSendNotification() throws Exception {

		ServiceNotificationRequest request = ServiceNotificationRequest.builder()
				.message("Your order has been dispatched")
				.email("abc@xyz.com")
				.mobile("999991234")
				.orderId("12999922")
				.customer("ABC Enterprises")
				.build();

		this.mockMvc.perform(post("/api/v1/notification")
						.content(objectMapper.writeValueAsString(request))
						.contentType("application/json"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("12999922")));
	}

}
