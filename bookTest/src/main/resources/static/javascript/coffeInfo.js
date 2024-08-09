/**
 * 
 */

$(function(){
	$("#del").on("click", function(){
		var coffeId = $(this).data("id");
		var isOk = confirm("정말 삭제하시겠습니까?");
		if(isOk){
			location.href = "/coffe/delete?id="+coffeId;
		}
	});
});