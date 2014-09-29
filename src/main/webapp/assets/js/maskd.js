jQuery(function($){
   $("#date").mask("9999",{placeholder:" "});
   $('#price').priceFormat({
	    prefix: '',
	    thousandsSeparator: '',
	    centsSeparator: ','
	});
});