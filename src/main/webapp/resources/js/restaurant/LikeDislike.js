
	$(document).ready(function() {
				$("[id^=like-img]").on('click', function(event) {
					event.preventDefault();

					console.log("로그인해야함" + userno);
					if(userno == null) {
					console.log("로그인해야함");
					console.log("로그인해야함" + userno);
							swal({
									  title: "로그인 후에 이용할 수 있습니다",
									  icon: "warning",
									  buttons: {
											  confirm : {
								  text : '로그인',
								  value : true,
								  className : 'btn btn-info'
							  },
							  cancle : {
								  text : '취소',
								  value : false,s
								  className : 'btn btn-secondary'
							  }
									  }
								
								}).then((result) => {
									console.log(result);
									if(result) {
									 location.href = root + '/member/login';
									}
								});


					} else {
					console.log("로그인 된 상태");
					console.log("로그인 된 상태" + userno);
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
						}).done(function(data) {
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
					}

				});

				$("[id^=dislike-img]").on('click', function(event) {
							event.preventDefault();
						if(userno == '' || userno == null) {
										swal({
									  title: "로그인 후에 이용할 수 있습니다",
									  icon: "warning",
									  buttons: {
											  confirm : {
								  text : '로그인',
								  value : true,
								  className : 'btn btn-info'
							  },
							  cancle : {
								  text : '취소',
								  value : false,
								  className : 'btn btn-secondary'
							  }
									  }
								
								}).then((result) => {
									console.log(result);
									if(result) {
									 location.href = root + '/member/login';
									}
								});
					} else {
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