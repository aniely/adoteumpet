package com.adoteumpet.adocao.senders;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adoteumpet.adocao.dtos.AnimalDTO;
import com.adoteumpet.adocao.dtos.EmailSenderDTO;

@Component
public class QueueSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private Queue queue;

	public void send(AnimalDTO animal) {
		EmailSenderDTO email = new EmailSenderDTO();
		email.setAssunto("Adote um pet");
		email.setEmailDe("adoteumpet59@gmail.com");
		email.setEmailPara(animal.getTutor().getEmail());
		email.setTexto("Olá " + animal.getTutor().getNome() + "!\n Entre em contato com " + animal.getAdotadoPor().getNome() + " que deseja adotar o seu pet. \n"
				+ "E-mail: " + animal.getAdotadoPor().getEmail());
		rabbitTemplate.convertAndSend(this.queue.getName(), email);
	}
}
