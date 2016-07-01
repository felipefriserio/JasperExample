/**
 * 
 */

function geraRelatorio(action){
	var form = document.createElement("form");
	
	form.method = "GET";
	form.action = action;
	form.appendChild(createInput("nome", $('#nome').val()));
		 
	document.body.appendChild(form);
	
    form.submit();
    
	document.body.removeChild(form);
}


function createInput(fieldName, value) {
	var input = document.createElement("input");
	input.type = "text";
	input.name = fieldName;
	input.value = value;
	
	return input;
}