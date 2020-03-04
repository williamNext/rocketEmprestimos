

var inputNome = document.querySelector('#nome');
var inputValor = document.querySelector('#valor');
var inputJuros = document.querySelector('#juros');
var inputParcelas = document.querySelector('#parcelas');
var inputPagamento = document.querySelector('#pagamento');

inputNome.addEventListener('change', function enableInput(event) {
	if ($("#nome").val() != "-") {
		removeDisbled();
		checking();
	} else {
		disable();
	}
});

inputValor.addEventListener('change', function enableInput(event) {
	checking();
});

inputJuros.addEventListener('change', function enableInput(event) {
	checking();
});

inputParcelas.addEventListener('change', function enableInput(event) {
	checking();
});

inputPagamento.addEventListener('change', function enableInput(event) {
	checking();
	checkParcelas();
});

function removeDisbled() {
	$('#valor').prop("disabled", false),
	$('#juros').prop("disabled", false),
	$('#parcelas').prop("disabled", false),
	$('#pagamento').prop("disabled", false);
	document.getElementById("valor").placeholder="Digite o valor a ser solicidado. Ex: 10.00"
	document.getElementById("juros").placeholder="Digite o juros ao mes desejado. Ex: 50.00"
}

function disable() {
	document.getElementById("valor").disabled = true;
	document.getElementById("valor").placeholder = "Selecione um cliente";
	document.getElementById("juros").disabled = true;
	document.getElementById("juros").placeholder = "Selecione um cliente";
	document.getElementById("parcelas").disabled = true;
	document.getElementById("pagamento").disabled = true;
	document.getElementById("botao").disabled = true;
}

function checking() {
	if (($("#nome").val() != "-") && ($("#valor").val() > 10.00)
			&& ($("#juros").val() > 0) && ($("#parcelas").val() != "-")
			&& ($("#pagamento").val() != "-")) {
		$('#botao').prop("disabled", false);
	} else {
		document.getElementById("botao").disabled = true;
	}
	
	if (($("#pagamento").val() == "A_VISTA") && ($("#parcelas").val() > 1)) {
		document.getElementById("botao").disabled = true;
		alert("Quantidade invalida de parcelas para pagamento a vista!");
	}
}

function checkParcelas() {
	if (($("#pagamento").val() != "A_VISTA") && ($("#pagamento").val() != "-")) {
		$('#2x').prop("disabled", false);
		$('#3x').prop("disabled", false);
		$('#6x').prop("disabled", false);
		$('#9x').prop("disabled", false);
		$('#12x').prop("disabled", false);
		$('#18x').prop("disabled", false);
		$('#24x').prop("disabled", false);
		$('#30x').prop("disabled", false);
		$('#60x').prop("disabled", false);
		$('#120x').prop("disabled", false);
		$('#240x').prop("disabled", false);
	} else {
		document.getElementById("2x").disabled = true;
		document.getElementById("3x").disabled = true;
		document.getElementById("6x").disabled = true;
		document.getElementById("9x").disabled = true;
		document.getElementById("12x").disabled = true;
		document.getElementById("18x").disabled = true;
		document.getElementById("24x").disabled = true;
		document.getElementById("30x").disabled = true;
		document.getElementById("60x").disabled = true;
		document.getElementById("120x").disabled = true;
		document.getElementById("240x").disabled = true;
	}
}
