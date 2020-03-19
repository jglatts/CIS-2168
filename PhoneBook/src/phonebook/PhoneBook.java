package phonebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PhoneBook {
    private FastScanner in = new FastScanner();
    private Map<Integer, Contact> contactMap = new TreeMap<>();
    //private Set<Contact> contactSet = new HashSet<>();
    
    public static void main(String[] args) {
        // start timer
        final long startTime = System.currentTimeMillis();

        // process the queries
        new PhoneBook().processQueries();

        // end the timer and print the result
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

    private void writeResponse(String response) { System.out.println(response); }

    private void processQuery(Query query) {
        switch (query.type) {
            case "add":
                contactMap.put(query.number, new Contact(query.name, query.number));
                //contactSet.add(new Contact(query.name, query.number));
                break;
            case "del":
                contactMap.remove(query.number);
                //contactSet.remove(query.number);
                break;
            default:
                String response = "not found";
                if (contactMap.containsKey(query.number)) {
                    response = contactMap.get(query.number).name;
                }   
                writeResponse(response);
                break;
        }
    }

    public void processQueries() {
        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i)
            processQuery(readQuery());
    }

    static class Contact {
        String name;
        int number;

        public Contact(String name, int number) {
            this.name = name;
            this.number = number;
        }
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

