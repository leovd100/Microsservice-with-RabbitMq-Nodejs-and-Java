const express = require("express");
const send = require("../services/Request.js");
const app = express();

app.use(express.json());

app.use((req, res, next) => {
  res.setHeader("Access-Control-Allow-Origin", "*");
  res.setHeader(
    "Access-Control-Allow-Methods",
    "GET, POST, PUT, DELETE, OPTIONS"
  );
  res.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
  next();
});

app.post("/info", async (req, res) => {
  return res.send(await send.send(req.body.token));
});

const startup = async () => {
  app.listen(3008, () => {
    console.log("server running...");
  });
};
module.exports = { startup };
