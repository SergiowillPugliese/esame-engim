//*******************fetch ordini***********************//
const tableTariffe = document.getElementById("tbodyTariffe");
const getTariffe = "http://localhost:8091/spedizionearticoli/tariffe_corriere";

fetch(getTariffe)
  .then((response) => {
    return response.json();
  })
  .then((data) => {
    let tariffa = data;

    tariffa.map(function (tariffe) {
      console.log(tariffe);
      let table = document.createElement("tr");
      let id = document.createElement("td");
      let nomeCorriere = document.createElement("td");
      let nomeTariffa = document.createElement("td");
      let pesoMassimo = document.createElement("td");
      let costo = document.createElement("td");

      id.innerHTML = `${tariffe.id}`;
      nomeCorriere.innerHTML = `${tariffe.nome}`;
      nomeTariffa.innerHTML = `${tariffe.nomeTariffa}`;
      pesoMassimo.innerHTML = `${tariffe.pesoMassimo}`;
      costo.innerHTML = `${tariffe.costo}`;
      
      table.appendChild(id);
      table.appendChild(nomeCorriere);
      table.appendChild(nomeTariffa);
      table.appendChild(pesoMassimo);
      table.appendChild(costo);
      tableTariffe.appendChild(table);
    });
  })
  .catch(function (error) {
    console.log(error);
  });
