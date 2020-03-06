var inputNome = document.querySelector("#nome");
var inputValor = document.querySelector("#valor");
var inputJuros = document.querySelector("#juros");
var inputParcelas = document.querySelector("#parcelas");
var inputPagamento = document.querySelector("#pagamento");

var inputForm = [inputNome, inputValor, inputJuros, inputPagamento];

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

inputParcelas.addEventListener('change', function enableInput(event) {
	
	checking();	
});


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

var valueParcelas = ["1", "2", "3", "6", "9", "12", "18", "24", "36", "48", "60", "72", "84", "96"];
var valueTest = [0.01, 200, 300, 600, 900, 1200, 1800, 2400, 3600, 4800, 6000, 7200, 8400, 9600];
var parcelas = document.getElementById("parcelas");
var counter = 1;

function parcelamentoDependente() {
	for (let i = counter; i > 1; i--) {
		parcelas.remove(i);
		counter--;
	}
	
	if ($("#valor").val() < 10) {
		parcelas.remove(1);
		document.getElementById("defaultParcelas").text = "Valor insuficiente (minimo: R$ 100,00)";	
	} else if (($("#juros").val() > 10) || ($("#juros").val() < 2.5)) {
		parcelas.remove(1);
		document.getElementById("defaultParcelas").text = "Juros insuficientes (entre: 2,5% a 10%)";
	} else if ($("#pagamento").val() != "A_VISTA") {
		
		document.getElementById("defaultParcelas").text = "Em apenas 1x nesse valor";
		createMetodoDeUmaVez();
		
		for (let i = 1; i < valueParcelas.length; i++) {
			if (($("#valor").val() >= valueTest[i])) {
				let valorParcela = $("#valor").val()*(1+$("#juros").val()/100)/valueParcelas[i];
				let optionn = document.createElement("option");
				optionn.text = valueParcelas[i] + "x de R$ " + valorParcela.toFixed(2);
				optionn.value = valueParcelas[i];
				optionn.id = valueParcelas[i];
				parcelas.add(optionn);
				counter++;
			}
		}
		
		if ($("#valor").val() >= valueTest[1]) {
			document.getElementById("defaultParcelas").text = "Em ate " + valueTest[counter-1]/100 + "x nesse valor";	
			document.getElementById("1").text = "1x de R$ " + valorParcela.toFixed(2);
		}

	} else {
		document.getElementById("defaultParcelas").text = "Em apenas 1x no metodo de pagamento selecionado";
		parcelas.remove(1);
		createMetodoDeUmaVez();
	}
}

function createMetodoDeUmaVez() {
	let valorParcela = $("#valor").val()*(1+$("#juros").val()/100);
	let optionn = document.createElement("option");
	optionn.text = "1x de R$ " + valorParcela.toFixed(2);
	optionn.value = valueParcelas[1];
	optionn.id = valueParcelas[1];
	parcelas.add(optionn);
}