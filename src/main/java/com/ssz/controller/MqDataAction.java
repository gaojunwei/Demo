package com.ssz.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssz.jms.activemq.sender.QueueSender;

@Controller
@RequestMapping(path="/jms")
public class MqDataAction {
	@Resource 
	QueueSender queueSender;
	
	/**
	 * ������Ϣ������
	 * Queue���У�����һ�������߻��յ���Ϣ����Ϣһ��������Ͳ�����ڶ�����
	 * @param message
	 * @return String
	 */
	@ResponseBody
	@RequestMapping("queueSender")
	public String queueSender(@RequestParam("message")String message){
		String opt="";
		try {
			queueSender.sendMessage(message);
			opt = "suc";
		} catch (Exception e) {
			opt = e.getCause().toString();
		}
		return opt;
	}
}
