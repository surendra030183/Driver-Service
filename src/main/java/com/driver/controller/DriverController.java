package com.driver.controller;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.driver.model.Order;

@RestController
public class DriverController {
	
	protected final Log logger = LogFactory.getLog(DriverController.class);

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("api/v1.5/driver/{driverid}")
	public ResponseEntity<Order> findOrderDriverId(@PathVariable long driverid) {
		
		try {
			return ResponseEntity.ok(getOrderByDriverId(driverid));
		} catch (RestClientException | IOException e) {
			logger.error(e);
		}
		return null;
	}
	
	/**
	 * Get order by order id
	 * @param driverid
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 */
	private Order getOrderByDriverId(long driverid) throws RestClientException, IOException {

		List<ServiceInstance> instances = discoveryClient.getInstances("order-service");
		ServiceInstance serviceInstance = instances.get(0);

		String baseUrl = serviceInstance.getUri().toString();

		baseUrl = baseUrl + "/api/v1.0/order/driver/" + driverid;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Order> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), Order.class);
		} catch (Exception ex) {
			logger.error(ex);
		}
		return response.getBody();
	}

	/**
	 * Get http headers
	 * @return
	 * @throws IOException
	 */
	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
	
	@GetMapping("hello")
	public String hello() {
		return "hello to driver service";
	}
	
}
