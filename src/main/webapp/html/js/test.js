console.log('测试打印');

/*------jquery1 文件  准备好后执行函数   */
$(document).ready(function(){
	$("p").click(function(){/*jquery，当点击p标签的能容时触发事件调用函数  */
		$(this).hide();//这里的内容将会影藏 
	})	
});

//------jquery 二   当点击 class=q1的按钮是触发事件
$(document).ready(function(){
	$(".q1").click(function(){
		$("p").slideToggle();//p标签将依次展开或卷起 
	})
	
})
//------使用hide 隐藏所有的P标签   

$(document).ready(function(){
	$("button").click(function(){//当点击buttion标签是触发事件
		$("p").hide();//隐藏错有的p标签
	});
});






