 $(document).on('click', '#gerarGrafico', function(e){
    // get all the inputs into an array.
    var $inputs = $('#formCandidato :input');
    
    var formData = $('#formCandidato').serializeArray();
    var jsonString = JSON.stringify(formData);
    
    console.log("Data: ",formData);
    
    var empresaObject = new Object();
    var finalObject = new Object();
    var candidatoObject = new Object();
    
    var empresa = {};
    var candidato = {};
    var count = 0;
    var listEmpresa = [];
    for (var i = 0, len = formData.length; i < len; i++){
   
    	createNewCandidatoTemp(formData[i]);
    	console.log("CANDIDATO OBJECT: ",candidato);
    }
    
	$.ajax({
		   type:"POST",
		   async: false,
		   url: '/candidatos/salvar-informacoes',
		   data : candidato,
		   success: (data) => {
			   console.log(data);
	        },
	        error: (e) => {
	            //call error message
	        }
	     });

});
 var empresa = new Object();
 var candidato = new Object();
 var empresaList = new Array();
 function createNewCandidatoTemp(obj) {
	 var stringName = obj.name;
	 
	 if(stringName === 'empresa.atividades' ){
		empresa[obj.name] = obj.value; 
		empresaList.push(empresa);
		candidato.empresas = empresaList;
	 }
	 else if(stringName.includes('empresa') && stringName !== 'empresa.atividades'){
		 empresa[obj.name] = obj.value; 
	 }
	 else if(!stringName.includes('empresa')){
		 candidato[obj.name] = obj.value;
	 }
 }

 
 function createNewCandidato(candidato) {
	 var jsonCandidato = JSON.stringify(candidato);
	 console.log("jsonCandidato", jsonCandidato);
	  const obj = {};
	  obj.nome = candidato.nome;
	  obj.resumoQualificacao = candidato.resumoQualificacao;
	  obj.disponibilidade = candidato["disponibilidade"];
	  obj.empresa.nome =  candidato.empresa.nome
	  obj.empresa.cargo =  candidato["empresa.cargo"]
	  obj.empresa.dataInicio =  candidato["empresa.dataInicio"]
	  obj.empresa.dataFim =  candidato["empresa.dataFim"]
	  obj.empresa.atividades =  candidato["empresa.atividades"]

	  return obj;
	}

$(function(){
    $(document).on('click', '.btn-add', function(e){
        e.preventDefault();

        var controlForm = $('.controls'),
        currenttoInsert = $(this).parents('.toInsert:first'),
        newtoInsert = $(currenttoInsert.clone()).appendTo(controlForm);

        newtoInsert.find('input').val('');
        controlForm.find('.toInsert:not(:last) .btn-add')
            .removeClass('btn-add').addClass('btn-remove')
            .removeClass('btn-success').addClass('btn-danger')
            .html('<span class="glyphicon glyphicon-minus"></span>');
    }).on('click', '.btn-remove', function(e)
    {
		$(this).parents('.toInsert:first').remove();

		e.preventDefault();
		return false;
	});
    
    $(document).on('click', '.btn-add-curso', function(e){
        e.preventDefault();

        var controlForm = $('.controls-curso'),
        currenttoInsert = $(this).parents('.toInsertCurso:first'),
        newtoInsert = $(currenttoInsert.clone()).appendTo(controlForm);

        newtoInsert.find('input').val('');
        controlForm.find('.toInsertCurso:not(:last) .btn-add-curso')
            .removeClass('btn-add-curso').addClass('btn-remove-curso')
            .removeClass('btn-success').addClass('btn-danger')
            .html('<span class="glyphicon glyphicon-minus"></span>');
    }).on('click', '.btn-remove-curso', function(e)
    {
		$(this).parents('.toInsertCurso:first').remove();

		e.preventDefault();
		return false;
	});
    
    //TODO
    $(document).on('click', '.btn-add-experiencia', function(e){
    	e.preventDefault();
        var idForm = generateUUID();
        
        var controlForm = $('.controls-experiencia'),
        currenttoInsert = $(this).parents('.toInsertExperiencia:first'),
        newtoInsert = $(currenttoInsert.clone().attr( 'id', idForm )).appendTo(controlForm);
        var values = $(this).serialize();
//        var idFormulario = "#"+idForm
//        
//        console.log($("idFormulario").val());
        
        var values = $(this).serialize();
        
//        for (var i = 0; i < newtoInsert.length; i++) {
//        	 console.log(newtoInsert[i].childNodes);
//        }
        
//	   	 var str = $("#empresa").val();
//	   	 
//	   	 console.log(str);
//	   	 
//	   	 var str2 = $("#cargo").val();
	   	 
//	   	console.log(str2);
        
        newtoInsert.find('input').val('');
        controlForm.find('.toInsertExperiencia:not(:last) .btn-add-experiencia')
            .removeClass('btn-add-experiencia').addClass('btn-remove-experiencia')
            .removeClass('btn-success').addClass('btn-danger')
            .html('<span class="glyphicon glyphicon-minus"></span>');
        console.log(controlForm);
        console.log(newtoInsert[1]);
    }).on('click', '.btn-remove-experiencia', function(e)
    {
		$(this).parents('.toInsertExperiencia:first').remove();

		e.preventDefault();
		return false;
	});
    
    $(document).ready(function () {

        var navListItems = $('div.setup-panel div a'),
            allWells = $('.setup-content'),
            allNextBtn = $('.nextBtn'),
            allPrevBtn = $('.prevBtn');

        allWells.hide();

        navListItems.click(function (e) {
            e.preventDefault();
            var $target = $($(this).attr('href')),
                $item = $(this);
            var nextStepWizard = $(this).text();
            
            if(nextStepWizard == 1)
                $('.stepwizard .progress-bar').animate({width:'0%'},0);
            if(nextStepWizard == 2)
                $('.stepwizard .progress-bar').animate({width:'23%'},0);
            if(nextStepWizard == 3)
                $('.stepwizard .progress-bar').animate({width:'41%'},0);
            if(nextStepWizard == 4)
                $('.stepwizard .progress-bar').animate({width:'59%'},0);
            if(nextStepWizard == 5)
                $('.stepwizard .progress-bar').animate({width:'79%'},0);
            if(nextStepWizard == 6)
                $('.stepwizard .progress-bar').animate({width:'100%'},0);
            

            if (!$item.hasClass('disabled')) {
                navListItems.removeClass('btn-success').addClass('btn-default');
                //navListItems.addClass('btn-default');
                $item.addClass('btn-success');
                allWells.hide();
                $target.show();
                $target.find('input:eq(0)').focus();
            }
        });

        allNextBtn.click(function () {
            var curStep = $(this).closest(".setup-content"),
                curStepBtn = curStep.attr("id"),
                nextStepWizard = $('div.setup-panel div a[href="#' + curStepBtn + '"]').parent().next().children("a"),
                curInputs = curStep.find("input[type='text'],input[type='url']"),
                isValid = true;

            $(".form-group").removeClass("has-error");
            for (var i = 0; i < curInputs.length; i++) {
                if (!curInputs[i].validity.valid) {
                    isValid = false;
                    $(curInputs[i]).closest(".form-group").addClass("has-error");
                }
            }

            if (isValid) {
                nextStepWizard.removeAttr('disabled').trigger('click');    
            }
        });
        
        
        allPrevBtn.click(function () {
            var curStep = $(this).closest(".setup-content"),
                curStepBtn = curStep.attr("id"),
                prevStepWizard = $('div.setup-panel div a[href="#' + curStepBtn + '"]').parent().prev().children("a");

            prevStepWizard.removeAttr('disabled').trigger('click');    
        });
        

        $('div.setup-panel div a.btn-success').trigger('click');
    });
    
//    document.getElementById("g1").contentEditable = true;
    
});
 
 
function generateUUID() {
	var d = new Date().getTime();
	var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
	    var r = (d + Math.random()*16)%16 | 0;
	    d = Math.floor(d/16);
	    return (c=='x' ? r : (r&0x3|0x8)).toString(16);
	});
	return uuid;
};