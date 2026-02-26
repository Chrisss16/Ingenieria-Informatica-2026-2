import java.util.Calendar;

public class Clock {
	int hours;
	int minutes;
	int seconds;
	
	public Clock() {
		Calendar date = Calendar.getInstance();
		
		hours = date.get(Calendar.HOUR);
		minutes = date.get(Calendar.MINUTE);
		seconds = date.get(Calendar.SECOND);
	}
	
	public Clock(int hours, int minutes, int seconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	public void setTime(int hours, int minutes, int seconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	public int getHour() {
		return hours;
	}
	
	public int getMinutes() {
		return minutes;
	}
	
	public int getSeconds() {
		return seconds;
	}
	
	public void printTime() {
		System.out.print(hours + ":" + minutes + ":" + seconds);
	}
	
	public void incrementHours() {
		++hours;
	}
	
	public void incrementMinutes() {
		++minutes;
	}
	
	public void incrementSeconds() {
		++seconds;
	}
	
	public boolean compareTime(Clock clock) {
		return 	clock.getHour() == hours &&
				clock.getMinutes() == minutes &&
				clock.getSeconds() == seconds;
	}
	
	public void copyTime(Clock clock) {
		hours = clock.getHour();
		minutes = clock.getMinutes();
		seconds = clock.getSeconds();
	}
	
	public Clock returnCopyTime() {
		return new Clock();
	}

}