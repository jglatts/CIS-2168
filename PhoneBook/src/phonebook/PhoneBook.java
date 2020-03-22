package lab_sevenb;
    
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PhoneBook {
    private FastScanner in = new FastScanner();
    private Map<Integer, String> contactMap = new HashMap<>();
    private String outString = "";
    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        new PhoneBook().processQueries();
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime)/1000F + " seconds.");
    }

    private Query readQuery() {
        String type = in.next();
        int number = in.nextInt();
        if (type.equals("add")) {
            String name = in.next();
            return new Query(type, name, number);
        } 
        else return new Query(type, number);
    }

    private void createResponse(String response) { outString += response + "\n"; }

    private void processQuery(Query query) {
        switch (query.type) {
            case "add":
                contactMap.put(query.number, query.name);
                break;
            case "del":
                contactMap.remove(query.number);
                break;
            default:
                createResponse(contactMap.getOrDefault(query.number, "not found"));
                break;
        }
    }

    public void processQueries() {
        int queryCount = in.nextInt();
        System.out.println("Processing " + queryCount + " Queries...");
        for (int i = 0; i < queryCount; ++i) processQuery(readQuery());
        System.out.println(outString);
    }

    static class Query {
        String type;
        String name;
        int number;

        public Query(String type, String name, int number) {
            this.type = type;
            this.name = name;
            this.number = number;
        }

        public Query(String type, int number) {
            this.type = type;
            this.number = number;
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

