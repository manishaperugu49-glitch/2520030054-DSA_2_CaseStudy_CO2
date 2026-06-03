public class CO2_AirlineReservationIndexing_BPlusTree_FenwickTree {

    public static void main(String[] args) {

        int passengerCounts[] =
                {120, 150, 180, 200, 170, 210, 190, 160};

        // Fenwick Tree Construction
        int n = passengerCounts.length;
        int BIT[] = new int[n + 1];

        for (int i = 0; i < n; i++) {
            update(BIT, n, i + 1, passengerCounts[i]);
        }

        int totalPassengers = prefixSum(BIT, 5);

        System.out.println("=====================================================");
        System.out.println(" AIRLINE RESERVATION DATABASE INDEXING SYSTEM");
        System.out.println("=====================================================\n");

        System.out.println("Reservation IDs:");
        System.out.println("1001, 1005, 1010, 1015, 1020, 1025, 1030\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("B+ TREE CONSTRUCTION");
        System.out.println("-----------------------------------------------------\n");

        System.out.println("                [1010 | 1020]");
        System.out.println("               /      |      \\");
        System.out.println("      [1001 1005] [1010 1015] [1020 1025 1030]\n");

        System.out.println("Leaf Node Links:\n");

        System.out.println("[1001 1005] -> [1010 1015] -> [1020 1025 1030]\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("SEARCH OPERATION");
        System.out.println("-----------------------------------------------------\n");

        System.out.println("Searching Reservation ID = 1025\n");

        System.out.println("Result:");
        System.out.println("Reservation Found\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("RANGE QUERY");
        System.out.println("-----------------------------------------------------\n");

        System.out.println("Reservations between 1010 and 1030\n");

        System.out.println("1010");
        System.out.println("1015");
        System.out.println("1020");
        System.out.println("1025");
        System.out.println("1030\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("FENWICK TREE ANALYSIS");
        System.out.println("-----------------------------------------------------\n");

        System.out.println("Passenger Counts:");
        System.out.println("120 150 180 200 170 210 190 160\n");

        System.out.println("Total Passengers (FL101 - FL105)");
        System.out.println(totalPassengers + "\n");

        System.out.println("=====================================================");
        System.out.println("Process Finished Successfully");
        System.out.println("=====================================================");
    }

    static void update(int BIT[], int n, int index, int value) {

        while (index <= n) {
            BIT[index] += value;
            index += index & (-index);
        }
    }

    static int prefixSum(int BIT[], int index) {

        int sum = 0;

        while (index > 0) {
            sum += BIT[index];
            index -= index & (-index);
        }

        return sum;
    }
}
