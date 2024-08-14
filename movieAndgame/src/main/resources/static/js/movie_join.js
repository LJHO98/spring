/**
 * 
 */

$(function(){
	$("#joinBt").attr("disabled",true);
	
	
	$("#email").focus();
	
	$(".inputField input").on("focus", function(){
		$(this).addClass("active");
		$(this).next().addClass("focus");
	});
	
	$(".inputField input").on("blur", function(){
		var text = $(this).val(); // input 태그 value값 가져오기
		if(text == ''){
			$(this).removeClass("active");
			$(this).next().removeClass("focus");
		}		
	});
	
	$("#birthYear").empty(); //select 태그안에 비우기
	$("#birthMonth").empty(); //select 태그안에 비우기
	//태어난년도 select에 option태그 추가
	//1924~2024 이중에서 2005년을 기본값으로 설정
	for(var i=2024; i>=1924; i--){
		
		var selected = i==2005 ? "selected" : "";
		
		$("#birthYear").append(`<option value="${i}" ${selected}>${i}</option>`)
	}
	
	//태어난달 select에 option 태그 추가
	//1 ~ 12월을 추가하고, 지금 현재 오늘 이순간의 월을 기본값으로 설정
	var today = new Date();
	var month = today.getMonth()+1; // date로 가져온 월은 0~11 그래서 1더하기
	for(i=1; i<=12; i++){
		var selected = (i==month) ? "selected" : "";
		$("#birthMonth").append(`<option value="${i}" ${selected}>${i}</option>`);
	}
	
	//비밀번호와 비밀번호 확인 두 곳의 값이 일치하는지 확인
	$("#password").on("keyup", function(){
		if($(this).val() != $("#chk").val()){
			$("#pw1").text("비밀번호가 일치하지 않습니다");
			$("#pw1").css("color", "red");
			$("#pw2").empty();
		}else{
			$("#pw1").text("비밀번호가 일치합니다");
			$("#pw1").css("color", "green");
			$("#pw2").empty();
			$("#joinBt").attr("disabled",false);
		}
	});
	
	$("#chk").on("keyup", function(){
			if($(this).val() != $("#password").val()){
				$("#pw2").text("비밀번호가 일치하지 않습니다");
				$("#pw2").css("color", "red");
				$("#pw1").empty();
			}else{
				$("#pw2").text("비밀번호가 일치합니다");
				$("#pw2").css("color", "green");
				$("#pw1").empty();
				$("#joinBt").attr("disabled",false);
			}
		});
	
	
	
	
});