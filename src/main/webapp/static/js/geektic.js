$(document).ready(function () {
	
	/* SEARCH */
	$(".search-geeks").on("click", "li", function () {
		var $this = $(this);
		if($this.hasClass('clicked'))
			$(".search-geeks").find("select option[value=" + $this.attr('id') + "]")
							  .removeAttr('selected', 'selected');
		else
			$(".search-geeks").find("select option[value=" + $this.attr('id') + "]")
			  .attr('selected', 'selected');
		$this.toggleClass("clicked");
	});
	
	
	$("#search").ajaxForm({
		beforeSubmit: function () {
			if($('select option:selected').length === 0 && $('[name=gender]:checked').length === 0)
				return false;
		},
		dataType: 'json',
		success : function (res) {
			var wrapper_div = $('<div>', {'id': 'list-geeks'});
			if($.isArray(res))
				if(res.length>0)
					$.each(res, function (i, geek) {
						var div = $('<div>');
						var a = $('<a>', {'href': '/geektic/geeks/' + geek.id, 'class': geek.gender ? 'female' : 'male'})
								.text(geek.firstname + " " + geek.lastname)
								.appendTo(div);
						var avatar = geek.avatar != null ? geek.avatar : '/geektic/static/images/unknown.gif';
						var figure = '<figure><img src="'+ avatar +'"/></figure>';
						div.append(figure);
						div.appendTo(wrapper_div);
						var interest_title = $('<span>', {'class': 'list-title'}).text("Centres d'intérêt").appendTo(div);
						var ul = $('<ul>');
						$.each(geek.interestNames, function(i, interestName) {
							$('<li>').html(interestName).appendTo(ul);
						});
						ul.appendTo(div);
					});
				else
					wrapper_div.append("Pas de résultat.");
			else
				if(!$.isEmptyObject(res)) {
					var geek = res;
					var div = $('<div>');
					var a = $('<a>', {'href': '/geektic/geeks/' + geek.id, 'class': geek.gender ? 'female' : 'male'})
							.text(geek.firstname + " " + geek.lastname)
							.appendTo(div);
					var avatar = geek.avatar != null ? geek.avatar : '/geektic/static/images/unknown.gif';
					var figure = '<figure><img src="'+ avatar +'"/></figure>';
					div.append(figure);
					div.appendTo(wrapper_div);
					var interest_title = $('<span>', {'class': 'list-title'}).text("Centres d'intérêt").appendTo(div);
					var ul = $('<ul>');
					$.each(geek.interestNames, function(i, interestName) {
						$('<li>').html(interestName).appendTo(ul);
					});
					ul.appendTo(div);
				}
				else
					wrapper_div.append("Pas de chance ...");
			var h3 = $('<h3>').text("Résultat de la recherche : ");
			$(".search-result").html(h3.html()).append(wrapper_div);
		}
	});
	
});
