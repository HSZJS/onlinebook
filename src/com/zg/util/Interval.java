package com.zg.util;

import java.util.Date;

public class Interval {
	private long nd = 1000*24*60*60;//һ��ĺ�����
	private long nh = 1000*60*60;//һСʱ�ĺ�����
	private long nm = 1000*60;//һ���ӵĺ�����
	private long ns = 1000;//һ��ĺ�����
	private long diff;
	public String getTwoDay(Date startTime,Date endTime){
		//SimpleDateFormat sd = new SimpleDateFormat(format);
		//�������ʱ��ĺ�����
		diff = startTime.getTime()-endTime.getTime();
		long day = diff/nd;//������˼���
		long hour = diff%nd/nh;//������˼���Сʱ
		long minute = diff%nd%nh/nm;//������˼�����
		long second = diff%nd%nh%nm/ns;//������˼���
		String interval = day+"��"+hour+"ʱ"+minute+"��"+second+"��";
		return interval.replace('-', ' ');
	}
}
