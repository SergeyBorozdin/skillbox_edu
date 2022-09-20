public class MassiveMassives {

    public static void main(String[] args) {
        int[][] studentsMarks = {
                {4, 5, 2, 3},
                {2, 4, 5, 5, 4, 2},
                {3, 4, 3, 3, 1},
                {3, 3, 5, 2, 1}
        };
//        for (int i = 0; i < studentsMarks.length; i++) {
//            System.out.println("\nclass - " + i + ", count students - " + studentsMarks[i].length);
//            for (int j = 0; j < studentsMarks[i].length; j++) {
//                System.out.print("\t" + studentsMarks[i][j] + ", ");
//            }
//        }
        for (int i = 0; i < studentsMarks.length; i++) {
            for (int j = 0; j < studentsMarks[i].length; j++) {
                System.out.print(studentsMarks[i][j] + " ");
            }
            System.out.println();
        }
    }
}
