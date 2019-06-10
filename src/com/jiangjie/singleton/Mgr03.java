package com.jiangjie.singleton;

/**
 * lazy loading
 * 通过减小同步代码块的方式提高效率
 * @author jiangjie
 * volatile 保证可见性  不保证原子性
 */
public class Mgr03 {
	private static volatile Mgr03 INSTANCE;
	private Mgr03() {
		
	}
	//双重枷锁
	private static Mgr03 getInstance() {
		if(INSTANCE == null) {
			synchronized(Mgr03.class) {
				if(INSTANCE == null) {
					INSTANCE = new Mgr03();
				}
			}
		}
		return INSTANCE;
	}
	public static void main(String[] args) {
		for(int i=0; i< 100;i++) {
			new Thread(
					()->{
						System.out.println(Mgr03.INSTANCE.hashCode());
					}
					).start();
		}
	}
}
