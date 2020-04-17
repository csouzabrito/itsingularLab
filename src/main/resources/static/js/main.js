/**
 * 
 */

$(document).ready(function() {
	
	$('.js-view-information').on('click', function(event) {
		event.preventDefault();
		
		var vagaSolicitada = $(event.currentTarget);
		var urlReceiver = vagaSolicitada.attr('href');
		
		console.log("href", urlReceiver);
		
		var href = $(this).attr('href');
		
		$.get(href, function(vaga){
			$('.myForm #id').val(vaga.id);
			$('.myForm #nomeSolicitante').val(vaga.nomeSolicitante);
			console.log("dataSolicitacao:", vaga.dataSolicitacao)
			$('.myForm #dataSolicitacao').val(vaga.dataSolicitacao);
		});
		console.log("VAGA: ", vaga.id);
		$('.myForm #vagas-modal').modal();
		
	});
	
function onDadosRecebidos(data) {
		
	console.log("data", data);
}	
});




	