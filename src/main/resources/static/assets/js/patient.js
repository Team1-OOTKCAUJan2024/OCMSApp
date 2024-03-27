
$('document').ready(function(){
	
	$('table #editButton').on('click', function(event){
		
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(patient, status){
			$('#patientNumberEdit').val(patient.patientno);
			$('#patientNameEdit').val(patient.patientName);
			$('#selectGenderEdit').val(patient.gender);
			$('#ageEdit').val(patient.age);
			$('#addressEdit').val(patient.address);
			$('#nokEdit').val(patient.nok);
		});
		
		$('#editModal').show();
	});
	
});