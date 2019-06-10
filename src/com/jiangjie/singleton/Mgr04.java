package com.jiangjie.singleton;

/**
 * 静态内部类
 * JVM保证单例
 * 加载外部类时 不会加载内部类   这样可以实现lazy loading
 * @author jiangjie
 *
 */
public class Mgr04 {
	private Mgr04() {
		
	}
	
	private static class Mgr04Holder {
		private final static Mgr04 INSTANCE = new Mgr04();   
	}
	
	public static Mgr04 getInstance() {
		return Mgr04Holder.INSTANCE;
	}
	public static void main(String[] args) {
		for(int i=0;i<100;i++) {
			new Thread(
					()->{
						System.out.println(Mgr04.getInstance().hashCode());
					}
					).start();
		}
	}
}

