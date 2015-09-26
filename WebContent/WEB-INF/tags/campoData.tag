<%@ attribute name="id" required="true" %>

<input id="${id}" name="${id}" value=" / / " />  
<script>
	$("#${id}").datepicker({			
			showOn: "button",
		    buttonImage: "img/calendar.gif",
		    buttonImageOnly: true,
		    buttonText: "Select date",
		    changeMonth: true,
		    changeYear: true,
		    dateFormat: 'dd/mm/yy'		    
		});
</script>