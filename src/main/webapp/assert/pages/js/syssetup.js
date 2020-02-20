layui.use(['form'],function(){
	var $ = layui.$;
	var form =layui.form;
	var layer = layui.layer;
	form.on('submit(but_syssetup_submit)',function(data){
		
		$.ajax({
			type :'put',
			url :'syssetup',		
			data : $(data.form).serialize(),
			success:function(result){
				if(result){
					layer.msg('系统参数设置成功！');
				}
			}
			
		});
		return false;
	});
	
	
	
});