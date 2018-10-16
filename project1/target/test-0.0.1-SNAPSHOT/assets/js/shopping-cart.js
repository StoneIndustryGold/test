       console.log('shopping-cart.js');
       $(function(){
    		$("#select").click(function() {
    		            $.ajax({
    		                url : "peopleSelect",		<!-- 控制的层路径/peopleSelect -->
    		                type : "POST",				<!--虽然是查找但一样的用post也行 -->
    		                dataType:"json",			<!--传的是一个json 文本-->
    		                contentType : "application/json;charset=UTF-8",  <!--指定编码格式-->
    		                <!-- 向后端传输的数据 -->
    		                data : JSON.stringify({
    		                    id : $("#user_id").val(),
    		                }),
    		                
    		                success:function(result) {
    		                	
    		                    <!-- 处理后端返回的数据 -->
    		                   /* var m= JSON.stringify(result);*/
    		                    var m = result;
    		                    /*alert(m);*/
    		                    console.log(m);
    		                    
    		                   /* document.getElementById("select-box").innerHTNL='<td>'+'<a href="index.html?"'+m.id+'>'+'</a></td>'+'<td>'
    		                    +m.age+'</td>'*/
    		                    var message = '<table><td>'+'用户id:<a href="index.html?'+m.id+'">'+m.id+'</a></td>'+'<td>年龄：'+m.age+'</td></table>';
    		                    $("#select-box").html("查询成功" + message);
    		                },
    		                error:function(result){
    		                    $("#select-box").html("查询失败");
    		                }
    		            });
    		        });
    		});          
       
       
       
       
