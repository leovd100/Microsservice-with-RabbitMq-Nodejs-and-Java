const amqp = require("amqplib");
const messageService = require("../services/MessageSenderService.js");
require("dotenv").config({ path: "./config/.env" });

async function startConsumer() {
  try {
    const connection = await amqp.connect(
      `amqp://${process.env.USER}:${process.env.PASSWORD}@${process.env.RABBITMQ_HOST}:${process.env.RABBITMQ_PORT}`
    );
    const channel = await connection.createChannel();
    const queueName = process.env.QUEUE_NAME;
    await channel.assertQueue(queueName, { durable: true });

    console.log("Waiting for messages...");

    channel
      .consume(queueName, (msg) => {
        if (msg !== null) {
          console.log("Message received:", msg.content.toString());
          messageService.send(msg.content.toString());
          channel.ack(msg);
        }
      })
      .catch((err) => {
        console.log("Error in message consumption", err);
      });
  } catch (error) {
    console.error("Error starting the consumer:", error);
  }
}

module.exports = startConsumer;
