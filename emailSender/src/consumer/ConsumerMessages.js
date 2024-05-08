const amqp = require("amqplib");
require("dotenv").config({ path: "./config/.env" });
const emailService = require("../services/EmailService.js");
async function startConsumer() {
  try {
    const connection = await amqp.connect(
      `amqp://${process.env.USER}:${process.env.PASSWORD}@${process.env.RABBITMQ_HOST}:${process.env.RABBITMQ_PORT}`
    );

    const channel = await connection.createChannel();
    const queueName = process.env.QUEUE_NAME;
    await channel.assertQueue(queueName, { durable: true });

    console.log("Aguardando mensagens");

    channel.consume(queueName, (msg) => {
      if (msg !== null) {
        console.log("Mensagem recebida:", msg.content.toString());
        emailService.send(msg.content.toString());
        channel.ack(msg);
      }
    });
  } catch (err) {
    console.log("Erro ao consumir mensagens");
  }
}

module.exports = startConsumer;
