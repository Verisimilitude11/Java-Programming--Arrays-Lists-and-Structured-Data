import java.util.ArrayList;
import edu.duke.FileResource;

public class LogAnalyzer {
    private ArrayList<LogEntry> records;

    public LogAnalyzer() {
        records = new ArrayList<LogEntry>();
    }

    public void readFile(String filename) {
        FileResource fr = new FileResource(filename);
        for (String line : fr.lines()) {
            LogEntry le = WebLogParser.parseEntry(line);
            records.add(le);
        }
    }

    public int countUniqueIPs() {
        ArrayList<String> uniqueIPs = new ArrayList<>();
        for (LogEntry le : records) {
            String ip = le.getIpAddress();
            if (!uniqueIPs.contains(ip)) {
                uniqueIPs.add(ip);
            }
        }
        return uniqueIPs.size();
    }

    public void printAll() {
        System.out.println("All Log Entries:");
        System.out.println("------------------------------");
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }

}
