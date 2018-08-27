$(function() 
{
	var page = 1;
	var mylastPage=0;
	
	fenye(page);
	$('#btn1').on("click", function() {
		if (page == 1) {
			alert("当前第一页")
		} else {
			page -= 1;
			fenye(page);
		}

	})
	$('#btn2').on("click", function() {
		if (page == mylastPage) {
			alert("已经是最后页")
		} else {
			page += 1;
			fenye(page);
		}
	});
	
	function fenye(page) {
		$.ajax({
			type : "post",
			url : "http://127.0.0.1:8080/demo/select?page=" + page + "&pageSize=3",
			async : true,
			success : function(data) {
				mylastPage=data.lastPage;
				$('#tab1').html("");
				$.each(data.list, function(name, value) {
					$('#tab1').append(
							"<tr><td>" + value.name + "</td><td>" + value.pass
									+ "</td></tr>")
				});
			}
		});
	}
});
//------------------------jquery------结束----------------

