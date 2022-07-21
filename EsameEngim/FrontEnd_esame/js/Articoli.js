//******************fetch articolo**********************//
const tableArticolo = document.getElementById("tbodyArticoli");
const getArticolo = "http://localhost:8091/spedizionearticoli/articolo";

fetch(getArticolo)
  .then((response) => {
    return response.json();
  })
  .then((data) => {
    let articolo = data;

    articolo.map(function (articoli) {
      console.log(articoli);
      let table = document.createElement("tr");
      let id = document.createElement("td");
      let codice = document.createElement("td");
      let descrizione = document.createElement("td");
      let peso = document.createElement("td");

      id.innerHTML = `${articoli.id}`;
      codice.innerHTML = `${articoli.codice}`;
      descrizione.innerHTML = `${articoli.descrizione}`;
      peso.innerHTML = `${articoli.peso}`;

      table.appendChild(id);
      table.appendChild(codice);
      table.appendChild(descrizione);
      table.appendChild(peso);
      tableArticolo.appendChild(table);
    });
  })
  .catch(function (error) {
    console.log(error);
  });



