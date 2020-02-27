var form;

layui.use([ 'table', 'form','rate' ], function() {
	// layui是基于jQuery的,启用$符号。
	var $ = layui.$;
	 form = layui.form;
	 var rate = layui.rate;
	var table = layui.table;
	
	 var ins1 = rate.render({
	      elem: '#test1'  //绑定元素
	    });
	
	
	//自定义表单校验
	form.verify({
		checkCustomerName:function(value, item){ //value：表单的值、item：表单的DOM对象
			//调用通用的唯一性校验的方法 #调用这个方法 一定要前面带 return
			return checkUnique(value,item,'customer/checkname');
		}
	});
	// 通过render方法开始渲染 talbe的数据
	table.render({
		elem : '#list_table', // 要绑定的页面元素
		url : 'customer', // 数据接口 layui会自动封装成  role/{page}/{limit}
		where : $('#form_search').serialize(),// 模拟额外的参数#目前引入搜索表单的数据
		page : true,// 开启分页
		cols: [[ //表头
		      {field: 'rowId', title: 'ID', width:80, sort: true, fixed: 'left'}
		      ,{field: 'cusName', title: '客户名称', width:100}
		      ,{field: 'cusPhone', title: '手机号码', width:130}
		      ,{field: 'cusQq', title: 'QQ', width:120}
		      ,{field: 'cusEmail', title: '电子邮箱', width:180}
		      ,{field: 'clientType', title: '客户类型', width:100}
		      ,{field: 'industryInvolved', title: '所属行业', width:100}
		      ,{field: 'isPublic', title: '是否公海', width:100,templet:'#isPublicTpl'} 
		      ,{title: '操作', width: 200,templet:'#customerBtnTpl'}
		    ]]
	});
	//绑定 省 change
	form.on('select(area1)', function(data){
		var parentCode =data.value;
		console.log(data.value);
		initAreaData(parentCode,'cityCode');
		
		});
    
	//绑定 市 change
	form.on('select(area2)', function(data){
		var parentCode =data.value;
		console.log(data.value);
		initAreaData(parentCode,'areaCode');
		
		});

});

//查询二级的Area数据
function initAreaData(parentCode,id,selectAreaCode){

return $.ajax({
		type:'get',
		url:'customer/list/'+parentCode,
		success:function(areaList){
			var options ='<option value=>市信息</option>';
			if(id=='areaCode'){
				options ='<option value=>区信息</option>';
			}
			var $select = $('#'+id);
			$select.html(options);
			if(areaList){
				$.each(areaList,function(index,area){
					var areaCode = area.areaCode;
					var areaName = area.areaName;
					var option ='<option value="'+areaCode+'">'+areaName+'</option>';
					options +=option;
				});
				
				
				 
			}
			$select.html(options);
			console.log(options);
			form.render('select');
		}
	});







}