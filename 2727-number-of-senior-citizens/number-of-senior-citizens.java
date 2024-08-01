/*class Solution {
    public int countSeniors(String[] details) {
        
    }
}*/
public class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String detail : details) {
            String ageStr = detail.substring(11, 13);
            int age = Integer.parseInt(ageStr);
            if (age > 60) {
                count++;
            }
        }
        return count;
    }
}

   /* public static void main(String[] args) {
        String[] details = {
            "1234567890M6050", // Age: 60 (not more than 60)
            "9876543210F6165", // Age: 61 (more than 60)
            "2345678901M7080"  // Age: 70 (more than 60)
        };

        int count = countPassengersAbove60(details);
        System.out.println("Passengers above 60: " + count);
    }
}*/
