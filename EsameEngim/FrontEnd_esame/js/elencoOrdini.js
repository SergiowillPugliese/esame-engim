//*******************fetch ordini***********************//
const tableOrdine = document.getElementById("tbodyOrdini");
const getOrdine = "http://localhost:8091/spedizionearticoli/ordini";

fetch(getOrdine)
  .then((response) => {
    return response.json();
  })
  .then((data) => {
    let ordine = data;

    ordine.map(function (ordini) {
      console.log(ordini);
      let table = document.createElement("tr");
      let id = document.createElement("td");
      let numero = document.createElement("td");
      let data = document.createElement("td");

      id.innerHTML = `${ordini.id}`;
      numero.innerHTML = `${ordini.numero}`;
      data.innerHTML = `${ordini.data}`;

      table.appendChild(id);
      table.appendChild(numero);
      table.appendChild(data);
      tableOrdine.appendChild(table);
    });
  })
  .catch(function (error) {
    console.log(error);
  });
