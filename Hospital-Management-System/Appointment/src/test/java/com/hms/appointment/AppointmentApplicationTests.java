package com.hms.appointment;

import com.hms.appointment.config.FeignClientConfig;
import feign.RequestTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AppointmentApplicationTests {

	@Autowired
	private FeignClientConfig feignClientConfig;

	@Test
	void contextLoads() {
	}

	@Test
	void testFeignRequestInterceptorForwardsHeaders() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.addHeader("Authorization", "Bearer test-jwt-token");
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		try {
			RequestTemplate template = new RequestTemplate();
			feignClientConfig.requestInterceptor().apply(template);

			assertTrue(template.headers().containsKey("Authorization"));
			assertEquals("Bearer test-jwt-token", template.headers().get("Authorization").iterator().next());
			assertFalse(template.headers().containsKey("X-Secret-Key"));
		} finally {
			RequestContextHolder.resetRequestAttributes();
		}
	}
}
