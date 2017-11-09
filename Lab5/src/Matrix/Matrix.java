package Matrix;

class Matrix {
    private int[][] matrix;
    private int width, height;

    public Matrix(int _width, int _height){
        width=_width; height=_height;
        matrix = new int[width][height];
    }

    public Matrix(int _width, int _height, int[][] numbers){
        width=_width; height=_height;
        matrix = new int[width][height];
        matrix = numbers.clone();

    }

    public Matrix Add(Matrix another) throws MatrixDimensionsException {
        if (width!=another.GetWidth() || height!=another.GetHeight()){
            throw new MatrixDimensionsException();
        }else{
            Matrix resultMatrix = new Matrix(width,height);
            for (int i=0; i<width; i++){
                for (int j=0; j<height; j++){
                    resultMatrix.SetElement(i,j, matrix[i][j]+another.GetElement(i,j));
                }
            }
            return resultMatrix;
        }

    }

    public Matrix Sub(Matrix another) throws MatrixDimensionsException {
        if (width!=another.GetWidth() || height!=another.GetHeight()){
            throw new MatrixDimensionsException();
        }else{
            Matrix resultMatrix = new Matrix(width,height);
            for (int i=0; i<width; i++){
                for (int j=0; j<height; j++){
                    resultMatrix.SetElement(i,j, matrix[i][j]-another.GetElement(i,j));
                }
            }
            return resultMatrix;
        }
    }

    public Matrix Mul(Matrix another) throws MatrixDimensionsException {
        if(width!=another.GetHeight()){
            throw new MatrixDimensionsException();
        }else{
            Matrix resultMatrix = new Matrix(width,height);
            int sum=0;
            for (int i=0; i<height; i++){
                for (int j=0; j<another.GetWidth(); j++){
                    for (int k=0; k<width; k++){
                        sum+=matrix[k][i]*another.GetElement(j,k);
                    }
                    resultMatrix.SetElement(j,i,sum);
                    sum=0;
                }
            }
            return resultMatrix;
        }

    }

    public int GetWidth(){
        return width;
    }

    public int GetHeight(){
        return height;
    }

    public int GetElement(int a, int b){
        return matrix[a][b];
    }

    public void SetElement(int a, int b, int value){
        matrix[a][b]=value;
    }

    public void Print(){
        for (int i=0; i<height; i++){
            for (int j=0; j<width; j++){
                System.out.print(matrix[i][j]+", ");
            }
            System.out.println();
        }
    }
}

