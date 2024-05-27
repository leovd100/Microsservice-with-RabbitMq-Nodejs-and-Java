const { createClient } = require("redis");
const redisConnection = async (email) => {
  const client = createClient();

  client.on("error", (error) => {
    console.error("Redis connection error:", err);
  });

  await client.connect();
  return client;
};

module.exports = { redisConnection };
