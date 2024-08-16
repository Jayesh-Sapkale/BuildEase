package com.construction.payment;

import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@Service
public class SubscriptionOrderService {

	@Autowired
	private SubscriptionOrderRepository subscriptionOrderRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Value("${razorpay.key.id}") // It is used to read the values of properties which are in
									// application.properties file
	private String razorPayKey;

	@Value("${razorpay.secret.key}")
	private String razorPaySecret;

	private RazorpayClient client;

	public SubscriptionOrder createSubscriptionOrder(SubscriptionOrder subscriptionOrderDto) throws Exception {
		JSONObject orderRequest = new JSONObject();
		orderRequest.put("amount", subscriptionOrderDto.getAmount() * 100); // amount in paisa
		orderRequest.put("currency", "INR");
		orderRequest.put("receipt", subscriptionOrderDto.getEmail());

		this.client = new RazorpayClient(razorPayKey, razorPaySecret);
		Order razorPayOrder = client.orders.create(orderRequest);

		// Map DTO to Entity
		SubscriptionOrder subscriptionOrder = modelMapper.map(subscriptionOrderDto, SubscriptionOrder.class);
		subscriptionOrder.setRazorPayOrderId(razorPayOrder.get("id"));
		subscriptionOrder.setOrderStatus(razorPayOrder.get("status"));

		subscriptionOrderRepository.save(subscriptionOrder);

		return subscriptionOrder;

	}
}
