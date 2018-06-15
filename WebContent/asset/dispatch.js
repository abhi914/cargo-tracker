$(document).ready(
function(){
$.getJSON("GetAllConsigneeJSON",{ajax:true},function(data){
$('#consignee').append($('<option>').val('-Select-').text('-Select-'));
$.each(data,function(i,item){
	$('#consignee').append($('<option>').val(item.ID).text(item.CONTACTPERSON));	
	
});
	
});

$.getJSON("GetAllConsignerJSON",{ajax:true},function(data){
	$('#consigner').append($('<option>').val('-Select-').text('-Select-'));
	$.each(data,function(i,item){
		$('#consigner').append($('<option>').val(item.ID).text(item.CONTACTPERSON));	
		
	});
		
	});




});


