<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="layui-form" lay-filter="form_add_edit">

	<!-- layui的隐藏域  -->
	<input class="layui-hide" name="rowId" />
	
	<div class="layui-form-item" >
		<label class="layui-form-label">客户名称</label>
		<div class="layui-input-block" style="width: 182px;" >
			<!-- lay-verify 这个layui的自定义属性 ，设置表单的校验，多个校验 用 ‘|’ 隔开  -->
			<!-- class ='check-unique' 放置在此处用于通用JS脚本修改的时候使用-->
			<input name="cusName" lay-verify="required|checkCustomerName"
				id="cusName" class="layui-input check-unique" placeholder="请输入客户名称"
				autocomplete="off">
		</div>
	</div>
	<div class="layui-form-item layui-form-text">
		<div class="layui-inline">
			<label class="layui-form-label">手机号码</label>
			<div class="layui-input-inline">
				<input name="cusPhone" placeholder="手机号码" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<label class="layui-form-label">联系人</label>
		<div class="layui-input-inline">
			<input name="cusContact" placeholder="联系人" autocomplete="off"
				class="layui-input">
		</div>
	</div>

	<div class="layui-form-item layui-form-text">
		<div class="layui-inline">
			<label class="layui-form-label">QQ</label>
			<div class="layui-input-inline">
				<input name="cusQq" placeholder="QQ" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<label class="layui-form-label">电子邮箱</label>
		<div class="layui-input-inline">
			<input name="cusEmail" placeholder="电子邮箱" autocomplete="off"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item layui-form-text">
		<label class="layui-form-label">所在地区</label>
		<div class="layui-search-form">
			<div class="layui-input-inline">
				<select lay-filter="area1" name="proCode" id="proCode">
					<option>省信息</option>
					<c:if test="${!empty areaList}">
						<c:forEach items="${areaList}" var="area">

							<option value="${area.areaCode }">${area.areaName }</option>

						</c:forEach>
					</c:if>
				</select>
			</div>
			<div class="layui-input-inline">
				<select lay-filter="area2" name="cityCode" id="cityCode">
					<option>市信息</option>

				</select>
			</div>
			<div class="layui-input-inline">
				<select name="areaCode" id="areaCode">
					<option>区信息</option>

				</select>
			</div>
		</div>
	</div>
	<div class="layui-form-item layui-form-text">
		<div class="layui-inline">
			<label class="layui-form-label">详细地址</label>
			<div class="layui-input-inline" style="width: 500px;">
				<input name="detAddress" id="detAddress" placeholder="详细地址"
					autocomplete="off" class="layui-input">
			</div>
		</div>

	</div>


	<div class="layui-form-item layui-form-text">
		<c:if test="${!empty dictionaryList}">
			<c:forEach items="${dictionaryList}" var="dictionary">
				<div class="layui-inline">
					<c:if test="${dictionary.parentKey eq 'S000'}">
						<c:if test="${dictionary.dicValue != '跟单状态' && dictionary.dicValue != '跟单方式'}">
						<c:set value="${dictionary.children}" var="childDictionaryList"></c:set>
						
						<label class="layui-form-label">${dictionary.dicValue}</label>
						<div class="layui-input-inline">
							<select name="${dictionary.dicCode}">
								<option value="">请选择</option>
								<c:if test="${!empty childDictionaryList}">
									<c:forEach items="${childDictionaryList}" var="childDictionary">
										<option value="${childDictionary.dicCode}">${childDictionary.dicValue}</option>
									</c:forEach>
								
								
								</c:if>
							</select>
						</div>
						</c:if>
					</c:if>
				</div>
			</c:forEach>
		</c:if>
   
	</div>
	
	<div class="layui-form-item layui-form-text">
		<div class="layui-inline">
			<label class="layui-form-label">客户级别</label>
			<div class="layui-input-inline">
				<div id="test1"> </div>
			</div>
		</div>

	</div>
	<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn" lay-submit lay-filter="but_submit">提交</button>
			<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		</div>
	</div>
</form>
<script type="text/javascript" src="assert/pages/js/customer.js"></script>