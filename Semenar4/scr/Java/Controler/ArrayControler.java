package Semenar4.scr.Java.Controler;

import Semenar4.scr.Java.Controler.Helpers.IArrayToMatrixConvertor;
import Semenar4.scr.Java.Controler.Helpers.IMatrixToArrayConvertor;
import Semenar4.scr.Java.Model.IArrayMultiplayService;
import Semenar4.scr.Java.Model.IArrayValidationService;
import Semenar4.scr.Java.Model.ValidationResult;
import Semenar4.scr.Java.View.Request;
import Semenar4.scr.Java.View.Response;

public class ArrayControler {
    private IArrayMultiplayService multiplayService;
    private IArrayValidationService validationService;
    private IArrayToMatrixConvertor arrayToMatrixConvertor;
    private IMatrixToArrayConvertor matrixToArrayConvertor;

    public ArrayControler(IArrayMultiplayService multiplayService,IArrayValidationService validationService, IArrayToMatrixConvertor arrayToMatrixConvertor, IMatrixToArrayConvertor matrixToArrayConvertor){
        this.multiplayService = multiplayService;
        this.arrayToMatrixConvertor = arrayToMatrixConvertor;
        this.matrixToArrayConvertor = matrixToArrayConvertor;
        this.validationService = validationService;
    } 

    public Response multiplay(Request request){
        double [][] a = matrixToArrayConvertor.matrixToArray(request.a); 
        double [][] b = matrixToArrayConvertor.matrixToArray(request.b); 
        ValidationResult validationResult = validationService.validate(a, b);
        if (validationResult == ValidationResult.OK) {
            double [][] result = multiplayService.multiply(a,b);
            Response response = new Response();
            response.isSuccess = true;
            response.result = arrayToMatrixConvertor.ArrayToMatrix(result);
            return response;
        }
        Response response = new Response();
        response.isSuccess = false;
        response.ErorrMessage = validationResult.toString();
        return response;
    }
}
