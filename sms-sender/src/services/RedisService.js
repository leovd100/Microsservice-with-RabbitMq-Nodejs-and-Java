const { redisConnection } = require("../component/RedisConnectionComponent.js");

sendToRedis = (contanct) => {
  const client = redisConnection()
    .then((push) => {
      console.log("Sending messages to redis");
      push.rPush("sms-client", JSON.stringify(contanct));
      push.quit();
    })
    .catch((err) => console.log("Error in redis sms-client"));
};

module.exports = { sendToRedis };
