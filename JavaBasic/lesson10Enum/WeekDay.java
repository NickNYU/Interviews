package lesson10Enum;

public abstract class WeekDay {
	private WeekDay(){}
	// 匿名类的实例化
	public final static WeekDay Mon = new WeekDay(){
		@Override
		public WeekDay nextDay() {
			return WeekDay.Sun;
		}
	};
	public final static WeekDay Sun = new WeekDay(){
		@Override
		public WeekDay nextDay() {
			return WeekDay.Mon;
		}
	};
	
	public abstract WeekDay nextDay();
}
