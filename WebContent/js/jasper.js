/**
 * 
 */

function geraRelatorio(){
	var form = document.createElement("form");
	form.method = "GET";
	form.action = action;

	form.appendChild(createInput("codUnidadeDesc", $('#nome').text()));
		 
	document.body.appendChild(form);
    form.submit();
	document.body.removeChild(form);
}