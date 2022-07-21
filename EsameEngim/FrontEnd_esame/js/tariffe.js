//*******************fetch voci***********************//
const tableVovi = document.getElementById("tbodyTariffe");
const getVoci = "http://localhost:8091/spedizionearticoli/voce";
const getTariffe = "http://localhost:8091/spedizionearticoli/tariffe_corriere";
const getArticoli = "http://localhost:8091/spedizionearticoli/articolo";

Promise.all([
  fetch(getArticoli).then((resp) =>
    resp.json()
  ),
  fetch(getTariffe).then((resp) =>
    resp.json()
  ),
  fetch(getVoci).then((resp) =>
    resp.json()
  ),
]).then((data) => {
    let results = data;
    console.log(results);
    results.
});



/* fetch(getTariffe, getVoci, getArticoli)
  .then((response) => {
    return response.json();
  })
  .then((data) => {
    let results = data;
    console.log(results);

/*     tariffa.map(function (tariffe) {
      console.log(tariffe);

    });
  })
  .catch(function (error) {
    console.log(error);
  }); */