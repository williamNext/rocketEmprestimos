var emprestimos = document.querySelectorAll(".emprestimo");

var tabela = document.querySelector("table");
console.log(tabela);

tabela.addEventListener("dblclick", function(event) {

	$("#meu-form").append(
			'<input type="hidden" name="id" value="'
					+ event.target.parentNode.id + '" />');
	console.log(('<input type="hidden" name="id " value="'
			+ event.target.parentNode.id + '" />'));

	$("#meu-form").submit();
});
