public class TimeManager {
    private int time;
    private boolean isDayTime;

    public TimeManager(int time, boolean isDayTime) {
        this.time = time;
        this.isDayTime = isDayTime;
        updateDayTime(); // Initial day/night status based on the time
    }

    // Increment time by 1 hour and update day/night status
    public void incrementTime() {
        time = (time + 1) % 24; // Loop back to 0 after 23
        updateDayTime();
    }

    // Update day/night status based on time (e.g., day: 6 - 18, night: 19 - 5)
    private void updateDayTime() {
        isDayTime = time >= 6 && time < 18;
    }

    public int getTime() {
        return time;
    }

    public boolean isDayTime() {
        return isDayTime;
    }

    public void displayTime() {
        String period = isDayTime ? "Daytime" : "Nighttime";
        System.out.println("Current time: " + time + ":00 - " + period);
    }
}
