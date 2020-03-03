	var inputNome = document.querySelector('#nome');
	var inputUsuario = document.querySelector('#usuario');
	
	
	inputUsuario.addEventListener('change',function enableInput(event) {
		checking();
	});
	
	inputSenha.addEventListener('change',function enableInput(event) {
		checking();
	});
	
	function checking(){
		if (($("#usuario").val() != "") && ($("#senha").val() != "")) {
			$('#botao').prop("disabled", false);			
		} else {
			document.getElementById("botao").disabled = true;
		}
	}
