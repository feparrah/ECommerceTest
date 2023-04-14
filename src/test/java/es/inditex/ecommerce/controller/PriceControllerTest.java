package es.inditex.ecommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

	public static final String URL = "http://localhost:8080";

	@Autowired
	private MockMvc mvc;

	@Test
	void testGetPrice1_SUCCESS() throws Exception {

		final MvcResult mvcResult = this.mvc
				.perform(get(URL + "/prices/brands/1/products/35455?effectiveDate=2020-06-14T10:00:00")
						.contentType("application/json"))
				.andExpect(status().isOk()).andReturn();

		assertNotNull(mvcResult.getResponse().getContentAsString());
		assertEquals(mvcResult.getResponse().getContentAsString(), "{\"productId\":35455,\"brandId\":1,\"priceId\":1,\"effectiveDate\":\"2020-06-14T10:00:00\",\"price\":35.5}");
	}
	
	@Test
	void testGetPrice2_SUCCESS() throws Exception {

		final MvcResult mvcResult = this.mvc
				.perform(get(URL + "/prices/brands/1/products/35455?effectiveDate=2020-06-14T16:00:00")
						.contentType("application/json"))
				.andExpect(status().isOk()).andReturn();

		assertNotNull(mvcResult.getResponse().getContentAsString());
		assertEquals(mvcResult.getResponse().getContentAsString(), "{\"productId\":35455,\"brandId\":1,\"priceId\":2,\"effectiveDate\":\"2020-06-14T16:00:00\",\"price\":25.45}");
	}

	@Test
	void testGetPrice3_SUCCESS() throws Exception {

		final MvcResult mvcResult = this.mvc
				.perform(get(URL + "/prices/brands/1/products/35455?effectiveDate=2020-06-14T21:00:00")
						.contentType("application/json"))
				.andExpect(status().isOk()).andReturn();

		assertNotNull(mvcResult.getResponse().getContentAsString());
		assertEquals(mvcResult.getResponse().getContentAsString(), "{\"productId\":35455,\"brandId\":1,\"priceId\":1,\"effectiveDate\":\"2020-06-14T21:00:00\",\"price\":35.5}");
	}
	
	@Test
	void testGetPrice4_SUCCESS() throws Exception {

		final MvcResult mvcResult = this.mvc
				.perform(get(URL + "/prices/brands/1/products/35455?effectiveDate=2020-06-15T10:00:00")
						.contentType("application/json"))
				.andExpect(status().isOk()).andReturn();

		assertNotNull(mvcResult.getResponse().getContentAsString());
		assertEquals(mvcResult.getResponse().getContentAsString(), "{\"productId\":35455,\"brandId\":1,\"priceId\":3,\"effectiveDate\":\"2020-06-15T10:00:00\",\"price\":30.45}");
	}
	
	@Test
	void testGetPrice5_SUCCESS() throws Exception {

		final MvcResult mvcResult = this.mvc
				.perform(get(URL + "/prices/brands/1/products/35455?effectiveDate=2020-06-16T21:00:00")
						.contentType("application/json"))
				.andExpect(status().isOk()).andReturn();

		assertNotNull(mvcResult.getResponse().getContentAsString());
		assertEquals(mvcResult.getResponse().getContentAsString(), "{\"productId\":35455,\"brandId\":1,\"priceId\":4,\"effectiveDate\":\"2020-06-16T21:00:00\",\"price\":38.95}");
	}
	
	
	@Test
	void testPostUser_FAIL() throws Exception {
		this.mvc.perform(get(URL + "/prices/brands/1/products/35455?effectiveDate=2021-06-19T21:00:00").contentType("application/json"))
				.andExpect(status().isBadRequest()).andReturn();

	}

}
