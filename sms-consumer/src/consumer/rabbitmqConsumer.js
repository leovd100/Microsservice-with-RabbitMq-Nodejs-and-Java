const amqp = require("amqplib");
const messageService = require("../services/MessageSender.js");
require("dotenv").config({ path: "./config/.env" });

async function startConsumer() {
  try {
    const connection = await amqp.connect(
      `amqp://${process.env.USER}:${process.env.PASSWORD}@${process.env.RABBITMQ_HOST}:${process.env.RABBITMQ_PORT}`
    );
    const channel = await connection.createChannel();
    const queueName = process.env.QUEUE_NAME;
    await channel.assertQueue(queueName, { durable: true });

    console.log("Aguardando mensagens...");

    channel.consume(queueName, (msg) => {
      if (msg !== null) {
        console.log("Mensagem recebida:", msg.content.toString());
        messageService.send(msg.content.toString());
        channel.ack(msg);
      }
    });
  } catch (error) {
    console.error("Erro ao iniciar o consumidor:", error);
  }
}

module.exports = startConsumer;
