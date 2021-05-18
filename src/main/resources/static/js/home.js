//●
function custUserListVw() {
	location.href="/usermgt/user";
}

//●
function custUserDetailVw(userId) {
	getAjaxSubmit('thContents', '/usermgt/user/'+userId);
}

//●
function custUserAddMove() {
	getAjaxSubmit('thContents', '/usermgt/user/addmove');
}

//●
function custUserAdd() {
	var formObj = {
		userId : $('#userId').val(),
		mobileNo : $('#mobileNo').val(),
		addr : $('#addr').val()
	};
	postAjaxSubmit('thContents', '/usermgt/user/', formObj);
}

//●
function custUserModMove(userId) {
	getAjaxSubmit('thContents', '/usermgt/user/modMove/'+userId);
}

//●
function custUserMod(userId) {
	var formObj = {
		userId : $('#userId').val(),
		mobileNo : $('#mobileNo').val(),
		addr : $('#addr').val()
	};
	putAjaxSubmit('thContents', '/usermgt/user/'+userId, formObj);
}

//●
function custUserDel(userId) {
	deleteAjaxSubmit('thContents', '/usermgt/user/'+userId);
}

function backHome() {
	location.href="/index";
}

function getAjaxSubmit(div, url, redirectUrl) {
	$.ajax({ 
		type : "get",
		url : url,
		//contentType: "",
		//data: "",
		//dataType:"html",
		beforeSend : function(){
			//로딩바start
			$('.loader').show();
		},
		complete : function(){
			//로딩바end
			setTimeout(function(){
				$('.loader').hide();
			}, 1000);
		},
		success : function(data, textStatus, httpRequest){       
			if(httpRequest != undefined && httpRequest != null) {   
				$('#'+div).html(data);
			}
		},
		error : function(httpRequest, textStatus, error) {
		   //에러내용표시
		}
	});
}

function postAjaxSubmit(div, url, formObj) {
	$.ajax({ 
		type : "post",
		url : url,
		contentType : "application/json; charset=UTF-8",
		data : JSON.stringify(formObj),
		//dataType:"json", //controller에서 json String형태 전송됨. json아니므로 생략필요
		beforeSend : function(){
			//로딩바start
			$('.loader').show();
		},
		complete : function(){
			//로딩바end
			setTimeout(function(){
				$('.loader').hide();
			}, 1000);
		},
		success : function(data, textStatus, httpRequest){
			console.log('data : ' + data.result);
			custUserListVw();
		},
		error : function() {
		   //에러내용표시
		}
	});
}

function putAjaxSubmit(div, url, formObj) {
	$.ajax({ 
		type : "put",
		url : url,
		contentType : "application/json; charset=UTF-8",
		data : JSON.stringify(formObj),
		//dataType:"json", //controller에서 json String형태 전송됨. json아니므로 생략필요
		beforeSend : function(){
			//로딩바start
			$('.loader').show();
		},
		complete : function(){
			//로딩바end
			setTimeout(function(){
				$('.loader').hide();
			}, 1000);
		},
		success : function(data, textStatus, httpRequest){
			console.log('data : ' + data.result);
			custUserListVw();
		},
		error : function() {
		   //에러내용표시
		}
	});
}

function deleteAjaxSubmit(div, url) {
	$.ajax({ 
		type : "delete",
		url : url,
		//contentType : "application/json; charset=UTF-8",
		//data : JSON.stringify(formObj),
		//dataType:"json", //controller에서 json String형태 전송됨. json아니므로 생략필요
		beforeSend : function(){
			//로딩바start
			$('.loader').show();
		},
		complete : function(){
			//로딩바end
			setTimeout(function(){
				$('.loader').hide();
			}, 1000);
		},
		success : function(data, textStatus, httpRequest){
			console.log('data : ' + data.result);
			custUserListVw();
		},
		error : function() {
		   //에러내용표시
		}
	});
}