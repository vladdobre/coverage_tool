import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;


/**
 * This class is used to store the coverage data for each function and write it to a file.
 */
public class BranchCoverageInstrumentation {
    public static Map<Integer, Boolean> coverageFunction1 = new HashMap<>();
    public static Map<Integer, Boolean> coverageFunction2 = new HashMap<>();
    public static Map<Integer, Boolean> coverageFunction3 = new HashMap<>();
    public static Map<Integer, Boolean> coverageFunction4 = new HashMap<>();
    public static Map<Integer, Boolean> coverageFunction5 = new HashMap<>();

    /**
     * This method is used to print the coverage data to a file.
     * @param coverageFunction The coverage data for a function
     * @param functionNumber The number of the function
     * @param numberOfBranches The number of branches in the function
     */
    public static void printCoverageDataToFile(Map<Integer, Boolean> coverageFunction, int functionNumber, int numberOfBranches) {
        try {
            FileWriter writer = null;
            String fileName = "coverageFunction" + functionNumber + "_data.txt";
            writer = new FileWriter(fileName);

            writer.write("#########Function" + functionNumber + "#########\n");

            int coveredBranches = 0;
            for (int i = 1; i <= numberOfBranches; i++) {
                boolean covered = coverageFunction.containsKey(i) ? coverageFunction.get(i) : false;
                writer.write("Branch " + i + ": " + (covered ? "Covered\n" : "Not Covered\n"));
                if (covered) {
                    coveredBranches++;
                }
            }

            writer.write("###########################\n");
            writer.write("Time: " + java.time.LocalTime.now() + "\n");
            writer.write("Branch Coverage Percentage: " + (coveredBranches * 100.0 / numberOfBranches) + "%\n");
            writer.close();
            System.out.println("Coverage data written to " + fileName);
        } catch (IOException e) {
             System.out.println("Error writing coverage data to file: " + e.getMessage());
        }
    }
}

