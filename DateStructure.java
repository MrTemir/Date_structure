
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Date implements Comparable<Date> {
    int day, month, year;
    String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String days[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean isValidDate() {
        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1) {
            return false;
        }
        if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                if (day > 29) {
                    return false;
                }
            } else {
                if (day > 28) {
                    return false;
                }
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day > 30) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int compareTo(Date other) {
        if (this.year != other.year) {
            return this.year - other.year;
        }
        if (this.month != other.month) {
            return this.month - other.month;
        }
        return this.day - other.day;
    }

    public void printDate() {
        if (isValidDate()) {
            System.out.println(months[month - 1] + " " + day + ", " + year);
        } else {
            System.out.println("Invalid date");
        }
    }

    public void updateDate(int d, int m, int y) {
        if (new Date(d, m, y).isValidDate()) {
            this.day = d;
            this.month = m;
            this.year = y;
            System.out.println("Date updated to " + day + "/" + month + "/" + year);
        } else {
            System.out.println("Invalid date");
        }
    }

    public void getDayOfWeek() {
        if (isValidDate()) {
            int y0 = year - (14 - month) / 12;
            int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
            int m0 = month + 12 * ((14 - month) / 12) - 2;
            int d0 = (day + x + (31 * m0) / 12) % 7;
            System.out.println("Day of the week: " + days[d0]);
        } else {
            System.out.println("Invalid date");
        }
    }

    public void calculateDifference(Date other) {
        if (this.isValidDate() && other.isValidDate()) {
            int days1 = this.year * 365 + this.month * 30 + this.day;
            int days2 = other.year * 365 + other.month * 30 + other.day;
            int diff = Math.abs(days1 - days2);
            System.out.println("Difference between dates is " + diff + " days");
        } else {
            System.out.println("One or both dates are invalid");
        }
    }

    public static void sortDates(List<Date> dates) {
        Collections.sort(dates);
    }
}

public class DateStructure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Date> dates = new ArrayList<>();
        Date currentDate = null; // Последняя введенная дата
        boolean stop = true;

        while (stop) {
            if (currentDate == null) {
                System.out.println("Enter the date in the format dd mm yyyy:");
                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    sc.next();
                    continue;
                }
                int day = sc.nextInt();
                int month = sc.nextInt();
                int year = sc.nextInt();
                currentDate = new Date(day, month, year);

                if (currentDate.isValidDate()) {
                    dates.add(currentDate);
                } else {
                    System.out.println("Invalid date. Not added to the list.");
                    currentDate = null;
                    continue;
                }
            }

            System.out.println("1. Add another date\n2. Check if the current date is valid\n3. Update the current date\n4. Get the day of the week\n5. Calculate the difference between two dates\n6. Print the current date\n7. Sort dates\n8. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the new date in the format dd mm yyyy:");
                    int newDay = sc.nextInt();
                    int newMonth = sc.nextInt();
                    int newYear = sc.nextInt();
                    currentDate = new Date(newDay, newMonth, newYear);

                    if (currentDate.isValidDate()) {
                        dates.add(currentDate);
                        System.out.println("Date added successfully.");
                    } else {
                        System.out.println("Invalid date. Not added to the list.");
                        currentDate = null;
                    }
                    break;
                case 2:
                    if (currentDate.isValidDate()) {
                        System.out.println("The current date is valid.");
                    } else {
                        System.out.println("The current date is invalid.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the new date in the format dd mm yyyy:");
                    int updateDay = sc.nextInt();
                    int updateMonth = sc.nextInt();
                    int updateYear = sc.nextInt();
                    currentDate.updateDate(updateDay, updateMonth, updateYear);
                    break;
                case 4:
                    currentDate.getDayOfWeek();
                    break;
                case 5:
                    System.out.println("Enter the second date in the format dd mm yyyy:");
                    int secondDay = sc.nextInt();
                    int secondMonth = sc.nextInt();
                    int secondYear = sc.nextInt();
                    Date secondDate = new Date(secondDay, secondMonth, secondYear);
                    currentDate.calculateDifference(secondDate);
                    break;
                case 6:
                    currentDate.printDate();
                    break;
                case 7:
                    if (dates.isEmpty()) {
                        System.out.println("No dates to sort.");
                    } else {
                        Date.sortDates(dates);
                        System.out.println("Sorted dates:");
                        for (Date d : dates) {
                            d.printDate();
                        }
                    }
                    break;
                case 8:
                    stop = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}