package com.ssz.jms.activemq.sender;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class QueueSender {
	@Resource(name="jmsTemplate")  
	private JmsTemplate jmsTemplate;  
	
	/**
	* 向指定队列发送消息
	* @param destination
	* @param msg
	*/
	public void sendMessage(Destination destination,final String msg) {
		if(destination == null)
		{
			destination = jmsTemplate.getDefaultDestination();
		}
		System.out.println("向队列--"+destination.toString()+"--发送消息--"+msg);
		jmsTemplate.send(destination, new MessageCreator() {
			@Override  
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
	}
	
	/**
	 * 向默认队列发送消息
	 * @param msg
	 */
	public void sendMessage(final String msg) {
		System.out.println("向队列--"+jmsTemplate.getDefaultDestination()+"--发送消息--"+msg);
		jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
}
