const { createClient } = require("redis");
const express = require("express");

const app = express();
const client = createClient();

const getAllProducts = async () => {
  const time = Math.random() * 5000;
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve(["Produto 1", "Produto 2"]);
    }, time);
  });
};

app.get("/", async (req, res) => {
  const productFromCache = await client.get("getAllProducts");
  if (productFromCache) {
    return res.send(JSON.parse(productFromCache));
  }
  const products = await getAllProducts();
  await client.set("getAllProducts", JSON.stringify(products), { EX: 10 });
  return res.send(products);
});

const startup = async () => {
  await client.connect();

  app.listen(3000, () => {
    console.log("server running...");
  });
};
startup();
