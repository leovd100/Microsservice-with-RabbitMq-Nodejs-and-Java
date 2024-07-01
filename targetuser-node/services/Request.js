const axios = require("axios").default;

const send = async (tokenCript) => {
  const url = "http://localhost:8080/info";
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
