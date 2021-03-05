<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 20210302_KJH 시설등록 -->
<h3 class="mt-4">시설관리 수정</h3>
<div class="card mt-2 col-sm-12 px-0">
	<h3 class="card-header">총게시글 :</h3>
	<div class="card-body text-left ">
		<div class="">
			<div class="row">
				<form action="#">
					<table class="table table-bordered col-sx-12" style="text-align: center;">
						<tr>
							<td style="width: 50%;">시설명 : <input type="text" />
							</td>
							<td style="width: 50%;">농장주 : <input type="text" />
							</td>
						</tr>
						<tr>
							<td style="width: 50%;">작물 : <input type="text" />
							</td>
							<td style="width: 50%;">장소 : <input type="text" />
							</td>
						</tr>
						<tr>
							<td colspan="2">장비번호 : <input type="text" />
							</td>
						</tr>
						<tr>
							<td colspan="2"><textarea id="summernote" name="summernote"></textarea></td>
						</tr>
					</table>
					<button type="button" class="btn btn-primary">등록하기</button>
				</form>
			</div>
		</div>
	</div>
</div>

<script>
     $('#summernote').summernote({
       placeholder: 'Hello SUMMERNOTE',
       tabsize: 2,
       height: 120,
       toolbar: [
         ['style', ['style']],
         ['font', ['bold', 'underline', 'clear']],
         ['color', ['color']],
         ['para', ['ul', 'ol', 'paragraph']],
         ['table', ['table']],
         ['insert', ['link', 'picture', 'video']],
         ['view', ['fullscreen', 'codeview', 'help']]
       ]
     });
</script>