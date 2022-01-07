var flage = false; 
$(function(){
  $('#memberPw').keyup(function(){
   $('font[name=check]').text('');
  }); //#user_pass.keyup

  $('#memberPwCheck').keyup(function(){
   if($('#memberPw').val()!=$('#memberPwCheck').val()){
    $('font[name=check]').text('');
    $('font[name=check]').html("비밀번호가 일치하지 않습니다.<br><br>");
    $('font[name=check]').attr('color', 'red');
    flage = false;
   }else{
    $('font[name=check]').text('');
    $('font[name=check]').html("비밀번호가 일치합니다.<br><br>");
    $('font[name=check]').attr('color', '#199894b3');
    flage = true;
   }
  }); //#chpass.keyup
 });
function checkValue(){
	  if(flage){
	      signup.submit();
	  }else{
		 
	  }
	}
 