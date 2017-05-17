/**
 * @author sushseqi
 *
 */

public class HighestTruncatedPyramid_Impl implements HighestTruncatedPyramid_ {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int N = Integer.parseInt(args[0]);

        int maxLineParam[] = findMaxLineParam(N);

        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < maxLineParam[0]; i++) {
            result.append(generateLine(maxLineParam[1]));
            if (i != maxLineParam[0]) {
                result.append(System.getProperty("line.separator"));
                ;
            }
            maxLineParam[1]++;
        }
        System.out.println(result.toString());
    }

    public static StringBuilder generateLine(int m) {
        StringBuilder res = new StringBuilder("");
        String brick = "*";
        if (m == 0) {
            return res;
        } else {
            for (int i = 0; i < m; i++) {
                res.append(brick);
            }
            return res;
        }
    }

    public static int[] findMaxLineParam(int N) {
        int maxLineNumber = 0;
        int maxLineBrickNumber = 0;
        int firstBrickNumber = 0;
        int linesTotalBrickNumber = 0;
        int maxborder = (int) Math.sqrt(N);

        for (int i = 1; i <= maxborder + 1; i++) {
            firstBrickNumber = findFirstLineBrickNumber(N, i);
            linesTotalBrickNumber = 0;

            for (int j = 0; j < i; j++) {
                linesTotalBrickNumber += firstBrickNumber + j;
            }
            if ((linesTotalBrickNumber == N) && (maxLineNumber < i)) {
                maxLineNumber = i;
                maxLineBrickNumber = firstBrickNumber;
            }
        }
        int[] res = { maxLineNumber, maxLineBrickNumber };
        return res;
    }

    public static int findFirstLineBrickNumber(int N, int i) {
        int lineBrickNumber = (2 * N - (i - 1) * (i - 1)) / (2 * i);
        return lineBrickNumber;

    }
}
