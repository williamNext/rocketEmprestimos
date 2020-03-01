function remove() {
	var clientes = document.querySelectorAll(".clientes");

	var tabela = document.querySelector("#tabela-clientes");
	
	tabela.addEventListener("dblclick", function(event) {
		event.target.parentNode.classList.add("fadeOut");
		
		setTimeout(function() {
			event.target.parentNode.();
		}, 500);
	});
	
}
