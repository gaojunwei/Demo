package com.ssz.jms.activemq;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.log4j.Logger;

/** 
 * ��Ϣ������ 
 * @author gjw
 */
public class QueueMessageListener implements MessageListener {
	private static Logger 		logger = Logger.getLogger(QueueMessageListener.class.getName());
	@Override
	public void onMessage(Message message) {
		MapMessage mapMessage = (MapMessage) message;
		try {
			logger.info("��Ϣ���������յ���Ϣ��"+mapMessage.getString("count"));
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
