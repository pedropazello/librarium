jQuery(function($){
   $("#date").mask("99/99/9999",{placeholder:" "});
   $('#price').priceFormat({
	    prefix: '',
	    thousandsSeparator: '',
	    centsSeparator: ','
	});
});