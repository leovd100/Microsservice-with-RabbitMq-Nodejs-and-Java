class EmailTemplate {
  constructor(email, subject, html, textHtml) {
    this.email = email;
    this.subject = subject;
    this.html = html;
    this.textHtml = textHtml;
  }
}

module.exports = { EmailTemplate };
