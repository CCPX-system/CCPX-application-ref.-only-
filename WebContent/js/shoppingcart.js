$(function() {
	
	/*
	 *加入购物车 
	 */
	$("#addtoCart").click(function(){
		
		var number=$("#number").val();
		var EP_id=$("#EP_id").val();
		location.href="addToCart?EP_id="+EP_id+"&num="+number;
		
	});
	/*
	 * 立刻购买商品
	 */	
	$("#buynow").click(function(){
		
		var number=$("#number").attr();
		var EP_id=$("#EP_id").attr();
		
		location.href="addToCart?EP_id="+EP_id+"num="+number;
		
	});

});

	
