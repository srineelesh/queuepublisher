package com.intv.queuepublisher.service;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intv.queuepublisher.QueuePublisherApplication;
import com.intv.queuepublisher.vo.QMessage;
import com.intv.queuepublisher.vo.ServiceResponse;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;


@RestController
public class PublisherServiceImpl {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@RequestMapping(value="/publish/greetings",method=RequestMethod.POST)
	@ApiOperation(value = "Greets everyone", response = ServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 406, message = "Message could not be published to queue"),
			@ApiResponse(code = 200, message = "Sucess") })
	public @ResponseBody ServiceResponse publishMessage(@RequestBody QMessage qmsg){
		final ServiceResponse resp = new ServiceResponse();
		try{
			System.out.println(qmsg.getMessage());
			rabbitTemplate.convertAndSend(QueuePublisherApplication.EXCHANGE_NAME, QueuePublisherApplication.ROUTING_KEY, qmsg);
		resp.setMessage("message published");
		}catch(AmqpException e){
			resp.setMessage("message could not be published");
			return resp;
		}
		 return resp;
			
	}

}
