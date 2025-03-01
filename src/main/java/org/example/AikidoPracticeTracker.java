package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AikidoPracticeTracker {
    private List<PracticeSession> sessions = new ArrayList<>();
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate currentDate = LocalDate.now();

    public void addSession(String date, int duration) {
        try {
            LocalDate.parse(date, DATE_FORMATTER); // Validate date format
            sessions.add(new PracticeSession(date, duration));
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
        }
    }

    public int getTotalPracticeTime() {
        return sessions.stream().mapToInt(PracticeSession::getDuration).sum();
    }

    public boolean isEligibleForGraduation() {
        if (sessions.isEmpty()) {
            return false;
        }
        LocalDate firstSessionDate = LocalDate.parse(sessions.get(0).getDate(), DATE_FORMATTER);

        // Extract year and month from the dates
        int firstYear = firstSessionDate.getYear();
        int firstMonth = firstSessionDate.getMonthValue();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();


        // Calculate the number of months between the two dates
        long monthsBetween = (currentYear - firstYear) * 12L + (currentMonth - firstMonth);
        return monthsBetween >= 6 || sessions.size() >= 100;
    }

    // Method to set the current date for testing purposes
    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public static void main(String[] args) {
        AikidoPracticeTracker tracker = new AikidoPracticeTracker();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===== Aikido Practice Tracker =====");
            System.out.println("1. Add Practice Session");
            System.out.println("2. View Total Practice Time");
            System.out.println("3. Check Graduation Eligibility");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter duration (in hours): ");
                    int duration = scanner.nextInt();
                    tracker.addSession(date, duration);
                    break;
                case 2:
                    System.out.println("Total Practice Time: " + tracker.getTotalPracticeTime() + " hours");
                    break;
                case 3:
                    if (tracker.isEligibleForGraduation()) {
                        System.out.println("You are eligible for Kyu graduation!");
                    } else {
                        System.out.println("You are not eligible for Kyu graduation.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

