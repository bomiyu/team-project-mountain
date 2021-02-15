
	$(document).ready(function() {

	
				$("[id^=like-img]").on('click', function(event) {

					event.preventDefault();
					if(userno == null || userno == '') {
						swal("로그인 후에 이용 가능합니다.", "","warning");
					} else {			

					var id = $(this).attr("id");
					console.log(id);
					if (this.id == 'like-img1') {
						var userno = userno;
						var resno = $(this).attr("data-resNo");
						console.log(resno);
						$(this).attr("src", root+"/resources/like_full.png");
						$.ajax({
							url : root + '/restaurant/like',
							type : 'post',
							dataType : 'json',
							data : {
								'userno' : userno,
								'resno' : resno,
								'likeno' : 1,
								'dislikeno' : 0
							}
						}).done(function() {
								console.log("like성공");
								location.reload();
							});
						
					}
						if (this.id == 'like-img2') {
						var userno = userno;
						var resno = $(this).attr("data-resNo");
						console.log(resno);
						$(this).attr("src", root+"/resources/like_full.png");
						$.ajax({
							url : root + '/restaurant/like',
							type : 'post',
							dataType : 'json',
							data : {
								'userno' : userno,
								'resno' : resno,
								'likeno' : 1,
								'dislikeno' : 0
							}
						}).done(function() {
								console.log("like성공");
								location.reload();
							});
						
					}
						else if (this.id == 'like-img3') {
						var userno = userno;
						var resno = $(this).attr("data-resNo");
						console.log(resno);
						$(this).attr("src", root+"/resources/like_full.png");
						$.ajax({
							url : root + '/restaurant/like',
							type : 'post',
							dataType : 'json',
							data : {
								'userno' : userno,
								'resno' : resno,
								'likeno' : 1,
								'dislikeno' : 0
							}
						}).done(function() {
								console.log("like성공");
								location.reload();
							});
						
					}
						else if (this.id == 'like-img4') {
						var userno = userno;
						var resno = $(this).attr("data-resNo");
						console.log(resno);
						$(this).attr("src", root+"/resources/like_full.png");
						$.ajax({
							url : root + '/restaurant/like',
							type : 'post',
							dataType : 'json',
							data : {
								'userno' : userno,
								'resno' : resno,
								'likeno' : 1,
								'dislikeno' : 0
							}
						}).done(function() {
								console.log("like성공");
								location.reload();
							});
						
					}
						else if (this.id == 'like-img5') {
						var userno = userno;
						var resno = $(this).attr("data-resNo");
						console.log(resno);
						$(this).attr("src", root+"/resources/like_full.png");
						$.ajax({
							url : root + '/restaurant/like',
							type : 'post',
							dataType : 'json',
							data : {
								'userno' : userno,
								'resno' : resno,
								'likeno' : 1,
								'dislikeno' : 0
							}
						}).done(function() {
								console.log("like성공");
								location.reload();
							});
						
					};

				});

				$("[id^=dislike-img]").on(
						'click',
						function(event) {
							event.preventDefault();
							var id = $(this).attr("id");
							console.log(id);
								if (this.id == 'dislike-img1') {
						var userno = userno;
						var resno = $(this).attr("data-resNo");
						console.log(resno);
						$(this).attr("src", root+"/resources/dislike_full.png");
						$.ajax({
							url : root + '/restaurant/like',
							type : 'post',
							dataType : 'json',
							data : {
								'userno' : userno,
								'resno' : resno,
								'likeno' : 0,
								'dislikeno' : 1
							}
						}).done(function() {
								console.log("dislike성공");
								location.reload();
	
							});
						
					} else if (this.id == 'dislike-img2') {
						var userno = userno;
						var resno = $(this).attr("data-resNo");
						console.log(resno);
						$(this).attr("src", root+"/resources/dislike_full.png");
						$.ajax({
							url : root + '/restaurant/like',
							type : 'post',
							dataType : 'json',
							data : {
								'userno' : userno,
								'resno' : resno,
								'likeno' : 0,
								'dislikeno' : 1
							}
						}).done(function() {
								console.log("dislike성공");
								location.reload();
	
							});
						
					} else if (this.id == 'dislike-img3') {
						var userno = userno;
						var resno = $(this).attr("data-resNo");
						console.log(resno);
						$(this).attr("src", root+"/resources/dislike_full.png");
						$.ajax({
							url : root + '/restaurant/like',
							type : 'post',
							dataType : 'json',
							data : {
								'userno' : userno,
								'resno' : resno,
								'likeno' : 0,
								'dislikeno' : 1
							}
						}).done(function() {
								console.log("dislike성공");
								location.reload();
	
							});
						
					} else if (this.id == 'dislike-img4') {
						var userno = userno;
						var resno = $(this).attr("data-resNo");
						console.log(resno);
						$(this).attr("src", root+"/resources/dislike_full.png");
						$.ajax({
							url : root + '/restaurant/like',
							type : 'post',
							dataType : 'json',
							data : {
								'userno' : userno,
								'resno' : resno,
								'likeno' : 0,
								'dislikeno' : 1
							}
						}).done(function() {
								console.log("dislike성공");
								location.reload();
	
							});
						
					} else if (this.id == 'dislike-img5') {
						var userno = userno;
						var resno = $(this).attr("data-resNo");
						console.log(resno);
						$(this).attr("src", root+"/resources/dislike_full.png");
						$.ajax({
							url : root + '/restaurant/like',
							type : 'post',
							dataType : 'json',
							data : {
								'userno' : userno,
								'resno' : resno,
								'likeno' : 0,
								'dislikeno' : 1
							}
						}).done(function() {
								console.log("dislike성공");
								location.reload();
	
							});
						
					}
					}
							});
									});