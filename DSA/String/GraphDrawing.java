
import java.util.Scanner;

public class GraphDrawing {

    public static void calculateDegree(String[] edges, int[] degrees) {
        int edgeWithVertex1, edgeWithVertex2, noOfParallelEdges;
        for (int i = 0; i < edges.length; i++) {
            edgeWithVertex1 = (edges[i].charAt(0) - '0') - 1;
            edgeWithVertex2 = (edges[i].charAt(1) - '0') - 1;
            noOfParallelEdges = (edges[i].charAt(2) - '0') - 1;
            for (int j = 0; j < noOfParallelEdges; j++) {
                degrees[edgeWithVertex1]++;
                degrees[edgeWithVertex2]++;
            }
            degrees[edgeWithVertex1]++;
            degrees[edgeWithVertex2]++;

        }
    }

    public static int getOddDegreeCount(int[] degrees) {
        int oddDegreeCount = 0;
        for (int degree : degrees) {
            if (degree % 2 != 0) {
                oddDegreeCount++;
            }
        }

        return oddDegreeCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertexCount = sc.nextInt();
        int edgeCount = sc.nextInt();

        int[] vertexDegrees = new int[vertexCount];

        String[] edges = new String[edgeCount];
        for (int i = 0; i < edgeCount; i++) {
            edges[i] = sc.next();
        }

        calculateDegree(edges, vertexDegrees);

        for (int degree : vertexDegrees) {
            System.out.print(degree + " ");
        }

        int oddDegreeCount = getOddDegreeCount(vertexDegrees);

        if (oddDegreeCount == 0 || oddDegreeCount == 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
