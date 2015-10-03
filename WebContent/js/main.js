function habilitaCampo(id) {
	$("#"+id).prop("readonly", false);
	$("#lbl_"+id).remove();
};

function habilitaCampoData(id) {	
	habilitaCampo(id);
	datepicker(id);
}

function datepicker(id) {
	
	$("#"+id).datepicker({			
		showOn: "button",
	    buttonImage: "img/calendar.gif",
	    buttonImageOnly: true,
	    buttonText: "Select date",
	    changeMonth: true,
	    changeYear: true,
	    dateFormat: 'dd/mm/yy'		    
	});
};