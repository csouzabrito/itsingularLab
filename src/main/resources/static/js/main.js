/**
 * @author thiagocorrea
 */
	 
$(document).ready(function() {
	
	var dataRow = null;
	var responseDonwload = null;
	var dataTable = null
	
	$('.js-view-information').on('click', function(event) {
		event.preventDefault();
		alert = function() {};
		var vagaSolicitada = $(event.currentTarget);
		var urlReceiver = vagaSolicitada.attr('href');
		
		console.log("href", urlReceiver);
		
		var href = $(this).attr('href');
		
		$('#modalAguarde').modal('show');
		
		$.ajax({
			  url: href,
			  type: "GET"
			}).then(function(data) {
				console.log(data);
				dataTable = data
				$('#modalAguarde').modal('hide');
				
				
				var table =  $('#table').DataTable({
		            "processing": true,
		            "info": true,
		            "bLengthChange": false,
		            data: dataTable,
		            "columns": [
		            	{ "data": "cpf", "visible": false},
		                { "data": "nome"},
		                { "data": "formaContratacaoPrimaria", "className": "dt-center"},
		                { "data": "valorContratacaoPrimaria", "className": "dt-center" },
		                { "data": "formaContratacaoSecundaria", "className": "dt-center"},
		                { "data": "valorContratacaoSecundaria", "className": "dt-center" },
//		                { "data": "valor", "className": "dt-center" },
		                { "data": "email" },
		                { "data": "telCelular" },
		                { "data": "uploadDownloadPdf.nameArquivo",
		                	"render": function(data, type, row, meta){
		                        if(type === 'display'){
		                        	return '<a id="singular" href="#">' + data + '</a>';
		                        }
		                     }
		                }
		            ],
		            "language": {
			            "url": "https://cdn.datatables.net/plug-ins/1.10.20/i18n/Portuguese-Brasil.json"
			        }
		        });
				 // Apply the search
			    table.columns().every( function () {
			        var that = this;
			 
			        $( 'input', this.footer() ).on( 'keyup change clear', function () {
			            if ( that.search() !== this.value ) {
			                 that.search( this.value ).draw();
			            }
			        });
			    });
			    
				$('#table tbody').on( 'click','td', function () {
				    dataRow = table.row( this ).data();
				    downloadFile(dataRow);
				} );	
		       
			$('#vagas-modal').modal('show');
				
	});
});
	
});


function downloadFile(dataRow) {
	
	var cpf = dataRow.cpf;
	var byte = dataRow.uploadDownloadPdf.bitesArquivo;
	var type = "application/pdf";
	
	$.ajax({
		   type:"GET",
		   async: false,
		   url: '/cadastrarCurriculos/viewPdf/'+cpf,
		   success: (data) => {
			     const linkSource = `data:${type};base64,${byte}`;
			     const downloadLink = document.createElement("a");
			     downloadLink.href = linkSource;
			     downloadLink.download = dataRow.uploadDownloadPdf.nameArquivo;
			     downloadLink.click();
	        },
	        error: (e) => {
	            //call error message
	        }
	     });
}