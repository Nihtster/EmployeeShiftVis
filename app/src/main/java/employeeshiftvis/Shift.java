package employeeshiftvis;

class Shift {
    int startHour; // Start hour
    int endHour; // End hour
    String person;

    public Shift(int startHour, int endHour, String person) {
        this.startHour = startHour;
        this.endHour = endHour;
        this.person = person;
    }
}
