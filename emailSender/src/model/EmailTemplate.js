class EmailTemplate {
  constructor(email, subject, html, textHtml, name) {
    this.email = email;
    this.subject = subject;
    this.html = html;
    this.textHtml = textHtml;
    this.name = name;
  }
}

module.exports = { EmailTemplate };
