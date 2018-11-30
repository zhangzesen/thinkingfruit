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
import com.thinkingFruit.admin.entity.PurchaseOrder;
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
 * @description 交易订单
 */
@Controller
@RequestMapping(value="/purchase")
public class PurchaseOrderController {
	
	@Autowired
	OrderService orderService;
	
	/**
	 * 	跳到交易订单首页
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String orderIndex(){
		return "purchaseOrder/index";
	}
	
	/**
	 * 	获取购买订单分页
	 * @param request
	 * @return 订单集合
	 */
	@RequestMapping(value = "/pagination", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody
	public Results<List<PurchaseOrder>> pagination(HttpServletRequest request){		
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		PageInfo<PurchaseOrder> pageInfo =orderService.paginationPurchaseOrder(queryMap);
		return Results.successPaginationData(pageInfo.getList(), pageInfo.getTotal());
	}
	
	/**
	 * 跳转到查看详情，发货购买订单界面
	 * @return
	 */
	@RequestMapping(value = "/set", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String info(){
		return "purchaseOrder/info";
	}
	
	/**
	 * 查看购买订单详情
	 * @param id
	 * @return 购买订单
	 */
	@RequestMapping(value = "/info", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Results<PurchaseOrder> info(@RequestParam(value = "id") Long id){
		PurchaseOrder order = orderService.findPurchaseOrderById(id);
		return Results.successData(order);
	}
	
	/**
	 * 购买订单发货
	 * @param id 订单id
	 * @return
	 */
	@RequestMapping(value = "/deliver", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<String> edit(@RequestParam(value = "id") Long id,@RequestParam(value = "commodityCount")Long commodityCount){
		orderService.updatePurchaseOrderStatus(id,commodityCount);
		return Result.success("发货成功");
	}
	
	/**
	 * 取消订单
	 * @param id 订单id
	 * @return
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<String> cancel(@RequestParam(value = "id") Long id,@RequestParam(value = "commodityCount")Long commodityCount){
		orderService.cancelPurchaseOrderStatus(id,commodityCount);
		return Result.success("取消订单成功");
	}
	
	/**
	 * 	导出excel
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/export", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
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
		System.out.println(queryMap.get("orderNo")+"=="+queryMap.get("startTime")+"=="+queryMap.get("orderMemberName")+"=="+queryMap.get("orderStatus"));
		System.out.println("queryMap"+queryMap);
		List<PurchaseOrder> reports = orderService.findPurchaseOrderExcl(queryMap);
		for (PurchaseOrder purchaseOrder : reports) {
			System.out.println("id"+purchaseOrder.getId()+"====="+purchaseOrder.getOrderNo());
		}
		ExportExcel<PurchaseOrder> reportExcel = new ExportExcel<>();
//		reports.get(0).getOrderItems().get(0).getCommodityName();
		String[] headers = { "ID", "订单号", "代理人", "代理等级", "邀请者id" ,"分佣","订单状态","商品名","商品数量","创建时间"};
		String[] paramaters = { "id", "orderNo", "orderMemberName", "memberLevelName", "inviterId","superiorProportion","orderStatus","commodityName","commodityCount","createTime" };
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