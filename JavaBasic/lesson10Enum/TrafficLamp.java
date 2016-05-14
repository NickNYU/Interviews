package lesson10Enum;

// 用子类调用父类的构造方法
// 相当于匿名类的初始化


public enum TrafficLamp {
	Red (30){
		@Override
		public TrafficLamp getNext() {
			return Green;
		}
	}, 
	Yellow (15) {
		@Override
		public TrafficLamp getNext() {
			return Red;
		}
	}, 
	Green (45) {
		@Override
		public TrafficLamp getNext() {
			return Yellow;
		}
	};
	private int time;
	private TrafficLamp(int time) {
		this.time = time;
	}
	public abstract TrafficLamp getNext();
}
