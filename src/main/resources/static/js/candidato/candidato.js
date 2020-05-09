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
                $('.stepwizard .progress-bar').animate({width:'33%'},0);
            if(nextStepWizard == 3)
                $('.stepwizard .progress-bar').animate({width:'66%'},0);
            if(nextStepWizard == 4)
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
    
});