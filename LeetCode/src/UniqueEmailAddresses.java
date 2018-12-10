import java.util.*;

public class UniqueEmailAddresses {

    public static int countUnique(String[] emails) {
        Set<String> uniqueEmails = new HashSet<String>();

        for (String email : emails) {
            String[] emailParts = email.split("@");
            String[] removePlus = emailParts[0].split("\\+");
            String cleanEmail = removePlus[0].replace(".", "") + "@" + emailParts[1];
            uniqueEmails.add(cleanEmail);
        }
        return uniqueEmails.size();
    }

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(countUnique(emails));
    }
    }
