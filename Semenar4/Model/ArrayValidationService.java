package Semenar4.Model;

public class ArrayValidationService  implements IArrayValidationService{

    @Override
    public ValidationResult validate(double[][] a, double[][] b) {
         //проверки
         if (a == null || a.length == 0 || a[0] == null || a[0].length == 0) {
            return ValidationResult.MatrixA;      
        }
        if (b == null || b.length == 0 || b[0] == null || b[0].length == 0) {
            return ValidationResult.MatrixB;      
        }
        if (a[0].length != b.length) {
            return ValidationResult.Uncoordinated;   
        }    


        return ValidationResult.OK;
    }
   
}
