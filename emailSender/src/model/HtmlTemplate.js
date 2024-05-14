const HtmlTemplate = (name) => {
  return `
    <style>
      .link {
        margin: 20px;
        border-radius: 50px;
        padding: 15px;
        background-color: purple;
        color: white;
        text-decoration: none;
      }
     
      p{
        margin: 45px;
      }
      .whatsapp {
        color: rgb(109, 173, 11);
        margin: 45px;
      }


    </style>


   <div sytle="height: 500px; width:500px">
    
      <h1>Olá ${name}</h1>
      <p>Seu cadastro foi efetuado com sucesso!</p>

      <p class="whatsapp">
        Para receber os próximos passos do conteúdo, entre no nosso grupo de
        whatsapp
      </p>

      <a class="link" href="https://web.whatsapp.com/">Clique aqui para entrar no grupo</a>
  </div>
  

`;
};

module.exports = { HtmlTemplate };
