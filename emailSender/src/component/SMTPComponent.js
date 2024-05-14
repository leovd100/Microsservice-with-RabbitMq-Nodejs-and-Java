const nodemailer = require("nodemailer");
require("dotenv").config({ path: "./config/.env" });

const transport = nodemailer.createTransport({
  host: `${process.env.HOST_EMAIL_SMTP}`,
  port: process.env.PORT_SMTP,
  secure: false,
  auth: {
    user: `${process.env.USER_EMAIL}`,
    pass: `${process.env.PASSWORD_EMAIL}`,
  },
  tls: { rejectUnauthorized: false },
});

const sendEmail = (to, subject, html, text) => {
  transport
    .sendMail({
      from: "Cadastrado com sucesso! <applicationcapturesystemnode100@outlook.com>",
      to: to,
      subject: subject,
      html: html,
      text: text,
    })
    .then((response) => console.log("Email successfully sent!"))
    .catch((error) => console.log(error));
};

module.exports = { sendEmail };
