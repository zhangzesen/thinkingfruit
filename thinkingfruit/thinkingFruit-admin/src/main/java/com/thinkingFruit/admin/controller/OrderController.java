package com.thinkingFruit.admin.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.thinkingFruit.admin.entity.Order;
import com.thinkingFruit.admin.service.OrderService;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.result.Results;
import com.ysdevelop.common.utils.DateUtil;
import com.ysdevelop.common.utils.ExportExcel;
import com.ysdevelop.common.utils.HttpUtils;

/**
 * @author zhangzesen
 *
 * @date 2018年11月21日
 *
 * @package com.thinkingFruit.admin.controller
 *
 * @description 订单
 */
@Controller
@RequestMapping(value="/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	/**
	 * 	跳到订单首页
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String orderIndex(){
		return "order/index";
	}
	
	/**
	 * 	跳到订单详情页或取消页或发货页
	 * @return
	 */
	@RequestMapping(value = "/set", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String info(){
		return "order/info";
	}
	
	/**
	 * 	获取订单分页
	 * @param request
	 * @return 订单集合
	 */
	@RequestMapping(value = "/pagination", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody
	public Results<List<Order>> pagination(HttpServletRequest request){		
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		PageInfo<Order> pageInfo =orderService.paginationOrder(queryMap);
		return Results.successPaginationData(pageInfo.getList(), pageInfo.getTotal());
	}
	

	/**
	 * 	获取订单详情
	 * @param id 订单id
	 * @return 订单
	 */
	@RequestMapping(value = "/info", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<Order> info(@RequestParam(value = "id") Long id){
		Order order = orderService.findOrderById(id);
		return Results.successData(order);
	}
	
	/**
	 * 	发货
	 * @param order 订单
	 * @return 成功跳转到订单首页
	 */
	@RequestMapping(value = "/deliver", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<String> edit(Order order){
		orderService.updateOrderStatus(order);
		return Result.success("发货成功");
	}
	
	/**
	 * 取消订单
	 * @param order 订单
	 * @return 取消成功返回订单首页
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<String> cancel(Order order){
		orderService.cancalOrder(order);
		return Result.success("取消成功");
	}
	
	/**
	 * 	导出excel
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "export", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public ResponseEntity<byte[]> export(HttpServletRequest request) throws IOException {
		// 服务器路径
		String realPath = HttpUtils.getRealPath(request);
		String currentDate = DateUtil.COMMON.getFormat().format(new Date());
		// 目录
		String catalogue = realPath + "export" + ExportExcel.FILE_SEPARATOR;
		if (!new File(catalogue).exists()) {
			new File(catalogue).mkdir();
		}
		// 文件
		String fileName = "report_" + currentDate + ".xls";
		File file = new File(catalogue + fileName);
		if (!file.exists()) {
			file.createNewFile();
		}
		OutputStream out = null;
		try {
			out = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		System.out.println(queryMap.get("orderNo")+queryMap.get("startTime")+queryMap.get("nickName")+queryMap.get("orderStatus"));
		List<Order> reports = orderService.findOrderExcl(queryMap);
		ExportExcel<Order> reportExcel = new ExportExcel<>();
//		reports.get(0).getOrderItems().get(0).getCommodityName();
		String[] headers = { "ID", "订单号", "收件人", "手机号", "地址" ,"备注","订单状态","商品名","商品数量"};
		String[] paramaters = { "id", "orderNo", "orderMemberName", "mobile", "allAddress","remark","orderStatus","commodityName","commodityCount" };
		reportExcel.exportExcel("报表列表", headers, paramaters, reports, out);
		if (out != null) {
			out.close();
		}

		HttpHeaders exportFileHeaders = new HttpHeaders();
		String exportFileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");// 为了解决中文名称乱码问题
		exportFileHeaders.setContentDispositionFormData("attachment", exportFileName);
		exportFileHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), exportFileHeaders, HttpStatus.CREATED);
	}
	
}
