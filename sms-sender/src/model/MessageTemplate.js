class MessageTemplate {
  constructor(cellPhone, message) {
    this.cellPhone = cellPhone;
    this.message = message;
  }

  getMessage() {
    return this.message;
  }

  getCellPhone() {
    return this.cellPhone;
  }
}

module.exports = { MessageTemplate };
