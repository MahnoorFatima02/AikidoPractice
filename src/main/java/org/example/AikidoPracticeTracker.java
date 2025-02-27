package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AikidoPracticeTracker {
    private List<PracticeSession> sessions = new ArrayList<>();

    public void addSession(String date, int duration) {
        sessions.add(new PracticeSession(date, duration));
    }

    public int getTotalPracticeTime() {
        return sessions.stream().mapToInt(PracticeSession::getDuration).sum();
    }

    public boolean isEligibleForGraduation() {
        return getTotalPracticeTime() >= 100; // Assuming 100 hours required for Kyu graduation
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