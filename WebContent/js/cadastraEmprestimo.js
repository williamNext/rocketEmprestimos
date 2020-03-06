var inputNome = document.querySelector("#nome");
var inputValor = document.querySelector("#valor");
var inputJuros = document.querySelector("#juros");
var inputParcelas = document.querySelector("#parcelas");
var inputPagamento = document.querySelector("#pagamento");

var inputForm = [inputNome, inputValor, inputJuros, inputParcelas, inputPagamento];


inputNome.addEventListener('change', function enableInput(event) {
	if ($("#nome").val() != "-") {
		removeDisbled();
		checking();
	} else {
		disable();
	}
});

for (var i = 1; i < inputForm.length; i++) {
	inputForm[i].addEventListener('change', function enableInput(event) {
		parcelamentoDependente();
		checking();	
	});
}


var idValor = document.getElementById("valor");
var idJuros = document.getElementById("juros");
var idPagamento = document.getElementById("pagamento");
var idParcelas = document.getElementById("parcelas");
var idBotao = document.getElementById("botao");
var idForm = [idValor, idJuros, idPagamento, idParcelas, idBotao];

function removeDisbled() {
	for (var i = 0; i < idForm.length; i++) {
		idForm[i].disabled = false;
	}
	
	idValor.placeholder = "Digite o valor a ser solicitado. Ex: 100,00";
	idJuros.placeholder = "Digite o juros ao mes desejado. Ex: 5,00";
}

function disable() {
	for (var i = 0; i < idForm.length; i++) {
		idForm[i].disabled = true;
	}
	
	idValor.placeholder = "Selecione um cliente";
	idJuros.placeholder = "Selecione um cliente";
}

function checking() {
	if (($("#nome").val() != "-") && ($("#valor").val() > 0)
			&& ($("#juros").val() > 0) && ($("#parcelas").val() != "-")
			&& ($("#pagamento").val() != "-")) {
		idBotao.disabled = false;
	} else {
		idBotao.disabled = true;
	}
}


var optionsParcelas = ["1x", "2x", "3x", "6x", "9x", "12x", "18x", "24x", "36x", "48x", "60x", "72x", "84x", "96x"];
var valueParcelas = ["1", "2", "3", "6", "9", "12", "18", "24", "36", "48", "60", "72", "84", "96"];
var valueTest = [0.01, 200, 300, 600, 900, 1200, 1800, 2400, 3600, 4800, 6000, 7200, 8400, 9600];
var parcelas = document.getElementById("parcelas");
var counter = 1;

function parcelamentoDependente() {
	for (let i = counter; i > 1; i--) {
		parcelas.remove(i);
		counter--;
	}
	
	if ($("#pagamento").val() != "A_VISTA") {	
		
		for (let i = 1; i < optionsParcelas.length; i++) {
			if (($("#valor").val() >= valueTest[i])) {
				let optionn = document.createElement("option");
				optionn.text = optionsParcelas[i];
				optionn.value = valueParcelas[i];
				optionn.id = optionsParcelas[i];
				parcelas.add(optionn);
				counter++;
			}
		}
		
		if (($("#valor").val() >= 10) && ($("#valor").val() < valueTest[1])) {
			document.getElementById("defaultParcelas").text = "Em apenas 1x nesse valor.";
		} else if ($("#valor").val() >= valueTest[1]) {
			document.getElementById("defaultParcelas").text = "Em ate " + valueTest[counter-1]/100 + "x nesse valor.";	
		} else {
			document.getElementById("defaultParcelas").text = "-";
		}
	} else {
		document.getElementById("defaultParcelas").text = "Em apenas 1x no metodo de pagamento selecionado.";
	}
}