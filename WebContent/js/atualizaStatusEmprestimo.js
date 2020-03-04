/**
 * 
 */

$( "input" ).click(function(event) { 
	event.preventDefault();
	console.log(event.target.parentNode);
	let stats =event.target.parentNode.childNodes[0].value;
    createForm(event.target.parentNode,stats);
});


function createForm(select,status){
	var f = document.createElement("form");
	f.setAttribute('method',"post");
	f.setAttribute('action',"./emprestimos?acao=MudaStatusEmprestimo&idStatus="+select.id+"&status="+status);
	f.setAttribute('id', "form-status");
	document.getElementsByTagName('body')[0].appendChild(f);
	f.submit();
}


