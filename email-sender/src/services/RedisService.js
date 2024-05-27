const { redisConnection } = require("../component/RedisConnectionComponent.js");

sendToRedis = (contanct) => {
  const client = redisConnection()
    .then((push) => {
      push.rPush("email-client", JSON.stringify(contanct));
      push.quit();
    })
    .catch((err) => console.log("Error no redis email-client"));
};

module.exports = { sendToRedis };
