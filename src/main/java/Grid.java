public class Grid {

    public String getRows(){

        return "";
    }
    public String getColumns(){

        return "";
    }

    public String getDiag(){

        return "";
    }

    public void addToken(int column, char character){

        if (column > 7)
            throw new RuntimeException(String.format("Column %s doesn't exist", column));

        int lineIndex = 99;
        for (int i = 0; i < 6; i++){
            if(matrix[i][column] == '.'){
                lineIndex = i;
            }
        }
        if(lineIndex >= 6)
            throw new RuntimeException(String.format("Column %s is full", column));

        matrix[lineIndex][column] = character;

    }
    private final char[][] matrix = new char[6][7];

    public Grid(){
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 7; j++)
                matrix[i][j] = '.';
    }

    public int getLinesSize() {
        return matrix.length;
    }
    public int getColumnsSize() {
        return matrix[0].length;
    }

    public boolean isEmpty() {

        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 7; j++)
                if ('.' != matrix[i][j])
                    return false;

        return true;
    }

    public void emptyGrid(){
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 7; j++)
                matrix[i][j] = '.';
    }

    public String getGridAsString(){
        StringBuilder gridString = new StringBuilder();

        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 7; j++)
                gridString.append(matrix[i][j]);

        return gridString.toString();
    }
}
