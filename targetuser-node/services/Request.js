const axios = require("axios").default;
require("dotenv").config({ path: "./config/.env" });

const send = async (tokenCript) => {
  const url = process.env.URL_TOKEN;
  const data = { token: tokenCript };
  return await axios
    .post(url, data)
    .then((element) => {
      return " Deu certo " + element;
    })
    .catch((err) => {
      return "Deu errado " + err;
    });
};

module.exports = { send };
