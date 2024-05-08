const emailCreator = require("../component/EmailCreator.js");
const send = (msg) => {
  const consumerMessage = JSON.parse(msg);
  const email = emailCreator.create(consumerMessage);
  console.log(email);
};

module.exports = { send };
