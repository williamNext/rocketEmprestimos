	var inputNome = document.querySelector('#nome');
	var inputValor = document.querySelector('#valor');
	var inputJuros = document.querySelector('#juros');
	var inputParcelas = document.querySelector('#parcelas');
	var inputPagamento = document.querySelector('#pagamento');
//	var inputBotao = document.querySelector('#botao');
	
	
	
	inputNome.addEventListener('change',function enableInput(event) {
		if ($("#nome").val() != "-") {
			removeDisbled();
			checking();
		} else {
			disable();
		}
	});
	
	
	
	inputValor.addEventListener('change',function enableInput(event) {
		checking();
	});
	
	inputJuros.addEventListener('change',function enableInput(event) {
		checking();
	});
	
	inputParcelas.addEventListener('change',function enableInput(event) {
		checking();
	});
	
	inputPagamento.addEventListener('change',function enableInput(event) {
		checking();
	});
	
	
	
//	var form = document.querySelector('form');
//	form.addEventListener('submit', validateAndSubmit, false);
//	
//	inputBotao.addEventListener('change',function enableInput(event) {
//		alert("Solicitação enviada com sucesso!");
//	});
	
	

	function removeDisbled(){
		$('#valor').prop("disabled", false),
		$('#juros').prop("disabled", false),
		$('#parcelas').prop("disabled", false),
		$('#pagamento').prop("disabled", false);
	}
	
	function disable(){
		document.getElementById("valor").disabled = true;
		document.getElementById("juros").disabled = true;
		document.getElementById("parcelas").disabled = true;
		document.getElementById("pagamento").disabled = true;
		document.getElementById("botao").disabled = true;
	}
	
	function checking(){
		if (($("#nome").val() != "-") && ($("#valor").val() > 0) && ($("#juros").val() > 0) && ($("#parcelas").val() != "-") && ($("#pagamento").val() != "-")) {
			$('#botao').prop("disabled", false);			
		} else {
			document.getElementById("botao").disabled = true;
		}
	}
	