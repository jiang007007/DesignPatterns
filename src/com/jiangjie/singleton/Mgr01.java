package com.jiangjie.singleton;

/**
 * 饿汉模式
 * 	类加载到内存后,实例化一个单例   JVM保证线程安全
 * 
 * 唯一缺点 : 不管用到与否 类装载时就完成实例化
 * @author jiangjie
 *
 */
public class Mgr01 {
	private static final Mgr01 INSTANCE = new Mgr01();
	
	public static Mgr01 getInstance() {
		return INSTANCE;
	}
	private Mgr01() {
		
	}
	
	public static void main(String[] args) {
//		Mgr01 m1 = Mgr01.getInstance();
//		Mgr01 m2 = Mgr01.getInstance();
//		System.out.println(m1 == m2);
		for(int i =0; i < 100; i++) {
			new Thread(
					()->{
						System.out.println(Mgr01.getInstance().hashCode());
					}
					).start();
		}
	}
}
