<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript">
	$(function() {
		$("#category").change(function() {
			var num = $("#category").val();
			alert($("#category").val());
			// 		alert("부류코드 값:"+num);
			if (num == 100) {
				$("#item2").hide();
				$("#item2").attr('name', "_")
				$("#item1").show();
				$("#item1").attr('name', "item_code")
			}
			if (num == 200) {
				$("#item2").show();
				$("#item2").attr('name', "item_code")
				$("#item1").hide();
				$("#item1").attr('name', "_")
			}
		})

		$("#btn_search").on("click", function() {
			var item;
			if (100 == $("#category").val()) {
				item = $("#item1").val();
			} else if (200 == $("#category").val()) {
				item = $("#item2").val();
			}

			$("#c_code").val($("#category").val());
			$("#i_code").val(item);
			$("#d_code").val($("#dateserch").val());
			$("#select").submit();
		})

		// 	$("#category").val("${itemcategorycode}").prop("selected",true);
		// 	if(${itemcategorycode} ==100){

		// 		$("#item2").hide();
		// 		$("#item1").show();

		// 	$("#item1").val("${itemcode}").prop("selected",true);
		// 	}else if(${itemcategorycode} ==200){

		// 		$("#item2").show();		
		// 		$("#item1").hide();

		// 	$("#item2").val("${itemcode}").prop("selected",true);
		// 	}

		$("#save").on("click", function() {
			if ($("#category").val() == 100) {
				$("#item_code").val($("#item1").val());
			} else if ($("#category").val() == 200) {
				$("#item_code").val($("#item2").val());
			}

			$("#send").submit;

		})
	})
</script>

<!-- 20210302_KJH 시설등록 -->
<h3 class="mt-4">시설수정</h3>
<div class="card mt-2 col-sm-12 px-0">
	<!-- <h3 class="card-header">시설등록 페이지 :</h3> -->
	<div class="card-body text-left ">
		<div class="">
			<div class="">
				<form action="${pageContext.request.contextPath}/fsurpport/fmanageUpdate" method="post" id="send">
					<table class="table table-bordered " style="text-align: center;">
						<input type="hidden" name="manage_no" value="${fmanage.manage_no}">
						<tr>
							<td class="col-12" colspan="2">농장주 : <label>${fmanage.owner}</label> <input type="hidden" name="owner" value="${fmanage.owner}">
							</td>

						</tr>
						<tr>
							<td sclass="col-6"><select id="category" class="form-control">
									<option value="100" selected="selected">식량작물</option>
									<option value="200">채소류</option>
							</select></td>
							<td class="col-6"><select id="item1" class="form-control" name="item_code">
									<c:forEach items="${codesList}" var="codes">
										<c:if test="${codes.parent_code=='100'}">
											<option value="${codes.code_no}">${codes.code_nm}</option>
										</c:if>
									</c:forEach>
							</select> <select id="item2" class="form-control" style="display: none">
									<c:forEach items="${codesList}" var="codes">
										<c:if test="${codes.parent_code=='200'}">
											<option value="${codes.code_no}">${codes.code_nm}</option>
										</c:if>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td colspan="2">장소 : <input type="text" name="location" value="${fmanage.location}" required="required" />
							</td>
						</tr>
						<!-- 						<tr> -->
						<!-- 							<td colspan="2">장비 :  -->
						<!-- 							<label></label> -->
						<!-- 							</td> -->
						<!-- 						</tr> -->
						<tr>
							<td colspan="2"><textarea id="summernote" name="info">${fmanage.info}</textarea></td>
						</tr>
					</table>
					<div class="text-right">
						<button type="submit" class="btn btn-warning" id="save">수정</button>
						<input type="button" class="btn-sm btn-primary mb-2" value="목록으로" onclick="location.href = '${pageContext.request.contextPath }/fsurpport/fmanageList'">
					</div>

				</form>
			</div>
		</div>
	</div>
</div>

<script>
	$('#summernote').summernote(
			{
				placeholder : 'Hello SUMMERNOTE',
				tabsize : 2,
				height : 120,
				toolbar : [ [ 'style', [ 'style' ] ],
						[ 'font', [ 'bold', 'underline', 'clear' ] ],
						[ 'color', [ 'color' ] ],
						[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
				/*   ['table', ['table']],
				  ['insert', ['link', 'picture', 'video']],
				  ['view', ['fullscreen', 'codeview', 'help']] */
				]
			});
</script>
