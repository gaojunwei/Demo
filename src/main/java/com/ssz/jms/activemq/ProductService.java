package com.ssz.jms.activemq;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Resource(name="jmsTemplate")  
	private JmsTemplate jmsTemplate;  
	
	/**
	* ��ָ�����з�����Ϣ
	* @param destination
	* @param msg
	*/
	public void sendMessage(Destination destination,final String msg) {
		System.out.println("�����--"+destination.toString()+"--������Ϣ--"+msg);
		jmsTemplate.send(destination, new MessageCreator() {
			@Override  
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
	}
	
	/**
	 * ��Ĭ�϶��з�����Ϣ
	 * @param msg
	 */
	public void sendMessage(final String msg) {
		System.out.println("�����--"+jmsTemplate.getDefaultDestinationName().toString()+"--������Ϣ--"+msg);
		
		jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
	}
}
