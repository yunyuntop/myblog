<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style>
.clickktext{
display:block;
width:350px;
height:30px;
background-color: #eee;
text-align: center;
font-size:20px;line-height: 30px;cursor:pointer;;
}.clickktext:hover{
background-color:#888;color:#000;
transtion:background-color 0.5s;
}
.tagclass{
border-radius:1px;
height:30px;
color:#222;
border-color: #000;
border-width: 1px;

}
</style>
<link href="${pageContext.request.contextPath }/admin/css/style.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/admin/css/select.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/admin/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/admin/js/jquery.idTabs.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/admin/js/select-ui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/admin/editor/kindeditor-all.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/admin/editor/lang/zh-CN.js"></script>
<script type="text/javascript">
	KindEditor
			.ready(
					function(K) {
						var editor1 = K
								.create(
										'textarea[id="content7"]',
										{
											cssPath : '${pageContext.request.contextPath}/admin/editor/plugins/code/prettify.css',
											uploadJson : '${pageContext.request.contextPath}/adminAddBlogImgAction',
											imageTabIndex : 1,
											allowFileManager : true,
											allowImageUpload : true,
											items : [ 'source', '|', 'undo',
													'redo', '|', 'preview',
													'code', 'cut', 'copy',
													'paste', 'plainpaste',
													'wordpaste', '|',
													'justifyleft',
													'justifycenter',
													'justifyright',
													'justifyfull',
													'insertorderedlist',
													'insertunorderedlist',
													'indent', 'outdent',
													'subscript', 'superscript',
													'clearhtml', 'quickformat',
													'selectall', '|',
													'fullscreen', '/',
													'formatblock', 'fontname',
													'fontsize', '|',
													'forecolor', 'hilitecolor',
													'bold', 'italic',
													'underline',
													'strikethrough',
													'lineheight',
													'removeformat', '|',
													'image', 'table', 'hr',
													'emoticons', 'baidumap',
													'link', 'unlink', '|', ],
											afterBlur : function() {
												this.sync();
											},
											afterCreate : function() {
												var self = this;
												K
														.ctrl(
																document,
																13,
																function() {
																	self.sync();
																	document.forms['form1']
																			.submit();
																});
												K
														.ctrl(
																self.edit.doc,
																13,
																function() {
																	self.sync();
																	document.forms['form1']
																			.submit();
																});
											}
										});
						//prettyPrint();
					})
</script>
</head>

<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a style=""
				href="${pageContext.request.contextPath}/admin/welcome.jsp">首页</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/managerBlog/add.jsp">添加博客</a></li>
		</ul>
	</div>

	<div class="formbody">


		<div id="usual1" class="usual">



			<div id="tab1" class="tabson">
				<form enctype="multipart/form-data"
					action="${pageContext.request.contextPath }/adminBlogUploadAction"
					id="addblog" name="addblog" method="post">
					<div class="formtext">
						Hi，<b>${admin.aname }</b>
					</div>
					<input type="hidden" name="currPage" value="${currPage }">
					<ul class="forminfo">
						<li><label>标题<b>*</b></label><input name="btitle" type="text"
							class="dfinput" placeholder="标题" style="width: 518px;" required /></li>



						<li><label>头信息<b>*</b></label> <input type="text" maxlength="40"
							style="width: 418px;" class="dfinput" name="bheader" /></li>
						<li style="position: relative;" ><label>添加标签<b>*</b></label> <input style="width:350px;"
							type="text" name="searchkinds" id="searchtag"
							onkeyup="findtag(this)" class="dfinput" autocomplete="off" value=""/>

							<div 
								style="background-color:#eeeeee; display: none; border: 1px solid #aaabbb; width: 350px; position: absolute;z-index:3; left: 85px"
								id="kw"></div></li><li id="kinds"><label><b></b></label></li>

						<li><label>博客配图<b>*</b></label> <input type="file"
							onchange="getimgResult()" name="bimg" id="img" /></li>


						<li><label>&nbsp;&nbsp;&nbsp;&nbsp;<b>&nbsp;</b></label>
						<div id="image"></div></li>
						<li><label>博客内容<b>*</b></label> <textarea required id="content7"
								name="context"
								style="width: 700px; height: 250px; visibility: hidden;"></textarea>
						</li>
						<li><label>&nbsp;</label><input name="sub" id="but"
							type="submit" class="btn" value="马上发布" /></li>
					</ul>
				</form>
			</div>
		</div>

	</div>
	<script>
		function getimgResult() {
			var file = document.getElementById("img").files[0];
			var fileend = (file.name).substring((file.name).lastIndexOf("."));
			var maxSize = 1024 * 3;
			if (fileend.toLowerCase() == ".jpg" || fileend.toLowerCase() == ".jpeg") {

				//$("#but").attr("type","submit");
				var reader = new FileReader();
				reader.readAsDataURL(file);
				reader.onload = function() {
					$("#image")
							.html(
									$("<img src='"+this.result+"' height='200px' width='300px' />"));
				}
			} else {

				//$("#but").attr("type","button");
				$("#image").html("");
				alert("文件格式錯誤！必须是jpg或jpeg格式");

			}

		}
		//$("#searchtag").blur(function(){$("#kw").hide()});
		
		function newtag(tag){
			$("#kw").hide();
			$("#kinds").append($("<strong id="+tag+"><input type='checkbox' onclick=delselect('"+tag+"')  name='ktext' value='"+tag+"' checked />"+tag +"</strong>"));
			$("#searchtag").val("");
		}
		function selectktext(kid,ktext) {

			if(window.document.getElementsByName("ktext").length<6){
			if(window.document.getElementById(kid)==null){
			$("#kinds").append(
					"<strong id='"+kid+"'><input type='checkbox'  name='ktext' value='" + ktext
							+ "' onclick=delselect('"+kid+"')  checked='checked'/>"+ktext+"</strong> ");
			}}else{alert("您最多输入5个标签");}
			$("#searchtag").val("");
			$("#kw").hide();
			return;
		}
		function findtag(e) {
			$("#kw").html("");
			var ktext = e.value;
		
							
				$.get("${pageContext.request.contextPath}/adminSearchKindsAction",
					{
						"ktext" : ktext
					}, function(d) {
						if (d != null && d != "") {
							$("#kw").show();
							$(d).each(
									function(index, data) {
										if (index < 10) {
											$("#kw").append(
													$("<a onclick=selectktext('"+data.kid+"','"+data.name  +"') style='display:block;' class='clickktext'>"
															+ data.name+"</a>"));
										}
									})
						} else {
							if(ktext==''){
								$("#kw").hide();
							}else{
								$("#kw").show();
								$("#kw").append($("<a class=clickktext onclick=newtag('"+ktext+"') >添加这个标签</a>"));
							}
						}
					}, "json")
		}


		function delselect(kid) {
			var kvalue = kid;
			$("#"+kid).hide();
			$("#"+kid).remove();
			return;
		}
		
	</script>
	<script type="text/javascript">
		$("#usual1 ul").idTabs();
	</script>

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>







</body>
</html>
