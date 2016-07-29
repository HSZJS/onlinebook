package com.zg.util;

import java.util.Date;

public class Interval {
	private long nd = 1000*24*60*60;//一天的毫秒数
	private long nh = 1000*60*60;//一小时的毫秒数
	private long nm = 1000*60;//一分钟的毫秒数
	private long ns = 1000;//一秒的毫秒数
	private long diff;
	public String getTwoDay(Date startTime,Date endTime){
		//SimpleDateFormat sd = new SimpleDateFormat(format);
		//获得两个时间的毫秒差距
		diff = startTime.getTime()-endTime.getTime();
		long day = diff/nd;//计算差了几天
		long hour = diff%nd/nh;//计算差了几个小时
		long minute = diff%nd%nh/nm;//计算差了几分钟
		long second = diff%nd%nh%nm/ns;//计算差了几秒
		String interval = day+"天"+hour+"时"+minute+"分"+second+"秒";
		return interval.replace('-', ' ');
	}
}
