<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h2>系统设置</h2>
	<form class="layui-form" lay-filter="form_syssetup">
		

		<div class="layui-form-item">
			<div class="layui-inline" id="div_menuUrl">
				<label class="layui-form-label">公司名称</label>
				<div class="layui-input-inline" style="width: 240px;">
					<input name="sysSetup1"  class="layui-input" lay-verify="required" readonly="readonly" value="中享思途" autocomplete="off"/>
				</div>			
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-inline" id="div_menuUrl">
				<label class="layui-form-label">公海设置</label>
				<div class="layui-input-inline" style="width: 240px;">
					<input name="sysSetup2" value="${syssetup.sysSetup2}" class="layui-input" lay-verify="required" autocomplete="off">
								
				</div>
				<span class="layui-form-mid layui-word-aux"> 最后的跟单超过这个天数后，客户转成公海状态，进入客户池。</span>
			</div>
		</div>


		<div class="layui-form-item">
			<div class="layui-inline" id="div_menuUrl">
				<label class="layui-form-label">提醒日期</label>
				<div class="layui-input-inline" style="width: 240px;">
					<input  name="sysSetup3" value="${syssetup.sysSetup3}" class="layui-input" lay-verify="required" autocomplete="off">
				</div>
				<span class="layui-form-mid layui-word-aux">距离最后一次跟单后，到达这个天数进行提醒</span>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="but_syssetup_submit">提交</button>
			
			</div>
		</div>
	</form>

<script type="text/javascript" src="assert/pages/js/syssetup.js"></script>
