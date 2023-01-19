<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<%@include file="/memberSide.jsp"%>

<body>
   <%
   String memId = (String) session.getAttribute("memId");
   String cateCode = request.getParameter("cateCode");
   String roomCode = request.getParameter("roomCode");
   int roomMaster = Integer.parseInt(request.getParameter("roomMaster"));

   System.out.println("현재 세션 아이디: " + memId);
   System.out.println("글쓰기로 넘어온 카테고리 코드: " + cateCode);
   System.out.println("글쓰기로 넘어온 방 코드: " + roomCode);
   System.out.println("글쓰기로 넘어온 관리자여부: " + roomMaster);
   %>

   <!-- Start Banner -->
   <%@include file="/boardBanner.jsp"%>
   <!-- End Banner -->
   <div class="container">
      <div style="padding: 50px;"></div>

      <!--       <form action="/DDITMATE/board/listQuestion.do" method="post"> -->

      <form action="insertRoomBoard.do" method="post" enctype="multipart/form-data">
         <table style="text-align: left; margin-left: 100px; width: 80%; border: 1px solid #dddddd">
            <thead>
               <tr>
                  <th colspan="2" style="padding-top: 25px; background-color: #eeeeee; text-align: left;">
                  </th>
               </tr>
            </thead>
            <tbody>
               <input type="hidden" name="cateCode" value="<%=cateCode%>">
               <input type="hidden" name="roomCode" value="<%=roomCode%>">
               <input type="hidden" name="roomMaster" value="<%=roomMaster%>">
               <tr>
                  <td>
                     <input type="text" class="form-control" placeholder="글 제목" name="boardTitle" maxlength="50" autofocus>
                  </td>
               </tr>
               <tr>
                  <td>
                     <textarea id="summernote" name="boardContents"></textarea>
                     <br>
                  </td>
               </tr>
            </tbody>
         </table>

         <input class="btn btn-primary float-end" type="submit" value="등록" style="position: relative; right: 15%; margin-top: 10px;">
         <a href="roomBoard.do?cateCode=<%=cateCode%>&roomCode=<%=roomCode%>&roomMaster=<%=roomMaster%>"><input class="btn btn-primary float-end" type="button" value="취소" style="position: relative; right: 15%; margin: 10px;"></a>
      </form>


   </div>


   <!-- Start Work -->
   <div class="row justify-content-center my-5"></div>

   <%@include file="/footer.jsp"%>

   <!-- //////////////////////////서머노트//////////////////////////////////-->
   <script>
      $(document)
            .ready(
                  function() {
                     let toolbar = [
                           // 글꼴 설정
                           [ 'fontname', [ 'fontname' ] ],
                           // 글자 크기 설정
                           [ 'fontsize', [ 'fontsize' ] ],
                           // 굵기, 기울임꼴, 밑줄,취소 선, 서식지우기
                           [
                                 'style',
                                 [ 'bold', 'italic', 'underline',
                                       'strikethrough', 'clear' ] ],
                           // 글자색
                           [ 'color', [ 'forecolor', 'color' ] ],
                           // 표만들기
                           [ 'table', [ 'table' ] ],
                           // 글머리 기호, 번호매기기, 문단정렬
                           [ 'para', [ 'ul', 'ol', 'paragraph' ] ],
                           // 줄간격
                           [ 'height', [ 'height' ] ],
                           // 그림첨부, 링크만들기, 동영상첨부
                           [ 'insert', [ 'picture', 'link', 'video' ] ],
                           // 코드보기, 확대해서보기, 도움말
                           [
                                 'view',
                                 [ 'codeview', 'fullscreen', 'help' ] ] ];

                     let setting = {
                        height : 400,
                        minHeight : null,
                        maxHeight : null,
                        focus : true,
                        lang : 'ko-KR',
                        toolbar : toolbar,
                        callbacks : { //여기 부분이 이미지를 첨부하는 부분
                           onImageUpload : function(files, editor,
                                 welEditable) {
                              for (let i = files.length - 1; i >= 0; i--) {
                                 uploadSummernoteImageFile(files[i],
                                       this);
                              }
                           }
                        }
                     };

                     $('#summernote').summernote(setting);
                  });

      function uploadSummernoteImageFile(file, el) {
         /*let data에 FormDate 주입 후
          * data.append를 하여 file이란 이름에 file이란 변수를 넣어줌
          * parameter로 받아온 file을 "file에 넣는 것"*/
         var data = new FormData();
         data.append("file", file);
         $.ajax({
            data : data,
            type : "POST",
            url : "../common/uploadImageFile.do",
            contentType : false,
            enctype : 'multipart/form-data',
            processData : false,
            success : function(url) {
               console.log(url)
               $(el).summernote('editor.insertImage', url);
            }
         });
      }
   </script>