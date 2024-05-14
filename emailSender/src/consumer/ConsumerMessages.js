const amqp = require("amqplib");
require("dotenv").config({ path: "./config/.env" });
const emailService = require("../services/EmailService.js");
async function startConsumer() {
  try {
    const connection = await amqp.connect(
      `amqp://${process.env.USER_RABBIT}:${process.env.PASSWORD_RABBIT}@${process.env.RABBITMQ_HOST}:${process.env.RABBITMQ_PORT}`
    );

    const channel = await connection.createChannel();
    const queueName = process.env.QUEUE_NAME;
    await channel.assertQueue(queueName, { durable: true });

    console.log("Waiting for messages");

    channel.consume(queueName, (msg) => {
      if (msg !== null) {
        console.log("Message received:", msg.content.toString());
        emailService.send(msg.content.toString());
        channel.ack(msg);
      }
    });
  } catch (err) {
    console.log("Error when consuming messages");
  }
}

module.exports = startConsumer;
