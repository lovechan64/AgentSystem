$().ready(function(){
	mover(1);
	
	
	$("#addCustomBtn").click(function(){
		location.href="/addcustom.action";
	});
	
	
	
	
	
	
	
	
	
	
	
	$(".modifycustomStatus").click(function(){
		var obj=$(this);
		
	var customStatus=	obj.attr("customstatus");
	 var id=  obj.attr("uid");
		
	 if(customStatus==1){
		 
	 }
	 $(this).val()
		
	 
	});
})	;