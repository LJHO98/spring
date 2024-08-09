/**
 * 
 */
let inputType=[];
let inputName=[];



$(function(){
	//삭제버튼
	$("#del").on("click", function(){
		
		var isOk = confirm("정말로 삭제하시겠습니까?");
		if(isOk){
			$("#fm").submit();
		}
	});
	//수정버튼	
	$("#modify").on("click", function(){
		$.each($(".value"), function(i, v){ //i - 인덱스 , v - i 인덱스의 값
			var text = $(v).text().trim(); // 기존의 값 추출
			console.log(text);
			if(inputType[i] === "checkbox"){
				let checked = false;
				if(text === "예"){
			    	checked = true;
			    }else if(text === "아니요"){
			        checked = false;
			    }
				$(v).html(`<input type='checkbox' name='${inputName[i]}' ${checked ? 'checked' : ''}>`);
			}else{
				if(inputType[i] === "number"){
				text = text.replace(/[^0-9]/g,""); //정규표현식 사용해서 숫자만 추출
				}
				$(v).html("<input type='"+inputType[i]+"' name='"+inputName[i]+"' value='"+text+"'>");
			}
			console.log(text);
		});
		
		$(this).attr("id","mod");
		
		var url = $("#fm").attr("action"); // form action값 가져오기
		url = url.replace("delete", "update"); //주소 변경
		// 주소 : /book/update 또는 /coffe/update로 변경된다.
		$("#fm").attr("action", url);
		
		$(this).off("click");
		
		$("#mod").on("click", function(){
			$("#fm").submit();
		});
	});
	

});


