/*  
Ajax 三级省市联动    
日期：2012-7-18  
  
settings 参数说明    
-----  
prov:默认省份    
city:默认城市    
dist:默认地区（县）    
required:必选项    
------------------------------ */
(function($) {
	$.fn.citySelect = function(settings) {
		if (this.length < 1) {
			return;
		}
		;
		// 默认值
		settings = $.extend({
			prov : null,
			city : null,
			dist : null,
			required : false
		}, settings);

		var box_obj = this;
		prov_obj = box_obj.find(".prov");
		city_obj = box_obj.find(".city");
		dist_obj = box_obj.find(".dist");
		prov_val = settings.prov ? settings.prov : "北京";
		city_val = settings.city ? settings.city : "北京";
		dist_val = settings.dist ? settings.dist : "东城区";
		var select_prehtml = (settings.required) ? ""
				: "";

		// 赋值市级函数
		var cityStart = function() {
			city_obj.html("");
			prov_val = prov_obj.val() ? prov_obj.val() : prov_val;
			// 遍历赋值市级下拉列表
			temp_html = select_prehtml;
			$.each(threeSelectData, function(k, v) {
				if (k == prov_val) {
					if (v.items) {
						$.each(v.items, function(kt, vt) {
							if (kt == city_val) {
								temp_html += "<option value='" + kt
										+ "' selected='selected'>" + kt
										+ "</option>";
							} else {
								temp_html += "<option value='" + kt + "'>" + kt
										+ "</option>";

							}
						})
					}
				}

			});
			city_obj.html(temp_html);
			distStart();
		};

		// 赋值地区（县）函数
		var distStart = function() {

			// 清空city_select 下所有的信息
			dist_obj.html("");
			city_val = city_obj.val() ? city_obj.val() : city_val;
			// 遍历赋值市级下拉列表
			temp_html = select_prehtml;
			$.each(threeSelectData, function(k, v) {

				if (k == prov_val) {
					if (v.items) {
						$.each(v.items, function(kt, vt) {
							if (kt == city_val) {
								$.each(vt.items, function(ka, va) {
									if (ka == dist_val) {
										temp_html += "<option value='" + ka
												+ "' selected='selected'>" + ka
												+ "</option>";
									} else {
										temp_html += "<option value='" + ka
												+ "'>" + ka + "</option>";

									}
								})
							}

						})
					}
				}

			});
			dist_obj.html(temp_html);
		};

		var init = function() {
			// 遍历赋值省份下拉列表
			temp_html = select_prehtml;
			$.each(threeSelectData,
					function(k, v) {
						if (k == prov_val) {
							temp_html += "<option value='" + k
									+ "' selected='selected'>" + k
									+ "</option>";
						} else {
							temp_html += "<option value='" + k + "'>" + k
									+ "</option>";
						}

					});
			prov_obj.html(temp_html);

			// 若有传入省份与市级的值，则选中。（setTimeout为兼容IE6而设置）
			setTimeout(function() {
				if (settings.prov != null) {
					prov_obj.val(settings.prov);
					cityStart();
					setTimeout(function() {
						if (settings.city != null) {
							city_obj.val(settings.city);
							distStart();
							setTimeout(function() {
								if (settings.dist != null) {
									dist_obj.val(settings.dist);
								}
								;
							}, 1);
						}
						;
					}, 1);
				}
				;
			}, 1);

			// 选择省份时发生事件
			prov_obj.bind("change", function() {
				cityStart();
			});

			// 选择市级时发生事件
			city_obj.bind("change", function() {
				distStart();
			});
		};

		// 设置省市json数据

		init();
	};
})(jQuery);